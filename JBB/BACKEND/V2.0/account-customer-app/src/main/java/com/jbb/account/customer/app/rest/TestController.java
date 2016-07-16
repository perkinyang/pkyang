package com.jbb.account.customer.app.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbb.account.customer.app.enums.ClientCode;
import com.jbb.account.customer.app.request.CityListRequest;
import com.jbb.account.customer.app.response.CityListResponse;
import com.jbb.account.customer.app.utils.ResponseUtils;
import com.jbb.user.center.api.dto.CityDTO;
import com.jbb.user.center.api.service.CityService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;


@Api(value = "City", description = "城市相关接口")
@RestController
@RequestMapping("/city")
public class TestController {
	
	@Resource
	private CityService cityService;
	
	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "城市列表", notes = "城市列表")
	@RequestMapping(value = "/list",method=RequestMethod.POST,produces={"application/json"})
	public CityListResponse cityList(@RequestBody CityListRequest request) {
		CityListResponse response=new CityListResponse();
		if(request==null){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		List<CityDTO> list=cityService.getAreaList();
		response.setList(list);
		return response;
	}
}
