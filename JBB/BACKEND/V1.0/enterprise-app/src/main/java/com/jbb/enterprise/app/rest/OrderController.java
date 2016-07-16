package com.jbb.enterprise.app.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbb.enterprise.app.enums.ClientCode;
import com.jbb.enterprise.app.request.order.AddOrderRequest;
import com.jbb.enterprise.app.request.order.GetOrderDetailRequest;
import com.jbb.enterprise.app.request.order.GetOrderListRequest;
import com.jbb.enterprise.app.request.order.IntentionRequest;
import com.jbb.enterprise.app.request.order.OrderDetailRequest;
import com.jbb.enterprise.app.request.order.OrderJbbRequest;
import com.jbb.enterprise.app.request.order.RechargeRequest;
import com.jbb.enterprise.app.request.order.UpdateOrderPriceRequest;
import com.jbb.enterprise.app.response.Response;
import com.jbb.enterprise.app.response.common.CommonListResponse;
import com.jbb.enterprise.app.response.common.CommonObjectResponse;
import com.jbb.enterprise.app.response.order.GetOrderDetailResponse;
import com.jbb.enterprise.app.response.order.GetOrderListResponse;
import com.jbb.enterprise.app.utils.ResponseUtils;
import com.jbb.user.api.dto.OrderDTO;
import com.jbb.user.api.dto.OrderJbbDTO;
import com.jbb.user.api.service.OrderService;
import com.jbb.user.biz.entity.Intention;
import com.jbb.user.biz.entity.IntentionStatus;
import com.jbb.user.biz.entity.OrderDetailJbb;
import com.jbb.user.biz.entity.OrderStatus;
import com.jbb.user.biz.entity.OrderStatusFlow;
import com.jbb.user.biz.entity.PaymentInfo;
import com.jbb.user.biz.entity.Product;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value = "Order", description = "订单相关接口")
@RestController
@RequestMapping("/order")
public class OrderController {

