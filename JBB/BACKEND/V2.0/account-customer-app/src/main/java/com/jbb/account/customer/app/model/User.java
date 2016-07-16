package com.jbb.account.customer.app.model;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class User {
	
	private int id;
	
	private String userName;
	
	private String password;
	
	private int age;

	@ApiModelProperty(value = "ID")
	public int getId() {
		return id;
	}

	@ApiModelProperty(value = "ID")
	public void setId(int id) {
		this.id = id;
	}

	@ApiModelProperty(value = "用户名")
	public String getUserName() {
		return userName;
	}

	@ApiModelProperty(value = "用户名")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@ApiModelProperty(value = "密码")
	public String getPassword() {
		return password;
	}

	@ApiModelProperty(value = "密码")
	public void setPassword(String password) {
		this.password = password;
	}

	@ApiModelProperty(value = "年龄")
	public int getAge() {
		return age;
	}

	@ApiModelProperty(value = "年龄")
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
