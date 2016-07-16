package com.jbb.account.customer.app.request.company;


import com.wordnik.swagger.annotations.ApiModelProperty;

public class SetDetailRequest {
	
	private String contacts;
	
	private String email;
	
	private String telephone;
	
	private String companyName;
	
	private String industry;
	
	private int applyType;
	
	private int province;
	
	private int city;
	
	private int district;
	
	private String address;
	
	private int companyType;

	@ApiModelProperty(value = "联系人")
	public String getContacts() {
		return contacts;
	}

	@ApiModelProperty(value = "联系人")
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@ApiModelProperty(value = "公司名")
	public String getCompanyName() {
		return companyName;
	}

	@ApiModelProperty(value = "公司名")
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@ApiModelProperty(value = "行业")
	public String getIndustry() {
		return industry;
	}

	@ApiModelProperty(value = "行业")
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@ApiModelProperty(value = "申报类型,10：零申报，20：一般纳税人，30：小规模纳税人")
	public int getApplyType() {
		return applyType;
	}

	@ApiModelProperty(value = "申报类型,10：零申报，20：一般纳税人，30：小规模纳税人")
	public void setApplyType(int applyType) {
		this.applyType = applyType;
	}

	@ApiModelProperty(value = "省代码")
	public int getProvince() {
		return province;
	}

	@ApiModelProperty(value = "省代码")
	public void setProvince(int province) {
		this.province = province;
	}

	@ApiModelProperty(value = "市代码")
	public int getCity() {
		return city;
	}

	@ApiModelProperty(value = "市代码")
	public void setCity(int city) {
		this.city = city;
	}

	@ApiModelProperty(value = "区/县代码")
	public int getDistrict() {
		return district;
	}

	@ApiModelProperty(value = "区/县代码")
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

	@ApiModelProperty(value = "公司类型，10:纳税公司，20:代帐公司")
	public int getCompanyType() {
		return companyType;
	}

	@ApiModelProperty(value = "公司类型，10:纳税公司，20:代帐公司")
	public void setCompanyType(int companyType) {
		this.companyType = companyType;
	}
    
}
