package com.jbb.account.customer.app.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbb.account.customer.app.enums.ClientCode;
import com.jbb.account.customer.app.request.order.AddOrderRequest;
import com.jbb.account.customer.app.request.order.GetLatestOrderRequest;
import com.jbb.account.customer.app.request.order.GetOrderDetailRequest;
import com.jbb.account.customer.app.request.order.GetOrderListRequest;
import com.jbb.account.customer.app.response.Response;
import com.jbb.account.customer.app.response.order.GetOrderDetailResponse;
import com.jbb.account.customer.app.response.order.GetOrderListResponse;
import com.jbb.account.customer.app.utils.ResponseUtils;
import com.jbb.account.order.api.dto.OrderDTO;
import com.jbb.account.order.api.dto.OrderDetailDTO;
import com.jbb.account.order.api.service.OrderService;
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

	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "订单列表", notes = "订单列表")
	@RequestMapping(value = "/getOrderList",method=RequestMethod.POST,produces={"application/json"})
	public GetOrderListResponse getOrderList(@RequestBody GetOrderListRequest request) {
		GetOrderListResponse response=new GetOrderListResponse();
		if(request==null|| StringUtils.isEmpty(request.getTelephone())){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		List<OrderDTO> list=orderService.queryOrderList(request.getTelephone(),request.getRequestTime(),request.getStartMonth(),request.getStatus());
		response.setList(list);
		return response;
	}
	
	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "最新一条订单", notes = "最新一条订单")
	@RequestMapping(value = "/getLatestOrder",method=RequestMethod.POST,produces={"application/json"})
	public GetOrderDetailResponse getLatestOrder(@RequestBody GetLatestOrderRequest request) {
		GetOrderDetailResponse response=new GetOrderDetailResponse();
		if(request==null|| request.getTelephone()==null){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		OrderDetailDTO detail=orderService.getLastestOrder(request.getTelephone());
		response.setDetail(detail);
		return response;
	}

	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
	@ApiOperation(value = "订单详情", notes = "订单详情")
	@RequestMapping(value = "/getDetail",method=RequestMethod.POST,produces={"application/json"})
	public GetOrderDetailResponse validateCode(@RequestBody GetOrderDetailRequest request) {
		GetOrderDetailResponse response=new GetOrderDetailResponse();
		if(request==null|| request.getOrderId()<=0){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		OrderDetailDTO detail=orderService.getOrderDetail(request.getOrderId());
		response.setDetail(detail);
		return response;
	}

	@ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
	@ApiOperation(value = "下单", notes = "下单")
	@RequestMapping(value = "/publisherOrder",method=RequestMethod.POST,produces={"application/json"})
	public Response publisherOrder(@RequestBody AddOrderRequest request) {
		Response response=new Response();
		if(request==null){
			ResponseUtils.setErrorResponse(response, ClientCode.BAD_REQUEST);
			return response;
		}
		OrderDTO dto=new OrderDTO();
		BeanUtils.copyProperties(request,dto);
        orderService.saveOrder(dto);
		return response;
	}


	
}
