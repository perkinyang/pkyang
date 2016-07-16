package com.jbb.enterprise.app.request.user;

import com.wordnik.swagger.annotations.ApiModelProperty;


public class UpdatePwdRequest {
	
	private String telephone;

	private String newpasswd;

	private String oldPasswd;

	@ApiModelProperty(value = "手机号")
	public String getTelephone() {
		return telephone;
	}

	@ApiModelProperty(value = "手机号")
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@ApiModelProperty(value = "新密码")
	public String getNewpasswd() {
		return newpasswd;
	}
	@ApiModelProperty(value = "新密码")
	public void setNewpasswd(String newpasswd) {
		this.newpasswd = newpasswd;
	}

	@ApiModelProperty(value = "旧密码")
	public String getOldPasswd() {
		return oldPasswd;
	}
	@ApiModelProperty(value = "旧密码")
	public void setOldPasswd(String oldPasswd) {
		this.oldPasswd = oldPasswd;
	}
}
