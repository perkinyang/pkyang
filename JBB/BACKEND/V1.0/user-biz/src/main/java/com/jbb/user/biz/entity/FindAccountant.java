package com.jbb.user.biz.entity;

import java.io.Serializable;
import java.util.Date;

public class FindAccountant implements Serializable {

	
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

	private String loginTelephone;

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

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getDistrict() {
		return district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

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

	public String getLoginTelephone() {
		return loginTelephone;
	}

	public void setLoginTelephone(String loginTelephone) {
		this.loginTelephone = loginTelephone;
	}
}
