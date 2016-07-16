package com.jbb.account.customer.app.request.order;


import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class GetOrderListRequest {
    
	private String telephone;

	private long requestTime;

	private Date startMonth;

	private int status[];

    @ApiModelProperty(value = "手机号")
	public String getTelephone() {
		return telephone;
	}

    @ApiModelProperty(value = "手机号")
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@ApiModelProperty(value = "查询requestTime之后的订单")
	public long getRequestTime() {
		return requestTime;
	}

	@ApiModelProperty(value = "查询requestTime之后的订单")
	public void setRequestTime(long requestTime) {
		this.requestTime = requestTime;
	}

	@ApiModelProperty(value = "开始月份，日期格式化，如：2015-12-01")
	public Date getStartMonth() {
		return startMonth;
	}

	@ApiModelProperty(value = "开始月份，日期格式化，如：2015-12-01")
	public void setStartMonth(Date startMonth) {
		this.startMonth = startMonth;
	}

	@ApiModelProperty(value = "订单状态，空数组：表示全部 10：待收票据 20：开始做账 30：账务审核  40：纳税申报 50：本期完结")
	public int[] getStatus() {
		return status;
	}

	@ApiModelProperty(value = "订单状态，空数组：表示全部 10：待收票据 20：开始做账 30：账务审核  40：纳税申报 50：本期完结")
	public void setStatus(int[] status) {
		this.status = status;
	}
}
