package com.jbb.user.api.dto;

import java.io.Serializable;
import java.util.Date;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class UserLoginDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String telephone;
	private Date lastLogin;
	private int deviceType;
	private int status;
	private int userType;
	private String token;
	private String userName;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int count;

	private int id;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@ApiModelProperty(value = "最近登錄時間")
	public Date getLastLogin() {
		return lastLogin;
	}

	@ApiModelProperty(value = "最近登錄時間")
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	@ApiModelProperty(value = "设备类型，10：Android，20：IOS,30:windows phone")
	public int getDeviceType() {
		return deviceType;
	}

	@ApiModelProperty(value = "设备类型，10：Android，20：IOS,30:windows phone")
	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}

	@ApiModelProperty(value = "状态,1:正常，0：禁用")
	public int getStatus() {
		return status;
	}

	@ApiModelProperty(value = "状态,1:正常，0：禁用")
	public void setStatus(int status) {
		this.status = status;
	}

	@ApiModelProperty(value = "用户类型，10：纳税公司，20：代帐公司,30:会计")
	public int getUserType() {
		return userType;
	}

	@ApiModelProperty(value = "用户类型，10：纳税公司，20：代帐公司,30:会计")
	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ApiModelProperty(value = "登录次数")
	public int getCount() {
		return count;
	}

	@ApiModelProperty(value = "登录次数")
	public void setCount(int count) {
		this.count = count;
	}
}
