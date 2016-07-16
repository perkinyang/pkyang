/**
 * 
 */
package com.jbb.enterprise.app.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.jbb.enterprise.app.request.order.PaymentInfoRequest;
import com.jbb.user.api.service.PaymentService;
import com.jbb.user.biz.entity.PaymentInfo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author yangxiangqian
 *
 */
@Api(value = "pay", description = "支付相关接口")
@RestController
@RequestMapping("/pay")
public class PaymentController {

	@Resource
	private PaymentService paymentService;

	private static Logger logger = Logger.getLogger(PaymentController.class);

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "支付回调", notes = "支付回调")
	@RequestMapping(value = "/payinfo", method = RequestMethod.POST, produces = { "application/json" })
	public String payinfo(@RequestBody PaymentInfoRequest paymentInfoRequest, HttpServletRequest request)
			throws IOException {
		logger.info("paymentInfoRequest:" + paymentInfoRequest);
		//loginf(request);
		if (paymentInfoRequest.getSign()
				.equalsIgnoreCase(MD5.GetMD5Code(appId + appSecret + paymentInfoRequest.getTimestamp()))) {
			PaymentInfo paymentInfo = new PaymentInfo();
			BeanUtils.copyProperties(paymentInfoRequest, paymentInfo);
			paymentInfo.setMessageDetail(JSONObject.toJSONString(paymentInfoRequest.getMessageDetail()));
			paymentInfo.setOptional(JSONObject.toJSONString(paymentInfoRequest.getOptional()));
			paymentService.save(paymentInfo);
		} else {
			logger.error("合法验证不通过" + paymentInfoRequest);
		}

		return "success";

	}

	public static void main(String[] args) {
		System.out.println(MD5.GetMD5Code(appId + appSecret + "1460882040000"));
		// 1460882040000
	}

	private static String appId = "8276ee16-71b9-4c9e-af18-ba2c24c35ad3";

	private static String appSecret = "9dfd580e-96d7-4b05-9213-6c9e0910b5f1";

	private void getAllParamter(HttpServletRequest request) {
		Map map = new HashMap();
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();

			String[] paramValues = request.getParameterValues(paramName);
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() != 0) {
					System.out.println("参数：" + paramName + "=" + paramValue);
					logger.info("参数：" + paramName + "=" + paramValue);
					map.put(paramName, paramValue);
				}
			}
		}
	}

	private void loginf(HttpServletRequest request) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}

		// 将资料解码
		String reqBody = sb.toString();
		logger.info(reqBody);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "支付回调", notes = "支付回调")
	@RequestMapping(value = "/payinfotest", method = RequestMethod.POST, produces = { "application/json" })
	public String payinfo(HttpServletRequest request) throws IOException {

		// BeanUtils.copyProperties(paymentInfoRequest, paymentInfo);
		// paymentService.save(paymentInfo);

		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}

		// 将资料解码
		String reqBody = sb.toString();
		logger.info(reqBody);
		return "success";

	}

	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}

class MD5 {

	// 全局数组
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	public MD5() {
	}

	// 返回形式为数字跟字符串
	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		// System.out.println("iRet="+iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return strDigits[iD1] + strDigits[iD2];
	}

	// 返回形式只为数字
	private static String byteToNum(byte bByte) {
		int iRet = bByte;
		System.out.println("iRet1=" + iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		return String.valueOf(iRet);
	}

	// 转换字节数组为16进制字串
	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}

	public static String GetMD5Code(String strObj) {
		String resultString = null;
		try {
			resultString = new String(strObj);
			MessageDigest md = MessageDigest.getInstance("MD5");
			// md.digest() 该函数返回值为存放哈希值结果的byte数组
			resultString = byteToString(md.digest(strObj.getBytes()));
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return resultString;
	}

	public static void main(String[] args) {
		MD5 getMD5 = new MD5();
		System.out.println(getMD5.GetMD5Code("000000"));
	}
}
