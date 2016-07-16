package com.jbb.enterprise.app.response.order;

import com.jbb.enterprise.app.response.Response;
import com.jbb.user.api.dto.OrderDTO;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.List;

public class GetOrderDetailResponse extends Response{
	
	private OrderDTO detail;

	@ApiModelProperty(value = "订单详情")
	public OrderDTO getDetail() {
		return detail;
	}

	@ApiModelProperty(value = "订单详情")
	public void setDetail(OrderDTO detail) {
		this.detail = detail;
	}
}
