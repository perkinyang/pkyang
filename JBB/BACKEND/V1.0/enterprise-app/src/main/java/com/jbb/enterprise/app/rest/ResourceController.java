/**
 * 
 */
package com.jbb.enterprise.app.rest;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbb.enterprise.app.request.company.JbbResourceRequest;
import com.jbb.enterprise.app.response.common.CommonListResponse;
import com.jbb.enterprise.app.response.common.CommonObjectResponse;
import com.jbb.user.api.service.ResourceService;
import com.jbb.user.biz.entity.Area;
import com.jbb.user.biz.entity.JbbResource;
import com.qiniu.util.Auth;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author yangxiangqian
 *
 */
@Api(value = "Resource", description = "资源相关")
@RestController
@RequestMapping("/res")
public class ResourceController {

	@Resource
	private ResourceService resourceService;

	private static Logger logger = Logger.getLogger(ResourceController.class);

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "获取行业信息", notes = "获取行业信息")
	@RequestMapping(value = "/getResource", method = RequestMethod.GET, produces = { "application/json" })
	public CommonObjectResponse<JbbResource> getResource(@RequestParam(required = true) String resourceCode) {
		CommonObjectResponse<JbbResource> response = new CommonObjectResponse<>();
		response.setObj(resourceService.getResource(resourceCode));
		return response;
	}
	

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "获取首页列表", notes = "获取行业信息")
	@RequestMapping(value = "/getBusiness", method = RequestMethod.GET, produces = { "application/json" })
	public CommonListResponse<JbbResource> getBusiness(@ModelAttribute JbbResourceRequest resourceRequest) {
		CommonListResponse<JbbResource> response = new CommonListResponse<>();
		JbbResource source = new JbbResource();
		BeanUtils.copyProperties(resourceRequest, source);
		response.setList(resourceService.getBusiness(source));
		return response;
	}


	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "获取支持服务列表", notes = "获取支持服务列表")
	@RequestMapping(value = "/getBusinesseList", method = RequestMethod.GET, produces = { "application/json" })
	public CommonObjectResponse<List> getServiceList(@RequestParam(required = true) String city) {
		CommonObjectResponse<List> response = new CommonObjectResponse<>();
		response.setObj(resourceService.getServiceList(city));
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "获取七牛Auth", notes = "获取七牛Auth")
	@RequestMapping(value = "/getAuthKey", method = RequestMethod.GET, produces = { "application/json" })
	public CommonObjectResponse<String> getAuthKey() {
		CommonObjectResponse<String> response = new CommonObjectResponse<>();
		Auth auth = Auth.create("HTD7H-B2BTjh7M4nUMlKrd0rh53-odtLz2n_kYno", "yItyOFSFLQ03s51bDAe8CuXApK-yJnBMw87TCF59");
		response.setObj(auth.uploadToken("jbb"));
		return response;
	}

	public static void main(String[] args) { // Auth auth =
												// Auth.create(ACCESS_KEY,
												// SECRET_KEY);
		// System.out.println(MD5.GetMD5Code(appId + appSecret +
		// "1460882040000"));
		// 1460882040000
	}

}
