package com.jbb.enterprise.app.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbb.enterprise.app.utils.ImageMessage;
import com.jbb.enterprise.app.utils.InputMessage;
import com.jbb.enterprise.app.utils.OutputMessage;
import com.jbb.enterprise.app.utils.SerializeXmlUtil;
import com.jbb.enterprise.app.utils.SignUtil;
import com.thoughtworks.xstream.XStream;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value = "Auth", description = "数据验证接口")
@RestController
@RequestMapping("/auth")
public class AuthorizationController {

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "获取申报类型", notes = "获取申报类型")
	@RequestMapping(value = "/weixin", method = { RequestMethod.GET, RequestMethod.POST })
	public void listKeepingType(HttpServletRequest request, HttpServletResponse response) throws IOException { // 微信加密签名
		boolean isGet = request.getMethod().toLowerCase().equals("get");
		if (isGet) {
			System.out.println("进入验证access");
			String signature = request.getParameter("signature");// 微信加密签名
			String timestamp = request.getParameter("timestamp");// 时间戳
			String nonce = request.getParameter("nonce");// 随机数
			String echostr = request.getParameter("echostr");// 随机字符串
			PrintWriter out = response.getWriter();
			// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
			if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				out.print(echostr);
			}
			out.close();
			out = null;
		} else {
			// 进入POST聊天处理
			System.out.println("enter post");
			try {
				// 接收消息并返回消息
				acceptMessage(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void acceptMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 处理接收消息
		ServletInputStream in = request.getInputStream();
		// 将POST流转换为XStream对象
		XStream xs = SerializeXmlUtil.createXstream();
		xs.processAnnotations(InputMessage.class);
		xs.processAnnotations(OutputMessage.class);
		// 将指定节点下的xml节点数据映射为对象
		xs.alias("xml", InputMessage.class);
		// 将流转换为字符串
		StringBuilder xmlMsg = new StringBuilder();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			xmlMsg.append(new String(b, 0, n, "UTF-8"));
		}
		// 将xml内容转换为InputMessage对象
		InputMessage inputMsg = (InputMessage) xs.fromXML(xmlMsg.toString());

		String servername = inputMsg.getToUserName();// 服务端
		String custermname = inputMsg.getFromUserName();// 客户端
		long createTime = inputMsg.getCreateTime();// 接收时间
		Long returnTime = Calendar.getInstance().getTimeInMillis() / 1000;// 返回时间

		// 取得消息类型
		String msgType = inputMsg.getMsgType();

		System.out.println("msgType+_________________" + msgType);
		// 根据消息类型获取对应的消息内容
		if (msgType.equals(MsgType.Text.toString())) {
			// 文本消息
			System.out.println("开发者微信号：" + inputMsg.getToUserName());
			System.out.println("发送方帐号：" + inputMsg.getFromUserName());
			System.out.println("消息创建时间：" + inputMsg.getCreateTime() + new Date(createTime * 1000l));
			System.out.println("消息内容：" + inputMsg.getContent());
			System.out.println("消息Id：" + inputMsg.getMsgId());

			StringBuffer str = new StringBuffer();
			str.append("<xml>");
			str.append("<ToUserName><![CDATA[" + custermname + "]]></ToUserName>");
			str.append("<FromUserName><![CDATA[" + servername + "]]></FromUserName>");
			str.append("<CreateTime>" + returnTime + "</CreateTime>");
			str.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");
			str.append("<Content><![CDATA[你说的是：" + inputMsg.getContent() + "，吗？]]></Content>");
			str.append("</xml>");
			System.out.println(str.toString());
			response.getWriter().write(str.toString());
		}
		// 获取并返回多图片消息
		if (msgType.equals(MsgType.Image.toString())) {
			System.out.println("获取多媒体信息");
			System.out.println("多媒体文件id：" + inputMsg.getMediaId());
			System.out.println("图片链接：" + inputMsg.getPicUrl());
			System.out.println("消息id，64位整型：" + inputMsg.getMsgId());

			OutputMessage outputMsg = new OutputMessage();
			outputMsg.setFromUserName(servername);
			outputMsg.setToUserName(custermname);
			outputMsg.setCreateTime(returnTime);
			outputMsg.setMsgType(msgType);
			ImageMessage images = new ImageMessage();
			images.setMediaId(inputMsg.getMediaId());
			outputMsg.setImage(images);
			System.out.println("xml转换：/n" + xs.toXML(outputMsg));
			response.getWriter().write(xs.toXML(outputMsg));

		} else {
			// 文本消息
			System.out.println("开发者微信号：" + inputMsg.getToUserName());
			System.out.println("发送方帐号：" + inputMsg.getFromUserName());
			System.out.println("消息创建时间：" + inputMsg.getCreateTime() + new Date(createTime * 1000l));
			System.out.println("消息内容：" + inputMsg.getContent());
			System.out.println("消息Id：" + inputMsg.getMsgId());

			StringBuffer str = new StringBuffer();
			str.append("<xml>");
			str.append("<ToUserName><![CDATA[" + custermname + "]]></ToUserName>");
			str.append("<FromUserName><![CDATA[" + servername + "]]></FromUserName>");
			str.append("<CreateTime>" + returnTime + "</CreateTime>");
			str.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");
			str.append("<Content><![CDATA[你说的是：" + inputMsg.getContent() + "，吗？]]></Content>");
			str.append("</xml>");
			System.out.println(str.toString());
			response.getWriter().write(str.toString());
		
		}
	}

}
