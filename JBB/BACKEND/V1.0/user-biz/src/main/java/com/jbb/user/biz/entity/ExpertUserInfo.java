package com.jbb.user.biz.entity;

import java.util.Date;

public class ExpertUserInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.user_login_id
     *
     * @mbggenerated
     */
    private Integer userLoginId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.company_name
     *
     * @mbggenerated
     */
    private String companyName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.contacts
     *
     * @mbggenerated
     */
    private String contacts;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.telephone
     *
     * @mbggenerated
     */
    private String telephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.sex
     *
     * @mbggenerated
     */
    private Byte sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.industry
     *
     * @mbggenerated
     */
    private String industry;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.industry_name
     *
     * @mbggenerated
     */
    private String industryName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.province_code
     *
     * @mbggenerated
     */
    private Integer provinceCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.city_code
     *
     * @mbggenerated
     */
    private Integer cityCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.area_code
     *
     * @mbggenerated
     */
    private Integer areaCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.street_code
     *
     * @mbggenerated
     */
    private Integer streetCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.province_name
     *
     * @mbggenerated
     */
    private String provinceName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.city_name
     *
     * @mbggenerated
     */
    private String cityName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.area_name
     *
     * @mbggenerated
     */
    private String areaName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.street_name
     *
     * @mbggenerated
     */
    private String streetName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.user_type
     *
     * @mbggenerated
     */
    private Byte userType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column expert_user_info.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.id
     *
     * @return the value of expert_user_info.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.id
     *
     * @param id the value for expert_user_info.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.user_login_id
     *
     * @return the value of expert_user_info.user_login_id
     *
     * @mbggenerated
     */
    public Integer getUserLoginId() {
        return userLoginId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.user_login_id
     *
     * @param userLoginId the value for expert_user_info.user_login_id
     *
     * @mbggenerated
     */
    public void setUserLoginId(Integer userLoginId) {
        this.userLoginId = userLoginId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.company_name
     *
     * @return the value of expert_user_info.company_name
     *
     * @mbggenerated
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.company_name
     *
     * @param companyName the value for expert_user_info.company_name
     *
     * @mbggenerated
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.contacts
     *
     * @return the value of expert_user_info.contacts
     *
     * @mbggenerated
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.contacts
     *
     * @param contacts the value for expert_user_info.contacts
     *
     * @mbggenerated
     */
    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.telephone
     *
     * @return the value of expert_user_info.telephone
     *
     * @mbggenerated
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.telephone
     *
     * @param telephone the value for expert_user_info.telephone
     *
     * @mbggenerated
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.email
     *
     * @return the value of expert_user_info.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.email
     *
     * @param email the value for expert_user_info.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.sex
     *
     * @return the value of expert_user_info.sex
     *
     * @mbggenerated
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.sex
     *
     * @param sex the value for expert_user_info.sex
     *
     * @mbggenerated
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.industry
     *
     * @return the value of expert_user_info.industry
     *
     * @mbggenerated
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.industry
     *
     * @param industry the value for expert_user_info.industry
     *
     * @mbggenerated
     */
    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.industry_name
     *
     * @return the value of expert_user_info.industry_name
     *
     * @mbggenerated
     */
    public String getIndustryName() {
        return industryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.industry_name
     *
     * @param industryName the value for expert_user_info.industry_name
     *
     * @mbggenerated
     */
    public void setIndustryName(String industryName) {
        this.industryName = industryName == null ? null : industryName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.province_code
     *
     * @return the value of expert_user_info.province_code
     *
     * @mbggenerated
     */
    public Integer getProvinceCode() {
        return provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.province_code
     *
     * @param provinceCode the value for expert_user_info.province_code
     *
     * @mbggenerated
     */
    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.city_code
     *
     * @return the value of expert_user_info.city_code
     *
     * @mbggenerated
     */
    public Integer getCityCode() {
        return cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.city_code
     *
     * @param cityCode the value for expert_user_info.city_code
     *
     * @mbggenerated
     */
    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.area_code
     *
     * @return the value of expert_user_info.area_code
     *
     * @mbggenerated
     */
    public Integer getAreaCode() {
        return areaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.area_code
     *
     * @param areaCode the value for expert_user_info.area_code
     *
     * @mbggenerated
     */
    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.street_code
     *
     * @return the value of expert_user_info.street_code
     *
     * @mbggenerated
     */
    public Integer getStreetCode() {
        return streetCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.street_code
     *
     * @param streetCode the value for expert_user_info.street_code
     *
     * @mbggenerated
     */
    public void setStreetCode(Integer streetCode) {
        this.streetCode = streetCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.province_name
     *
     * @return the value of expert_user_info.province_name
     *
     * @mbggenerated
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.province_name
     *
     * @param provinceName the value for expert_user_info.province_name
     *
     * @mbggenerated
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.city_name
     *
     * @return the value of expert_user_info.city_name
     *
     * @mbggenerated
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.city_name
     *
     * @param cityName the value for expert_user_info.city_name
     *
     * @mbggenerated
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.area_name
     *
     * @return the value of expert_user_info.area_name
     *
     * @mbggenerated
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.area_name
     *
     * @param areaName the value for expert_user_info.area_name
     *
     * @mbggenerated
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.street_name
     *
     * @return the value of expert_user_info.street_name
     *
     * @mbggenerated
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.street_name
     *
     * @param streetName the value for expert_user_info.street_name
     *
     * @mbggenerated
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName == null ? null : streetName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.address
     *
     * @return the value of expert_user_info.address
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.address
     *
     * @param address the value for expert_user_info.address
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.create_time
     *
     * @return the value of expert_user_info.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.create_time
     *
     * @param createTime the value for expert_user_info.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.update_time
     *
     * @return the value of expert_user_info.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.update_time
     *
     * @param updateTime the value for expert_user_info.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.user_type
     *
     * @return the value of expert_user_info.user_type
     *
     * @mbggenerated
     */
    public Byte getUserType() {
        return userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.user_type
     *
     * @param userType the value for expert_user_info.user_type
     *
     * @mbggenerated
     */
    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column expert_user_info.remark
     *
     * @return the value of expert_user_info.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column expert_user_info.remark
     *
     * @param remark the value for expert_user_info.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}