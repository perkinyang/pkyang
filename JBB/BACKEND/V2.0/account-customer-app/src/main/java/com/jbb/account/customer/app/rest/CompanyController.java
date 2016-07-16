package com.jbb.account.customer.app.rest;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.account.provider.api.dto.CompanyDTO;
import com.account.provider.api.service.CompanyService;
import com.jbb.account.customer.app.enums.ClientCode;
import com.jbb.account.customer.app.request.company.GetDetailRequest;
import com.jbb.account.customer.app.request.company.SetDetailRequest;
import com.jbb.account.customer.app.response.company.GetDetailResponse;
import com.jbb.account.customer.app.response.company.SetDetailResponse;
import com.jbb.account.customer.app.utils.ResponseUtils;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value = "Company", description = "商家相关接口")
@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Resource
	private CompanyService companyService;

	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "获取商家资料", notes = "获取商家资料")
	@RequestMapping(value = "/getDetail",method=RequestMethod.POST,produces={"application/json"})
	public GetDetailResponse getDetail(@RequestBody GetDetailRequest request) {
		GetDetailResponse response=new GetDetailResponse();
		if(request==null || StringUtils.isEmpty(request.getTelephone())){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		CompanyDTO dto=companyService.findByTelephone(request.getTelephone());
		response.setCompany(dto);
		return response;
	}
	
	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "完善商家资料", notes = "完善商家资料")
	@RequestMapping(value = "/setDetail",method=RequestMethod.POST,produces={"application/json"})
	public SetDetailResponse setDetail(@RequestBody SetDetailRequest request) {
		SetDetailResponse response=new SetDetailResponse();
		if(request==null|| StringUtils.isEmpty(request.getTelephone())){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		CompanyDTO dto=new CompanyDTO();
		BeanUtils.copyProperties(request, dto);
		companyService.updateByTelephone(dto);
		return response;
	}

	
}
