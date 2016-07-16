package com.jbb.user.biz.entity;

import java.util.Date;

public class OrderLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_log.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_log.orderid
     *
     * @mbggenerated
     */
    private String orderid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_log.operator
     *
     * @mbggenerated
     */
    private Integer operator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_log.original_status
     *
     * @mbggenerated
     */
    private String originalStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_log.updated_status
     *
     * @mbggenerated
     */
    private String updatedStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_log.status_change_type
     *
     * @mbggenerated
     */
    private String statusChangeType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_log.original_total_amount
     *
     * @mbggenerated
     */
    private Integer originalTotalAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_log.updated_total_amount
     *
     * @mbggenerated
     */
    private Integer updatedTotalAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_log.operation_comments
     *
     * @mbggenerated
     */
    private String operationComments;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_log.createTime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_order_log.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_log.id
     *
     * @return the value of jbb_order_log.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_log.id
     *
     * @param id the value for jbb_order_log.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_log.orderid
     *
     * @return the value of jbb_order_log.orderid
     *
     * @mbggenerated
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_log.orderid
     *
     * @param orderid the value for jbb_order_log.orderid
     *
     * @mbggenerated
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_log.operator
     *
     * @return the value of jbb_order_log.operator
     *
     * @mbggenerated
     */
    public Integer getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_log.operator
     *
     * @param operator the value for jbb_order_log.operator
     *
     * @mbggenerated
     */
    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_log.original_status
     *
     * @return the value of jbb_order_log.original_status
     *
     * @mbggenerated
     */
    public String getOriginalStatus() {
        return originalStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_log.original_status
     *
     * @param originalStatus the value for jbb_order_log.original_status
     *
     * @mbggenerated
     */
    public void setOriginalStatus(String originalStatus) {
        this.originalStatus = originalStatus == null ? null : originalStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_log.updated_status
     *
     * @return the value of jbb_order_log.updated_status
     *
     * @mbggenerated
     */
    public String getUpdatedStatus() {
        return updatedStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_log.updated_status
     *
     * @param updatedStatus the value for jbb_order_log.updated_status
     *
     * @mbggenerated
     */
    public void setUpdatedStatus(String updatedStatus) {
        this.updatedStatus = updatedStatus == null ? null : updatedStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_log.status_change_type
     *
     * @return the value of jbb_order_log.status_change_type
     *
     * @mbggenerated
     */
    public String getStatusChangeType() {
        return statusChangeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_log.status_change_type
     *
     * @param statusChangeType the value for jbb_order_log.status_change_type
     *
     * @mbggenerated
     */
    public void setStatusChangeType(String statusChangeType) {
        this.statusChangeType = statusChangeType == null ? null : statusChangeType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_log.original_total_amount
     *
     * @return the value of jbb_order_log.original_total_amount
     *
     * @mbggenerated
     */
    public Integer getOriginalTotalAmount() {
        return originalTotalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_log.original_total_amount
     *
     * @param originalTotalAmount the value for jbb_order_log.original_total_amount
     *
     * @mbggenerated
     */
    public void setOriginalTotalAmount(Integer originalTotalAmount) {
        this.originalTotalAmount = originalTotalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_log.updated_total_amount
     *
     * @return the value of jbb_order_log.updated_total_amount
     *
     * @mbggenerated
     */
    public Integer getUpdatedTotalAmount() {
        return updatedTotalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_log.updated_total_amount
     *
     * @param updatedTotalAmount the value for jbb_order_log.updated_total_amount
     *
     * @mbggenerated
     */
    public void setUpdatedTotalAmount(Integer updatedTotalAmount) {
        this.updatedTotalAmount = updatedTotalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_log.operation_comments
     *
     * @return the value of jbb_order_log.operation_comments
     *
     * @mbggenerated
     */
    public String getOperationComments() {
        return operationComments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_log.operation_comments
     *
     * @param operationComments the value for jbb_order_log.operation_comments
     *
     * @mbggenerated
     */
    public void setOperationComments(String operationComments) {
        this.operationComments = operationComments == null ? null : operationComments.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_log.createTime
     *
     * @return the value of jbb_order_log.createTime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_log.createTime
     *
     * @param createtime the value for jbb_order_log.createTime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_order_log.remark
     *
     * @return the value of jbb_order_log.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_order_log.remark
     *
     * @param remark the value for jbb_order_log.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}