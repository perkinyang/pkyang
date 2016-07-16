package com.jbb.enterprise.app.response.order;

import com.jbb.enterprise.app.response.Response;
import com.jbb.user.api.dto.OrderDTO;
import com.jbb.user.biz.entity.Order;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.List;

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
