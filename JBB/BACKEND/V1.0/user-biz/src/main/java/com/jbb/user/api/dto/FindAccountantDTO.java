package com.jbb.user.api.dto;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class FindAccountantDTO implements Serializable {

	
	private static final long serialVersionUID = -4980078122505285973L;

	private long id;

	private long companyId;
	
	private String telephone;
	
	private String industry;
	
	private String contacts;
	
	private int province;
	
	private int city;
	
	private int district;
	
	private String address;
	
	private Date createTime;
	
	private Date updateTime;

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

	@ApiModelProperty(value = "行业")
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@ApiModelProperty(value = "联系人")
	public String getContacts() {
		return contacts;
	}

	@ApiModelProperty(value = "联系人")
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

	@ApiModelProperty(value = "详细地址")
	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
