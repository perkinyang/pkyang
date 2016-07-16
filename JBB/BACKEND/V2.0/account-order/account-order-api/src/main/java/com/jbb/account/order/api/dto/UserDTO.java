package com.jbb.account.order.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class UserDTO {

	private String userName;
	
	private String telephone;
	
	private int orderCount;
	
	private long userId;
	
	private int commentLevel;
	
	private int idAuth;
	
	private int careerAuth;
	
	private int experience;
	
	private int isVIP;
	
	private List<String> picList=new ArrayList<String>();

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@ApiModelProperty(value = "接单数")
	public int getOrderCount() {
		return orderCount;
	}

	@ApiModelProperty(value = "接单数")
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@ApiModelProperty(value = "评价分数")
	public int getCommentLevel() {
		return commentLevel;
	}

	@ApiModelProperty(value = "评价分数")
	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}

	@ApiModelProperty(value = "是否身份认证，0：否  1：是")
	public int getIdAuth() {
		return idAuth;
	}

	@ApiModelProperty(value = "是否身份认证，0：否  1：是")
	public void setIdAuth(int idAuth) {
		this.idAuth = idAuth;
	}

	@ApiModelProperty(value = "是否从业资格认证，0：否  1：是")
	public int getCareerAuth() {
		return careerAuth;
	}

	@ApiModelProperty(value = "是否从业资格认证，0：否  1：是")
	public void setCareerAuth(int careerAuth) {
		this.careerAuth = careerAuth;
	}

	@ApiModelProperty(value = "工作经验")
	public int getExperience() {
		return experience;
	}

	@ApiModelProperty(value = "工作经验")
	public void setExperience(int experience) {
		this.experience = experience;
	}

	@ApiModelProperty(value = "是否VIP，0：否  1：是")
	public int getIsVIP() {
		return isVIP;
	}

	@ApiModelProperty(value = "是否VIP，0：否  1：是")
	public void setIsVIP(int isVIP) {
		this.isVIP = isVIP;
	}

	@ApiModelProperty(value = "图片列表")
	public List<String> getPicList() {
		return picList;
	}

	@ApiModelProperty(value = "图片列表")
	public void setPicList(List<String> picList) {
		this.picList = picList;
	}
	
	
	
}
