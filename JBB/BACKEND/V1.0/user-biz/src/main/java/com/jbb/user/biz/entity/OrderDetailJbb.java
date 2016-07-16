package com.jbb.user.biz.entity;

import java.util.Date;

public class OrderDetailJbb {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_detail.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_detail.orderid
     *
     * @mbggenerated
     */
    private String orderid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_detail.item_price
     *
     * @mbggenerated
     */
    private Integer itemPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_detail.quantity
     *
     * @mbggenerated
     */
    private String quantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_detail.product_id
     *
     * @mbggenerated
     */
    private Long productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_detail.service_info
     *
     * @mbggenerated
     */
    private String serviceInfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_detail.createTime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_detail.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_detail.start_time
     *
     * @mbggenerated
     */
    private String startTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_detail.end_time
     *
     * @mbggenerated
     */
    private String endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_detail.number
     *
     * @mbggenerated
     */
    private String number;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_detail.year
     *
     * @mbggenerated
     */
    private Integer year;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_detail.layer
     *
     * @mbggenerated
     */
    private Integer layer;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_detail.id
     *
     * @return the value of jbb_order_detail.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_detail.id
     *
     * @param id the value for jbb_order_detail.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_detail.orderid
     *
     * @return the value of jbb_order_detail.orderid
     *
     * @mbggenerated
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_detail.orderid
     *
     * @param orderid the value for jbb_order_detail.orderid
     *
     * @mbggenerated
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_detail.item_price
     *
     * @return the value of jbb_order_detail.item_price
     *
     * @mbggenerated
     */
    public Integer getItemPrice() {
        return itemPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_detail.item_price
     *
     * @param itemPrice the value for jbb_order_detail.item_price
     *
     * @mbggenerated
     */
    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_detail.quantity
     *
     * @return the value of jbb_order_detail.quantity
     *
     * @mbggenerated
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_detail.quantity
     *
     * @param quantity the value for jbb_order_detail.quantity
     *
     * @mbggenerated
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity == null ? null : quantity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_detail.product_id
     *
     * @return the value of jbb_order_detail.product_id
     *
     * @mbggenerated
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_detail.product_id
     *
     * @param productId the value for jbb_order_detail.product_id
     *
     * @mbggenerated
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_detail.service_info
     *
     * @return the value of jbb_order_detail.service_info
     *
     * @mbggenerated
     */
    public String getServiceInfo() {
        return serviceInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_detail.service_info
     *
     * @param serviceInfo the value for jbb_order_detail.service_info
     *
     * @mbggenerated
     */
    public void setServiceInfo(String serviceInfo) {
        this.serviceInfo = serviceInfo == null ? null : serviceInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_detail.createTime
     *
     * @return the value of jbb_order_detail.createTime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_detail.createTime
     *
     * @param createtime the value for jbb_order_detail.createTime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_detail.remark
     *
     * @return the value of jbb_order_detail.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_detail.remark
     *
     * @param remark the value for jbb_order_detail.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_detail.start_time
     *
     * @return the value of jbb_order_detail.start_time
     *
     * @mbggenerated
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_detail.start_time
     *
     * @param startTime the value for jbb_order_detail.start_time
     *
     * @mbggenerated
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_detail.end_time
     *
     * @return the value of jbb_order_detail.end_time
     *
     * @mbggenerated
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_detail.end_time
     *
     * @param endTime the value for jbb_order_detail.end_time
     *
     * @mbggenerated
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_detail.number
     *
     * @return the value of jbb_order_detail.number
     *
     * @mbggenerated
     */
    public String getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_detail.number
     *
     * @param number the value for jbb_order_detail.number
     *
     * @mbggenerated
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_detail.year
     *
     * @return the value of jbb_order_detail.year
     *
     * @mbggenerated
     */
    public Integer getYear() {
        return year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_detail.year
     *
     * @param year the value for jbb_order_detail.year
     *
     * @mbggenerated
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_detail.layer
     *
     * @return the value of jbb_order_detail.layer
     *
     * @mbggenerated
     */
    public Integer getLayer() {
        return layer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_detail.layer
     *
     * @param layer the value for jbb_order_detail.layer
     *
     * @mbggenerated
     */
    public void setLayer(Integer layer) {
        this.layer = layer;
    }
}