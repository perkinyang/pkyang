package com.jbb.enterprise.app.request.order;


import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class GetOrderDetailRequest {
    
	private Long orderId;

    @ApiModelProperty(value = "订单Id")
	public Long getOrderId() {
		return orderId;
	}
	@ApiModelProperty(value = "订单Id")
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
