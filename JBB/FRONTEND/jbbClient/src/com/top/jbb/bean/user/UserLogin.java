package com.top.jbb.bean.user;

public class UserLogin {
	private int result;
	private String errorMsg;
	private UserLoginDTO userLogin;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public UserLoginDTO getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLoginDTO userLogin) {
		this.userLogin = userLogin;
	}

}
