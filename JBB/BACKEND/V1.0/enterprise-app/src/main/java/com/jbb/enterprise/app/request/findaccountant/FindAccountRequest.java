package com.jbb.enterprise.app.request.findaccountant;


import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class FindAccountRequest {

	private String telephone;

	private String industry;

	private String contacts;

	private int province;

	private int city;

	private int district;

	private String address;


	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@ApiModelProperty(value = "行业")
	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}
	@ApiModelProperty(value = "联系人")
	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	@ApiModelProperty(value = "省")
	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}
	@ApiModelProperty(value = "市")
	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}
	@ApiModelProperty(value = "区/县")
	public int getDistrict() {
		return district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}
	@ApiModelProperty(value = "详细地址")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


    
    
}
