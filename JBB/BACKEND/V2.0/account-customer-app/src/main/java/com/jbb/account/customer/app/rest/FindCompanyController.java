package com.jbb.account.customer.app.rest;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbb.account.customer.app.enums.ClientCode;
import com.jbb.account.customer.app.request.findcompany.FindCompanyRequest;
import com.jbb.account.customer.app.response.Response;
import com.jbb.account.customer.app.utils.ResponseUtils;
import com.jbb.account.order.api.dto.FindCompanyDTO;
import com.jbb.account.order.api.service.FindCompanyService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value = "FindCompany", description = "找代账公司相关接口")
@RestController
@RequestMapping("/findCompany")
public class FindCompanyController {
	
	@Resource
	private FindCompanyService findCompanyService;

	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "找代账公司", notes = "找代账公司")
	@RequestMapping(value = "/find",method=RequestMethod.POST,produces={"application/json"})
	public Response find(@RequestBody FindCompanyRequest request) {
		Response response=new Response();
		if(request==null){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		FindCompanyDTO dto=new FindCompanyDTO();
		BeanUtils.copyProperties(request,dto);
		findCompanyService.save(dto);
		return response;
	}

}
