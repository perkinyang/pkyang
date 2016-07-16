package com.jbb.user.api.dto;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModelProperty;


public class UserDTO implements Serializable{

	private static final long serialVersionUID = -6641075542900429220L;
	
	private int id;
	
	private String companyName;
	
	private String contacts;
	
	private String telephone;
	
	private String email;
	
	private int sex; //0:女  1:男
	
	private String industry;
	
	private String industryName;
	
	private int provinceCode;
	
	private String provinceName;
	
	private int cityCode;
	
	private String cityName;
	
	private int areaCode;
	
	private String areaName;
	
	private int streetCode;
	
	private String streetName;
	
	private String address;
	
	private int userType; //10:公司    20:个人
	
	private int userLoginId=0;
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ApiModelProperty(value = "0：女  1：男")
	public int getSex() {
		return sex;
	}

	@ApiModelProperty(value = "0：女  1：男")
	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getStreetCode() {
		return streetCode;
	}

	public void setStreetCode(int streetCode) {
		this.streetCode = streetCode;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@ApiModelProperty(value = "10：公司  20：个人")
	public int getUserType() {
		return userType;
	}

	@ApiModelProperty(value = "10：公司  20：个人")
	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(int provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public int getCityCode() {
		return cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
	}
	
	
}
