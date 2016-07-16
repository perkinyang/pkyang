package com.jbb.account.customer.app.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbb.account.customer.app.response.CityListResponse;
import com.jbb.user.center.api.dto.CityDTO;
import com.jbb.user.center.api.service.CityService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value = "Common", description = "公共数据接口")
@RestController
@RequestMapping("/common")
public class CommonController {
	
	@Resource
	private CityService cityService;


	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "获取全国各城市编码", notes = "获取全国各城市编码")
	@RequestMapping(value = "/getAreaList",method=RequestMethod.POST,produces={"application/json"})
	public CityListResponse getAreaList() {
		CityListResponse response=new CityListResponse();
		List<CityDTO> list=cityService.getAreaList();
		response.setList(list);
		return response;
	}

	
}
