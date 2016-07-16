package com.top.jbb.bean.user;

public class UserDetailDTO {
	private int result;
	private String errorMsg;
	private UserDTO obj;
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
	public UserDTO getObj() {
		return obj;
	}
	public void setObj(UserDTO obj) {
		this.obj = obj;
	}
	
	
	
}
