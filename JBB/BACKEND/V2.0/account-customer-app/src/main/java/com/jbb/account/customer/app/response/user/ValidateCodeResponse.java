package com.jbb.account.customer.app.response.user;

import com.jbb.account.customer.app.response.Response;

public class ValidateCodeResponse  extends Response{
	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
