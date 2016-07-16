package com.jbb.enterprise.app.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbb.enterprise.app.request.company.AreaRequest;
import com.jbb.enterprise.app.response.common.CommonListResponse;
import com.jbb.user.api.service.CommonService;
import com.jbb.user.api.service.OrderService;
import com.jbb.user.biz.entity.Area;
import com.jbb.user.biz.entity.Category;
import com.jbb.user.biz.entity.Industry;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value = "Common", description = "公共数据接口")
@RestController
@RequestMapping("/common")
public class CommonController {

	@Resource
	private CommonService commonService;

	@Resource
	private OrderService orderService;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "获取全国各城市编码", notes = "获取全国各城市编码")
	@RequestMapping(value = "/getAreaList", method = RequestMethod.GET, produces = { "application/json" })
	public CommonListResponse<Area> getAreaList(@ModelAttribute AreaRequest area) {
		CommonListResponse<Area> response = new CommonListResponse<Area>();
		Area source = new Area();
		BeanUtils.copyProperties(area, source);
		List<Area> list = commonService.getAreaList(source);
		response.setList(list);
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "获取全国各城市编码", notes = "获取全国各城市编码")
	@RequestMapping(value = "/getAllAreaList", method = RequestMethod.GET, produces = { "application/json" })
	public CommonListResponse<Area> getAllAreaList() {
		CommonListResponse<Area> response = new CommonListResponse<Area>();
		List<Area> list = commonService.getAllAreaList();
		response.setList(list);
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "获取行业信息", notes = "获取行业信息")
	@RequestMapping(value = "/getIndustryList", method = RequestMethod.GET, produces = { "application/json" })
	public CommonListResponse<Industry> getIndustryList() {
		CommonListResponse<Industry> response = new CommonListResponse<Industry>();
		List<Industry> list = commonService.getIndustyList();
		response.setList(list);
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "获取申报类型", notes = "获取申报类型")
	@RequestMapping(value = "/listType", method = RequestMethod.GET, produces = { "application/json" })
	public CommonListResponse<Category> listKeepingType(
			@RequestParam(value = "groupName", required = true) String groupName) {
		CommonListResponse<Category> response = new CommonListResponse<Category>();
		List<Category> list = commonService.listKeepingType(groupName);
		response.setList(list);
		return response;

	}

}
