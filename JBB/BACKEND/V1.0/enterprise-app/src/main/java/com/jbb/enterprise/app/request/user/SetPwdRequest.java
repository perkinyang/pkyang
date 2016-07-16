package com.jbb.enterprise.app.request.user;

import com.wordnik.swagger.annotations.ApiModelProperty;



public class SetPwdRequest {
	
	private String telephone;
	
	private String passwd;
	
	private String smsCode;
	
	private String invitationCode;

	@ApiModelProperty(value = "手机号")
	public String getTelephone() {
		return telephone;
	}

	@ApiModelProperty(value = "手机号")
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@ApiModelProperty(value = "密码")
	public String getPasswd() {
		return passwd;
	}

	@ApiModelProperty(value = "密码")
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
 
}
