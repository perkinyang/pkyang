/**
 * 
 */
package com.jbb.enterprise.app.rest;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbb.enterprise.app.response.common.CommonListResponse;
import com.jbb.user.api.service.OrderService;
import com.jbb.user.biz.entity.Product;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author yangxiangqian
 *
 */
@Api(value = "Company", description = "注册公司")
@RestController
@RequestMapping("/company")
public class RegisterComapnyController {

	@Resource
	private OrderService orderService;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "注册公司套餐类型", notes = "注册公司套餐类型")
	@RequestMapping(value = "/listType", method = RequestMethod.GET, produces = { "application/json" })
	public CommonListResponse<Product> listCompanyProduct(
			@RequestParam(value = "cityCode", required = true) String cityCode) {
		CommonListResponse<Product> commonObjectResponse = new CommonListResponse<>();
		commonObjectResponse.setList(orderService.listCompanyProduct(cityCode));
		return commonObjectResponse;
	}

}
