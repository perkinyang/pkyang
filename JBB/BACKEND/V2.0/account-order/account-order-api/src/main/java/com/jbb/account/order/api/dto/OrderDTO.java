package com.jbb.account.order.api.dto;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by Administrator on 2016/1/2.
 */
public class OrderDTO {

    private long id;

    private long companyId;

    private String companyName;

    private String telephone;

    private Date createTime;

    private int status;

    private Date updateTime;

    private Date startMonth;

    private int durationMonth;

    private int applyType;

    private int serviceType;

    private int monthPrice;

    private int amountPrice;

    private String remark;

    private int orderType;

    private String serviceTelephone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @ApiModelProperty(value = "状态，1：正常，0：作废")
    public int getStatus() {
        return status;
    }

    @ApiModelProperty(value = "状态，1：正常，0：作废")
    public void setStatus(int status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    @ApiModelProperty(value = "申报类型,10：零申报，20：一般纳税人，30：小规模纳税人")
    public int getApplyType() {
        return applyType;
    }

    @ApiModelProperty(value = "申报类型,10：零申报，20：一般纳税人，30：小规模纳税人")
    public void setApplyType(int applyType) {
        this.applyType = applyType;
    }

    @ApiModelProperty(value = "服务方式,10：快递，20：上门")
    public int getServiceType() {
        return serviceType;
    }

    @ApiModelProperty(value = "服务方式,10：快递，20：上门")
    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    @ApiModelProperty(value = "每月价格")
    public int getMonthPrice() {
        return monthPrice;
    }

    @ApiModelProperty(value = "每月价格")
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @ApiModelProperty(value = "订单类型,10:普通订单，20：定向下单")
    public int getOrderType() {
        return orderType;
    }

    @ApiModelProperty(value = "订单类型,10:普通订单，20：定向下单")
    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    @ApiModelProperty(value = "专业会计或代账公司电话，定向下单时用")
    public String getServiceTelephone() {
        return serviceTelephone;
    }

    @ApiModelProperty(value = "专业会计或代账公司电话，定向下单时用")
    public void setServiceTelephone(String serviceTelephone) {
        this.serviceTelephone = serviceTelephone;
    }
}