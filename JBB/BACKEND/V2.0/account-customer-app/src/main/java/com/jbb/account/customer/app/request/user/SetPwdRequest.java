package com.jbb.account.customer.app.request.user;

import com.wordnik.swagger.annotations.ApiModelProperty;



public class SetPwdRequest {
	
	private String telephone;
	
	private String userName;
	
	private String passwd;

	@ApiModelProperty(value = "手机号")
	public String getTelephone() {
		return telephone;
	}

	@ApiModelProperty(value = "手机号")
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@ApiModelProperty(value = "用户名(非公司名)")
	public String getUserName() {
		return userName;
	}

	@ApiModelProperty(value = "用户名(非公司名)")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@ApiModelProperty(value = "密码")
	public String getPasswd() {
		return passwd;
	}

	@ApiModelProperty(value = "密码")
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	
	
    
}
