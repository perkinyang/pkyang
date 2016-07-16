package com.jbb.user.biz.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.product_code
     *
     * @mbggenerated
     */
    private String productCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.service_name
     *
     * @mbggenerated
     */
    private String serviceName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.package_status
     *
     * @mbggenerated
     */
    private Byte packageStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.package_composition
     *
     * @mbggenerated
     */
    private String packageComposition;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.service_type
     *
     * @mbggenerated
     */
    private String serviceType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.service_sub_type
     *
     * @mbggenerated
     */
    private String serviceSubType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.business_name
     *
     * @mbggenerated
     */
    private String businessName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.partner_type
     *
     * @mbggenerated
     */
    private String partnerType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.expert_type
     *
     * @mbggenerated
     */
    private String expertType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.sub_business_name
     *
     * @mbggenerated
     */
    private String subBusinessName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.partner_sub_type
     *
     * @mbggenerated
     */
    private String partnerSubType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.expert_sub_type
     *
     * @mbggenerated
     */
    private String expertSubType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.province_code
     *
     * @mbggenerated
     */
    private Integer provinceCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.province_name
     *
     * @mbggenerated
     */
    private String provinceName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.city_code
     *
     * @mbggenerated
     */
    private Integer cityCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.city_name
     *
     * @mbggenerated
     */
    private String cityName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.area_id
     *
     * @mbggenerated
     */
    private Integer areaId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.area_name
     *
     * @mbggenerated
     */
    private String areaName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.product_status
     *
     * @mbggenerated
     */
    private Byte productStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.discount_status
     *
     * @mbggenerated
     */
    private Byte discountStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.cash_reward_base_percent
     *
     * @mbggenerated
     */
    private BigDecimal cashRewardBasePercent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.price
     *
     * @mbggenerated
     */
    private Integer price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.unit
     *
     * @mbggenerated
     */
    private String unit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.discount_price
     *
     * @mbggenerated
     */
    private Integer discountPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.discount_start_date
     *
     * @mbggenerated
     */
    private Date discountStartDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.discount_end_date
     *
     * @mbggenerated
     */
    private Date discountEndDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.info
     *
     * @mbggenerated
     */
    private String info;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.discount_info
     *
     * @mbggenerated
     */
    private String discountInfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.createTime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.updateTime
     *
     * @mbggenerated
     */
    private Date updatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jbb_product.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.id
     *
     * @return the value of jbb_product.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.id
     *
     * @param id the value for jbb_product.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.product_code
     *
     * @return the value of jbb_product.product_code
     *
     * @mbggenerated
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.product_code
     *
     * @param productCode the value for jbb_product.product_code
     *
     * @mbggenerated
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.service_name
     *
     * @return the value of jbb_product.service_name
     *
     * @mbggenerated
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.service_name
     *
     * @param serviceName the value for jbb_product.service_name
     *
     * @mbggenerated
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.package_status
     *
     * @return the value of jbb_product.package_status
     *
     * @mbggenerated
     */
    public Byte getPackageStatus() {
        return packageStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.package_status
     *
     * @param packageStatus the value for jbb_product.package_status
     *
     * @mbggenerated
     */
    public void setPackageStatus(Byte packageStatus) {
        this.packageStatus = packageStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.package_composition
     *
     * @return the value of jbb_product.package_composition
     *
     * @mbggenerated
     */
    public String getPackageComposition() {
        return packageComposition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.package_composition
     *
     * @param packageComposition the value for jbb_product.package_composition
     *
     * @mbggenerated
     */
    public void setPackageComposition(String packageComposition) {
        this.packageComposition = packageComposition == null ? null : packageComposition.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.service_type
     *
     * @return the value of jbb_product.service_type
     *
     * @mbggenerated
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.service_type
     *
     * @param serviceType the value for jbb_product.service_type
     *
     * @mbggenerated
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.service_sub_type
     *
     * @return the value of jbb_product.service_sub_type
     *
     * @mbggenerated
     */
    public String getServiceSubType() {
        return serviceSubType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.service_sub_type
     *
     * @param serviceSubType the value for jbb_product.service_sub_type
     *
     * @mbggenerated
     */
    public void setServiceSubType(String serviceSubType) {
        this.serviceSubType = serviceSubType == null ? null : serviceSubType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.business_name
     *
     * @return the value of jbb_product.business_name
     *
     * @mbggenerated
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.business_name
     *
     * @param businessName the value for jbb_product.business_name
     *
     * @mbggenerated
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.partner_type
     *
     * @return the value of jbb_product.partner_type
     *
     * @mbggenerated
     */
    public String getPartnerType() {
        return partnerType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.partner_type
     *
     * @param partnerType the value for jbb_product.partner_type
     *
     * @mbggenerated
     */
    public void setPartnerType(String partnerType) {
        this.partnerType = partnerType == null ? null : partnerType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.expert_type
     *
     * @return the value of jbb_product.expert_type
     *
     * @mbggenerated
     */
    public String getExpertType() {
        return expertType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.expert_type
     *
     * @param expertType the value for jbb_product.expert_type
     *
     * @mbggenerated
     */
    public void setExpertType(String expertType) {
        this.expertType = expertType == null ? null : expertType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.sub_business_name
     *
     * @return the value of jbb_product.sub_business_name
     *
     * @mbggenerated
     */
    public String getSubBusinessName() {
        return subBusinessName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.sub_business_name
     *
     * @param subBusinessName the value for jbb_product.sub_business_name
     *
     * @mbggenerated
     */
    public void setSubBusinessName(String subBusinessName) {
        this.subBusinessName = subBusinessName == null ? null : subBusinessName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.partner_sub_type
     *
     * @return the value of jbb_product.partner_sub_type
     *
     * @mbggenerated
     */
    public String getPartnerSubType() {
        return partnerSubType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.partner_sub_type
     *
     * @param partnerSubType the value for jbb_product.partner_sub_type
     *
     * @mbggenerated
     */
    public void setPartnerSubType(String partnerSubType) {
        this.partnerSubType = partnerSubType == null ? null : partnerSubType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.expert_sub_type
     *
     * @return the value of jbb_product.expert_sub_type
     *
     * @mbggenerated
     */
    public String getExpertSubType() {
        return expertSubType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.expert_sub_type
     *
     * @param expertSubType the value for jbb_product.expert_sub_type
     *
     * @mbggenerated
     */
    public void setExpertSubType(String expertSubType) {
        this.expertSubType = expertSubType == null ? null : expertSubType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.province_code
     *
     * @return the value of jbb_product.province_code
     *
     * @mbggenerated
     */
    public Integer getProvinceCode() {
        return provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.province_code
     *
     * @param provinceCode the value for jbb_product.province_code
     *
     * @mbggenerated
     */
    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.province_name
     *
     * @return the value of jbb_product.province_name
     *
     * @mbggenerated
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.province_name
     *
     * @param provinceName the value for jbb_product.province_name
     *
     * @mbggenerated
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.city_code
     *
     * @return the value of jbb_product.city_code
     *
     * @mbggenerated
     */
    public Integer getCityCode() {
        return cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.city_code
     *
     * @param cityCode the value for jbb_product.city_code
     *
     * @mbggenerated
     */
    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.city_name
     *
     * @return the value of jbb_product.city_name
     *
     * @mbggenerated
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.city_name
     *
     * @param cityName the value for jbb_product.city_name
     *
     * @mbggenerated
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.area_id
     *
     * @return the value of jbb_product.area_id
     *
     * @mbggenerated
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.area_id
     *
     * @param areaId the value for jbb_product.area_id
     *
     * @mbggenerated
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.area_name
     *
     * @return the value of jbb_product.area_name
     *
     * @mbggenerated
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.area_name
     *
     * @param areaName the value for jbb_product.area_name
     *
     * @mbggenerated
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.product_status
     *
     * @return the value of jbb_product.product_status
     *
     * @mbggenerated
     */
    public Byte getProductStatus() {
        return productStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.product_status
     *
     * @param productStatus the value for jbb_product.product_status
     *
     * @mbggenerated
     */
    public void setProductStatus(Byte productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.discount_status
     *
     * @return the value of jbb_product.discount_status
     *
     * @mbggenerated
     */
    public Byte getDiscountStatus() {
        return discountStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.discount_status
     *
     * @param discountStatus the value for jbb_product.discount_status
     *
     * @mbggenerated
     */
    public void setDiscountStatus(Byte discountStatus) {
        this.discountStatus = discountStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.cash_reward_base_percent
     *
     * @return the value of jbb_product.cash_reward_base_percent
     *
     * @mbggenerated
     */
    public BigDecimal getCashRewardBasePercent() {
        return cashRewardBasePercent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.cash_reward_base_percent
     *
     * @param cashRewardBasePercent the value for jbb_product.cash_reward_base_percent
     *
     * @mbggenerated
     */
    public void setCashRewardBasePercent(BigDecimal cashRewardBasePercent) {
        this.cashRewardBasePercent = cashRewardBasePercent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.price
     *
     * @return the value of jbb_product.price
     *
     * @mbggenerated
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.price
     *
     * @param price the value for jbb_product.price
     *
     * @mbggenerated
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.unit
     *
     * @return the value of jbb_product.unit
     *
     * @mbggenerated
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.unit
     *
     * @param unit the value for jbb_product.unit
     *
     * @mbggenerated
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.discount_price
     *
     * @return the value of jbb_product.discount_price
     *
     * @mbggenerated
     */
    public Integer getDiscountPrice() {
        return discountPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.discount_price
     *
     * @param discountPrice the value for jbb_product.discount_price
     *
     * @mbggenerated
     */
    public void setDiscountPrice(Integer discountPrice) {
        this.discountPrice = discountPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.discount_start_date
     *
     * @return the value of jbb_product.discount_start_date
     *
     * @mbggenerated
     */
    public Date getDiscountStartDate() {
        return discountStartDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.discount_start_date
     *
     * @param discountStartDate the value for jbb_product.discount_start_date
     *
     * @mbggenerated
     */
    public void setDiscountStartDate(Date discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.discount_end_date
     *
     * @return the value of jbb_product.discount_end_date
     *
     * @mbggenerated
     */
    public Date getDiscountEndDate() {
        return discountEndDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.discount_end_date
     *
     * @param discountEndDate the value for jbb_product.discount_end_date
     *
     * @mbggenerated
     */
    public void setDiscountEndDate(Date discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.info
     *
     * @return the value of jbb_product.info
     *
     * @mbggenerated
     */
    public String getInfo() {
        return info;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.info
     *
     * @param info the value for jbb_product.info
     *
     * @mbggenerated
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.discount_info
     *
     * @return the value of jbb_product.discount_info
     *
     * @mbggenerated
     */
    public String getDiscountInfo() {
        return discountInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.discount_info
     *
     * @param discountInfo the value for jbb_product.discount_info
     *
     * @mbggenerated
     */
    public void setDiscountInfo(String discountInfo) {
        this.discountInfo = discountInfo == null ? null : discountInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.createTime
     *
     * @return the value of jbb_product.createTime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.createTime
     *
     * @param createtime the value for jbb_product.createTime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.updateTime
     *
     * @return the value of jbb_product.updateTime
     *
     * @mbggenerated
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.updateTime
     *
     * @param updatetime the value for jbb_product.updateTime
     *
     * @mbggenerated
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbb_product.remark
     *
     * @return the value of jbb_product.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbb_product.remark
     *
     * @param remark the value for jbb_product.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}