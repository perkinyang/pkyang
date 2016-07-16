package com.jbb.enterprise.app.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbb.enterprise.app.enums.ClientCode;
import com.jbb.enterprise.app.request.company.GetCodeRequest;
import com.jbb.enterprise.app.request.user.SetDetailRequest;
import com.jbb.enterprise.app.request.user.SetPwdRequest;
import com.jbb.enterprise.app.request.user.UpdatePwdRequest;
import com.jbb.enterprise.app.request.user.UserLoginRequest;
import com.jbb.enterprise.app.request.user.ValidateCodeRequest;
import com.jbb.enterprise.app.response.Response;
import com.jbb.enterprise.app.response.company.SetDetailResponse;
import com.jbb.enterprise.app.response.user.GetAuthCodeResponse;
import com.jbb.enterprise.app.response.user.GetDetailResponse;
import com.jbb.enterprise.app.response.user.UserLoginResponse;
import com.jbb.enterprise.app.utils.ResponseUtils;
import com.jbb.user.api.dto.UserDTO;
import com.jbb.user.api.dto.UserLoginDTO;
import com.jbb.user.api.service.UserInfoService;
import com.jbb.user.api.service.UserLoginService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value = "UserLogin", description = "用户登录相关接口")
@RestController
@RequestMapping("/user")
public class UserLoginController {

	@Resource
	private UserLoginService userLoginService;
	
	@Resource
	private UserInfoService userInfoService;

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
	public Response validateCode(@RequestBody ValidateCodeRequest request) {
		Response response=new Response();
		if(StringUtils.isEmpty(request.getTelephone())){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		if(StringUtils.isEmpty(request.getSmsAuthCode()) || !"123456".equals(request.getSmsAuthCode())){
			ResponseUtils.setErrorResponse(response, ClientCode.CHECK_VERIFYCODE_NOTEXIST);
			return response;
		}		
		UserDTO dto=userInfoService.findByTelephone(request.getTelephone());
		if(dto!=null){
			ResponseUtils.setErrorResponse(response, ClientCode.USER_EXIST);	
		}
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
		UserLoginDTO dto=userLoginService.findByTelephone(request.getTelephone());
		if(dto!=null){
			ResponseUtils.setErrorResponse(response, ClientCode.USER_EXIST);	
		}else{
			userLoginService.setPwd(request.getTelephone(), request.getSmsCode(), request.getPasswd());
		}	
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
    @ApiOperation(value = "忘记密码后修改密码", notes = "忘记密码后修改密码")
	@RequestMapping(value = "/findPwd",method=RequestMethod.POST,produces={"application/json"})
	public Response findPwd(@RequestBody SetPwdRequest request) {
		Response response=new Response();
		if(request==null|| StringUtils.isEmpty(request.getTelephone()) || StringUtils.isEmpty(request.getPasswd()) || StringUtils.isEmpty(request.getSmsCode())){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}	
		UserLoginDTO dto=userLoginService.findByTelephone(request.getTelephone());
		if(dto!=null){
			userLoginService.updatePwd(request.getTelephone(),request.getPasswd());			
		}else{
			ResponseUtils.setErrorResponse(response, ClientCode.USER_NOT_EXIST);	
		}	
		return response;
	}

	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
	@ApiOperation(value = "用户登录", notes = "用户登录")
	@RequestMapping(value = "/login",method=RequestMethod.POST,produces={"application/json"})
	public UserLoginResponse login(@RequestBody UserLoginRequest request, HttpServletRequest servletRequest) {
		UserLoginResponse response=new UserLoginResponse();
		if(request==null|| StringUtils.isEmpty(request.getTelephone())){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		UserLoginDTO dto=userLoginService.login(request.getTelephone(),request.getPasswd());
		if(dto==null){
			ResponseUtils.setErrorResponse(response, ClientCode.LOGIN_ERROR);
		}else{
			servletRequest.setAttribute("user", dto);	
			UserDTO userDTO=userInfoService.findByTelephone(dto.getTelephone());	
			response.setUserDTO(userDTO);
			response.setUserLogin(dto);
		}
		return response;
	}
}
