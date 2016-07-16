package com.jbb.account.customer.app.request;


import com.wordnik.swagger.annotations.ApiModelProperty;

public class CityListRequest {
    
	private long orderId;

    @ApiModelProperty(value = "订单ID")
    public long getOrderId() {
        return orderId;
    }

    @ApiModelProperty(value = "订单ID")
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
