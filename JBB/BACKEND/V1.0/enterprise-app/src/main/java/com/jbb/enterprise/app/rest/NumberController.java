/**
 * 
 */
package com.jbb.enterprise.app.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbb.enterprise.app.response.common.CommonListResponse;
import com.jbb.enterprise.app.response.common.CommonObjectResponse;
import com.jbb.user.api.dto.NumberRequest;
import com.jbb.user.api.service.Number400Service;
import com.jbb.user.biz.entity.Number400;
import com.jbb.user.biz.entity.Product;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author yangxiangqian
 *
 */

@Api(value = "Number", description = "400数据接口")
@RestController
@RequestMapping("/number")
public class NumberController {

	@Resource
	private Number400Service numberService;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "获取号码", notes = "获取号码")
	@RequestMapping(value = "/getNumbers", method = RequestMethod.GET, produces = { "application/json" })
	public CommonListResponse<Number400> getAreaList(@ModelAttribute NumberRequest number) {
		CommonListResponse<Number400> response = new CommonListResponse<Number400>();
		List<Number400> numberList = numberService.getNumberList(number);
		response.setList(numberList);
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "获取服务", notes = "获取服务")
	@RequestMapping(value = "/getNumberServices", method = RequestMethod.GET, produces = { "application/json" })
	public CommonListResponse<com.jbb.user.biz.entity.Number400Service> getNumberServices() {
		CommonListResponse<com.jbb.user.biz.entity.Number400Service> response = new CommonListResponse<com.jbb.user.biz.entity.Number400Service>();
		List<com.jbb.user.biz.entity.Number400Service> numberList = numberService.getNumberServices();
		response.setList(numberList);
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "获取产品价格", notes = "获取产品价格")
	@RequestMapping(value = "/listProductPrice", method = RequestMethod.GET, produces = { "application/json" })
	public CommonListResponse<Product> listAllPrice(@RequestParam(required = false) String cityCode,
			@RequestParam(required = false) String cityName) {
		CommonListResponse<Product> response = new CommonListResponse<Product>();
		List<Product> prouctList = numberService.getProductList(cityCode,cityName);
		response.setList(prouctList);
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "获取最低价格", notes = "获取最低价格")
	@RequestMapping(value = "/getMinumnPrice", method = RequestMethod.GET, produces = { "application/json" })
	public CommonObjectResponse<Product> getMinumnPrice(@RequestParam(required = true) String number,@RequestParam(required = false) String cityCode,
			@RequestParam(required = false) String cityName) {
		CommonObjectResponse<Product> response = new CommonObjectResponse<Product>();
		Product product = numberService.getMinumnPrice(number,cityCode,cityName);
		response.setObj(product);
		return response;
	}

	public static void main(String[] args) {
		List<? extends Number> unknownNumberList = new ArrayList<>();
		Double e = new Double(12);
		// unknownNumberList.add(e);
	}

}
