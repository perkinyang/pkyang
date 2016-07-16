package com.jbb.account.customer.app.rest;

import javax.annotation.Resource;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbb.account.customer.app.enums.ClientCode;
import com.jbb.account.customer.app.request.user.GetCodeRequest;
import com.jbb.account.customer.app.request.user.SetPwdRequest;
import com.jbb.account.customer.app.request.user.UpdatePwdRequest;
import com.jbb.account.customer.app.request.user.UserLoginRequest;
import com.jbb.account.customer.app.request.user.ValidateCodeRequest;
import com.jbb.account.customer.app.response.Response;
import com.jbb.account.customer.app.response.user.GetAuthCodeResponse;
import com.jbb.account.customer.app.response.user.UserLoginResponse;
import com.jbb.account.customer.app.response.user.ValidateCodeResponse;
import com.jbb.account.customer.app.utils.ResponseUtils;
import com.jbb.user.center.api.dto.UserLoginDTO;
import com.jbb.user.center.api.service.UserLoginService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value = "User", description = "用户登录相关接口")
@RestController
@RequestMapping("/user")
public class UserLoginController {

	@Resource
	private UserLoginService userLoginService;

	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "注册获取获取验证码,目前没接短信接口，统一返回1234", notes = "注册获取获取验证码,目前没接短信接口，统一返回1234")
	@RequestMapping(value = "/getRegistAuthCode",method=RequestMethod.POST,produces={"application/json"})
	public GetAuthCodeResponse getRegistAuthCode(@RequestBody GetCodeRequest request) {
		GetAuthCodeResponse response=new GetAuthCodeResponse();
		if(response==null|| StringUtils.isEmpty(request.getTelephone())){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		response.setSmsAuthCode("1234");
		return response;
	}

	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
	@ApiOperation(value = "验证码是否正确", notes = "验证码是否正确")
	@RequestMapping(value = "/validateCode",method=RequestMethod.POST,produces={"application/json"})
	public ValidateCodeResponse validateCode(@RequestBody ValidateCodeRequest request) {
		ValidateCodeResponse response=new ValidateCodeResponse();
		if(response==null|| StringUtils.isEmpty(request.getTelephone())){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		
		response.setToken(System.currentTimeMillis()+"");
		return response;
	}

	
	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "设置密码", notes = "设置密码")
	@RequestMapping(value = "/setPwd",method=RequestMethod.POST,produces={"application/json"})
	public Response setPwd(@RequestBody SetPwdRequest request) {
		Response response=new Response();
		if(request==null|| StringUtils.isEmpty(request.getTelephone())){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		userLoginService.setPwd(request.getTelephone(), request.getUserName(), request.getPasswd());
		return response;
	}

	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
	@ApiOperation(value = "修改密码", notes = "修改密码")
	@RequestMapping(value = "/updatePwd",method=RequestMethod.POST,produces={"application/json"})
	public Response updatePwd(@RequestBody UpdatePwdRequest request) {
		Response response=new Response();
		if(request==null|| StringUtils.isEmpty(request.getTelephone())){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		UserLoginDTO dto= userLoginService.findByTelephone(request.getTelephone());
		if(dto!=null && dto.getPassword().equals(request.getOldPasswd())){
			userLoginService.updatePwd(request.getTelephone(),request.getNewpasswd());
		}else{
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		return response;
	}

	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
	@ApiOperation(value = "用户登录", notes = "用户登录")
	@RequestMapping(value = "/login",method=RequestMethod.POST,produces={"application/json"})
	public UserLoginResponse login(@RequestBody UserLoginRequest request) {
		UserLoginResponse response=new UserLoginResponse();
		if(request==null|| StringUtils.isEmpty(request.getTelephone())){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		UserLoginDTO dto=userLoginService.login(request.getTelephone(),request.getPasswd());
		if(dto==null){
			ResponseUtils.setErrorResponse(response, ClientCode.LOGIN_ERROR);
		}
		response.setUserLogin(dto);
		return response;
	}
	
	
}
