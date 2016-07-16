package com.jbb.account.customer.app.request.user;


import com.wordnik.swagger.annotations.ApiModelProperty;

public class GetCodeRequest {
    
	private String telephone;

    @ApiModelProperty(value = "手机号")
	public String getTelephone() {
		return telephone;
	}

    @ApiModelProperty(value = "手机号")
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

    
    
}
