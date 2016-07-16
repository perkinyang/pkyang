package com.jbb.account.customer.app.response.order;

import java.util.List;

import com.jbb.account.customer.app.response.Response;
import com.jbb.account.order.api.dto.OrderDTO;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class GetOrderListResponse extends Response{
	
	private List<OrderDTO> list;

	@ApiModelProperty(value = "订单列表")
	public List<OrderDTO> getList() {
		return list;
	}

	@ApiModelProperty(value = "订单列表")
	public void setList(List<OrderDTO> list) {
		this.list = list;
	}
}
