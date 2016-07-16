package com.jbb.account.customer.app.rest;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbb.account.customer.app.enums.ClientCode;
import com.jbb.account.customer.app.request.findaccountant.FindAccountRequest;
import com.jbb.account.customer.app.response.Response;
import com.jbb.account.customer.app.utils.ResponseUtils;
import com.jbb.account.order.api.dto.FindAccountantDTO;
import com.jbb.account.order.api.service.FindAccountantService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value = "FindAccountant", description = "找专业会计相关接口")
@RestController
@RequestMapping("/findAccountant")
public class FindAccountController {
	
	@Resource
	private FindAccountantService findAccountantService;

	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "找专业会计", notes = "找专业会计")
	@RequestMapping(value = "/find",method=RequestMethod.POST,produces={"application/json"})
	public Response find(@RequestBody FindAccountRequest request) {
		Response response=new Response();
		if(request==null){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		FindAccountantDTO dto=new FindAccountantDTO();
		BeanUtils.copyProperties(request,dto);
		findAccountantService.save(dto);
		return response;
	}

}
