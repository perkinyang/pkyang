package com.top.jbb.bean;

public enum UserTypeEnume {
	COMPANY(10,"公司"),PERSON(20,"个人");
	private String name;
	private int userType;
	
	
	UserTypeEnume(int type,String name){
		this.userType=type;
		this.name=name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getUserType() {
		return userType;
	}


	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	
	
}
