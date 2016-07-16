package com.jbb.account.customer.app.request.order;


import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class AddOrderRequest {


	private String telephone;

	private Date startMonth;

	private int durationMonth;

	private int applyType;

	private int serviceType;

	private int monthPrice;

	private int amountPrice;

	private String remark;

	private int orderType;

	private String serviceTelephone;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@ApiModelProperty(value = "开始月份")
	public Date getStartMonth() {
		return startMonth;
	}

	@ApiModelProperty(value = "开始月份")
	public void setStartMonth(Date startMonth) {
		this.startMonth = startMonth;
	}

	@ApiModelProperty(value = "合作期限")
	public int getDurationMonth() {
		return durationMonth;
	}

	@ApiModelProperty(value = "合作期限")
	public void setDurationMonth(int durationMonth) {
		this.durationMonth = durationMonth;
	}

	@ApiModelProperty(value = "申报类型，10：零申报  20：小规模纳税人 30：般纳税人")
	public int getApplyType() {
		return applyType;
	}
	@ApiModelProperty(value = "申报类型，10：零申报  20：小规模纳税人 30：般纳税人")
	public void setApplyType(int applyType) {
		this.applyType = applyType;
	}
	@ApiModelProperty(value = "服务方式，10：快递  20：上门服务")
	public int getServiceType() {
		return serviceType;
	}

	@ApiModelProperty(value = "服务方式，10：快递  20：上门服务")
	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}

	@ApiModelProperty(value = "每月单价")
	public int getMonthPrice() {
		return monthPrice;
	}

	@ApiModelProperty(value = "每月单价")
	public void setMonthPrice(int monthPrice) {
		this.monthPrice = monthPrice;
	}

	@ApiModelProperty(value = "总价")
	public int getAmountPrice() {
		return amountPrice;
	}

	@ApiModelProperty(value = "总价")
	public void setAmountPrice(int amountPrice) {
		this.amountPrice = amountPrice;
	}

	@ApiModelProperty(value = "备注")
	public String getRemark() {
		return remark;
	}
	@ApiModelProperty(value = "备注")
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@ApiModelProperty(value = "订单类型，10：普通 20：定向")
	public int getOrderType() {
		return orderType;
	}
	@ApiModelProperty(value = "订单类型，10：普通 20：定向")
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	@ApiModelProperty(value = "定向下单时，服务者的手机号")
	public String getServiceTelephone() {
		return serviceTelephone;
	}
	@ApiModelProperty(value = "定向下单时，服务者的手机号")
	public void setServiceTelephone(String serviceTelephone) {
		this.serviceTelephone = serviceTelephone;
	}
}
