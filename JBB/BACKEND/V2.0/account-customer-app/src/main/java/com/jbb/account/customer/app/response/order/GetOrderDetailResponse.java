package com.jbb.account.customer.app.response.order;

import com.jbb.account.customer.app.response.Response;
import com.jbb.account.order.api.dto.OrderDetailDTO;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class GetOrderDetailResponse extends Response{
	
	private OrderDetailDTO detail;

	@ApiModelProperty(value = "订单详情")
	public OrderDetailDTO getDetail() {
		return detail;
	}

	@ApiModelProperty(value = "订单详情")
	public void setDetail(OrderDetailDTO detail) {
		this.detail = detail;
	}
}
