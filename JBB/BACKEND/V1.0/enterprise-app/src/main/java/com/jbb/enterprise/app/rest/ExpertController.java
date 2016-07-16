/**
 * 
 */
package com.jbb.enterprise.app.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbb.enterprise.app.enums.ClientCode;
import com.jbb.enterprise.app.request.user.UserLoginRequest;
import com.jbb.enterprise.app.response.Response;
import com.jbb.enterprise.app.response.common.CommonListResponse;
import com.jbb.enterprise.app.response.common.CommonObjectResponse;
import com.jbb.enterprise.app.utils.ResponseUtils;
import com.jbb.user.api.dto.OrderJbbDTO;
import com.jbb.user.api.service.OrderService;
import com.jbb.user.api.service.UserInfoService;
import com.jbb.user.api.service.UserLoginService;
import com.jbb.user.biz.entity.ExpertLogin;
import com.jbb.user.biz.entity.Intention;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author yangxiangqian
 *
 */
@Api(value = "Expert", description = "专家版接口")
@RestController
@RequestMapping("/expert")
public class ExpertController {

	@Resource
	private UserLoginService userLoginService;

	@Resource
	private UserInfoService userInfoService;

	@Resource
	private OrderService orderService;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "专家登录", notes = "专家登录")
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { "application/json" })
	public CommonObjectResponse<ExpertLogin> login(@RequestBody UserLoginRequest request,
			HttpServletRequest servletRequest) {
		CommonObjectResponse<ExpertLogin> response = new CommonObjectResponse<ExpertLogin>();
		if (request == null || StringUtils.isEmpty(request.getTelephone())) {
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		ExpertLogin dto = userLoginService.login(request.getTelephone(), request.getPasswd(), true);
		if (dto == null) {
			ResponseUtils.setErrorResponse(response, ClientCode.LOGIN_ERROR);
		}
		servletRequest.getSession().setAttribute("expert", dto);
		response.setObj(dto);
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "订单列表", notes = "订单列表")
	@RequestMapping(value = "/getOrderList", method = RequestMethod.GET, produces = { "application/json" })
	public Response getOrder() {
		CommonListResponse<OrderJbbDTO> response = new CommonListResponse<OrderJbbDTO>();
		response.setList(orderService.getOrderDetails(null));
		return response;

	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "订单列表", notes = "订单列表")
	@RequestMapping(value = "/getIntentionList", method = RequestMethod.GET, produces = { "application/json" })
	public Response getIntentionList() {
		CommonListResponse<Intention> response = new CommonListResponse<Intention>();
		response.setList(orderService.getIntentionList());
		return response;

	}

}
