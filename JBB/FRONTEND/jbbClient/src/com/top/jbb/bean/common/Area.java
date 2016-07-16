package com.top.jbb.bean.common;

import java.io.Serializable;

public class Area implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6330254907193403528L;
	private int id;
	private int code;
	private int parentid;
	private String name;
	private int level;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
