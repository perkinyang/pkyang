package com.jbb.enterprise.app.rest;

import com.jbb.enterprise.app.enums.ClientCode;
import com.jbb.enterprise.app.request.user.GetDetailRequest;
import com.jbb.enterprise.app.request.user.SetDetailRequest;
import com.jbb.enterprise.app.response.company.SetDetailResponse;
import com.jbb.enterprise.app.response.user.GetDetailResponse;
import com.jbb.enterprise.app.utils.ResponseUtils;
import com.jbb.user.api.dto.UserDTO;
import com.jbb.user.api.service.UserInfoService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "UserInfo", description = "用户信息相关接口")
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
	
	@Resource
	private UserInfoService userInfoService;

	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "获取个人资料", notes = "获取个人资料")
	@RequestMapping(value = "/getDetail",method=RequestMethod.POST,produces={"application/json"})
	public GetDetailResponse getDetail(@RequestBody GetDetailRequest request) {
		GetDetailResponse response=new GetDetailResponse();
		if(request==null || StringUtils.isEmpty(request.getTelephone())){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		UserDTO dto=userInfoService.findByTelephone(request.getTelephone());
		response.setUser(dto);
		return response;
	}
	
	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "完善商家资料", notes = "完善商家资料")
	@RequestMapping(value = "/setPersonDetail",method=RequestMethod.POST,produces={"application/json"})
	public SetDetailResponse setDetail(@RequestBody SetDetailRequest request,@RequestHeader("telephone") String telephone) {
		SetDetailResponse response=new SetDetailResponse();
		if(request==null|| StringUtils.isEmpty(request.getTelephone())){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		UserDTO dto=new UserDTO();
		BeanUtils.copyProperties(request, dto);
		userInfoService.updateByTelephone(dto);
		return response;
	}
	
	
	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "完善商家资料", notes = "完善商家资料")
	@RequestMapping(value = "/setCompanyDetail",method=RequestMethod.POST,produces={"application/json"})
	public SetDetailResponse setCompanyDetail(@RequestBody SetDetailRequest request) {
		SetDetailResponse response=new SetDetailResponse();
		if(request==null|| StringUtils.isEmpty(request.getTelephone())){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		UserDTO dto=new UserDTO();
		BeanUtils.copyProperties(request, dto);
		userInfoService.updateCompanyDetailByTelephone(dto);
		return response;
	}


//	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
//	@ApiOperation(value = "完善商家资料", notes = "完善商家资料")
//	@RequestMapping(value = "/setDetail",method=RequestMethod.POST,produces={"application/json"})
//	public SetDetailResponse get(@RequestBody SetDetailRequest request) {
//		SetDetailResponse response=new SetDetailResponse();
//		if(request==null|| StringUtils.isEmpty(request.getTelephone())){
//			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
//			return response;
//		}
//		UserDTO dto=new UserDTO();
//		BeanUtils.copyProperties(request, dto);
//		userInfoService.updateByTelephone(dto);
//		return response;
//	}

	
}