	@Resource
	private OrderService orderService;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "订单列表", notes = "订单列表")
	@RequestMapping(value = "/getOrderList", method = RequestMethod.POST, produces = { "application/json" })
	public GetOrderListResponse getOrderList(@RequestBody GetOrderListRequest request) {
		GetOrderListResponse response = new GetOrderListResponse();
		if (request == null || StringUtils.isEmpty(request.getTelephone())) {
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		List<OrderDTO> list = orderService.queryOrderList(request.getTelephone(), request.getRequestTime(),
				request.getStartMonth(), request.getStatus());
		response.setList(list);
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "订单详情", notes = "订单详情")
	@RequestMapping(value = "/getDetail", method = RequestMethod.POST, produces = { "application/json" })
	public GetOrderDetailResponse validateCode(@RequestBody GetOrderDetailRequest request) {
		GetOrderDetailResponse response = new GetOrderDetailResponse();
		if (request == null || request.getOrderId() <= 0) {
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		OrderDTO detail = orderService.getOrderDetail(request.getOrderId());
		response.setDetail(detail);
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "下单", notes = "下单")
	@RequestMapping(value = "/publisherOrder", method = RequestMethod.POST, produces = { "application/json" })
	public Response publisherOrder(@RequestBody AddOrderRequest request) {
		Response response = new Response();
		if (request == null) {
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		OrderDTO dto = new OrderDTO();
		BeanUtils.copyProperties(request, dto);
		orderService.saveOrder(dto);
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "意向", notes = "意向提交接口")
	@RequestMapping(value = "/saveIntention", method = RequestMethod.POST, produces = { "application/json" })
	public Response saveIntention(@RequestBody IntentionRequest intentionRequest) {
		Intention intention = new Intention();
		Response response = new Response();
		BeanUtils.copyProperties(intentionRequest, intention);
		orderService.saveIntention(intention);
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "改变意向状态", notes = "改变意向状态")
	@RequestMapping(value = "/changeIntentionStatus", method = RequestMethod.POST, produces = { "application/json" })
	public Response changeIntentionStatus(@RequestParam(value = "id", required = true) long id,
			@RequestParam(value = "statusCode", required = true) String statusCode) {
		Response response = new Response();
		int userid = com.jbb.enterprise.app.interceptor.UserConextInterceptor.loginContext.get() == null ? 0
				: com.jbb.enterprise.app.interceptor.UserConextInterceptor.loginContext.get().getId().intValue();
		orderService.updateIntentionStatus(id, statusCode, userid);
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "意向状态列表", notes = "意向状态列表")
	@RequestMapping(value = "/intentionStatusList", method = RequestMethod.GET, produces = { "application/json" })
	public CommonListResponse<IntentionStatus> intentionStatusList() {
		CommonListResponse<IntentionStatus> response = new CommonListResponse<>();
		response.setList(orderService.intentionStatusList());
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "订单状态列表", notes = "订单状态列表")
	@RequestMapping(value = "/orderStatusList", method = RequestMethod.GET, produces = { "application/json" })
	public CommonListResponse<OrderStatus> orderStatusList() {
		CommonListResponse<OrderStatus> response = new CommonListResponse<>();
		response.setList(orderService.orderStatusList());
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "改变订单状态", notes = "改变订单状态")
	@RequestMapping(value = "/changeOrderStatus", method = RequestMethod.POST, produces = { "application/json" })
	public Response changeOrderStatus(@RequestParam(value = "id", required = true) long id,
			@RequestParam(value = "statusCode", required = true) String statusCode) {
		Response response = new Response();
		int userid = com.jbb.enterprise.app.interceptor.UserConextInterceptor.userContext.get() == null ? 0
				: com.jbb.enterprise.app.interceptor.UserConextInterceptor.userContext.get().getId();
		orderService.changeOrderStatus(id, statusCode, userid);
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "下单", notes = "下单")
	@RequestMapping(value = "/saveOrder", method = RequestMethod.POST, produces = { "application/json" })
	public Response saveOrder(@RequestBody OrderJbbRequest orderJbbRequest) {
		CommonObjectResponse<String> response = new CommonObjectResponse<String>();
		List<OrderDetailRequest> detailRequests = orderJbbRequest.getOrderDetailRequest();
		List<OrderDetailJbb> detailJbbs = new ArrayList<OrderDetailJbb>();
		for (OrderDetailRequest request : detailRequests) {
			OrderDetailJbb detailJbb = new OrderDetailJbb();
			detailJbb.setProductId(Long.valueOf(request.getProductId()));
			detailJbb.setQuantity(request.getQuantity() + "");
			detailJbb.setNumber(orderJbbRequest.getNumber());
			detailJbbs.add(detailJbb);
		}
		int userid = com.jbb.enterprise.app.interceptor.UserConextInterceptor.userContext.get() == null ? 0
				: com.jbb.enterprise.app.interceptor.UserConextInterceptor.userContext.get().getId();
		response.setObj(orderService.saveOrder(detailJbbs, userid));
		return response;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "订单列表", notes = "订单列表")
	@RequestMapping(value = "/getOrderList", method = RequestMethod.GET, produces = { "application/json" })
	public Response getOrder(@RequestParam(value = "userId", required = false) Long userId) {
		CommonListResponse<OrderJbbDTO> response = new CommonListResponse<OrderJbbDTO>();
		int useridSession = com.jbb.enterprise.app.interceptor.UserConextInterceptor.userContext.get() == null ? 0
				: com.jbb.enterprise.app.interceptor.UserConextInterceptor.userContext.get().getId();
		if (useridSession == 0 && null != userId) {
			useridSession = userId.intValue();
		}
		response.setList(orderService.getOrderDetails(useridSession));
		return response;

	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "返回处理流", notes = "返回处理流")
	@RequestMapping(value = "/getOrderStatusFlow", method = RequestMethod.GET, produces = { "application/json" })
	public Response getOrderStatusFlow(@RequestParam(value = "orderId", required = true) Long orderId) {
		CommonListResponse<OrderStatusFlow> response = new CommonListResponse<OrderStatusFlow>();
		response.setList(orderService.getOrderStatusFlow(orderId));
		return response;

	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "订单金额sync") })
	@ApiOperation(value = "订单金额sync", notes = "订单金额sync")
	@RequestMapping(value = "/syncPay", method = RequestMethod.POST, produces = { "application/json" })
	public String syncPay(@RequestBody PaymentInfo paymentInfo) {
		orderService.syncPay(paymentInfo);
		return "sucess";
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "400充值") })
	@ApiOperation(value = "400充值", notes = "400充值")
	@RequestMapping(value = "/recharge", method = RequestMethod.POST, produces = { "application/json" })
	public Response recharge(@RequestBody RechargeRequest rechargeRequest) {
		CommonObjectResponse<String> response = new CommonObjectResponse<String>();
		List<OrderDetailJbb> detailJbbs = new ArrayList<OrderDetailJbb>();
		OrderDetailJbb detailJbb = new OrderDetailJbb();
		detailJbb.setProductId(10030001l); // 充值productid
		detailJbb.setQuantity(rechargeRequest.getFee());
		detailJbb.setNumber(rechargeRequest.getNumber());
		detailJbb.setRemark("充值号码："+rechargeRequest.getNumber());
		detailJbbs.add(detailJbb);
		int userid = com.jbb.enterprise.app.interceptor.UserConextInterceptor.userContext.get() == null ? 0
				: com.jbb.enterprise.app.interceptor.UserConextInterceptor.userContext.get().getId();
		response.setObj(orderService.saveOrder(detailJbbs, userid));
		return response;

	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "改变订单价格", notes = "改变订单价格")
	@RequestMapping(value = "/updateOrderPrice", method = RequestMethod.POST, produces = { "application/json" })
	public Response updateOrderPrice(@RequestBody  UpdateOrderPriceRequest updateOrderPriceRequest ) {
		Response response = new Response();
		int userid = com.jbb.enterprise.app.interceptor.UserConextInterceptor.loginContext.get() == null ? 0
				: com.jbb.enterprise.app.interceptor.UserConextInterceptor.loginContext.get().getId().intValue();
		orderService.changeOrderPrice(updateOrderPriceRequest.getId(), updateOrderPriceRequest.getFee(), userid);
		return response;
	}

	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功") })
	@ApiOperation(value = "获取城市全部product", notes = "获取城市全部product")
	@RequestMapping(value = "/getCityProductList", method = RequestMethod.GET, produces = { "application/json" })
	public CommonListResponse<Product> getProductList(
			@RequestParam(value = "cityCode", required = true) Integer cityCode) {
		CommonListResponse<Product> commonObjectResponse = new CommonListResponse<>();
		commonObjectResponse.setList(orderService.getCityProductList(cityCode));
		return commonObjectResponse;
	}
}
