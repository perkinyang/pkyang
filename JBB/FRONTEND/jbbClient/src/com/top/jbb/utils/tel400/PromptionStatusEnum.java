package com.top.jbb.utils.tel400;

public enum PromptionStatusEnum {

	NOPROMPTION(0,"非促销"),PROMPTION(1,"促销");
	private int code;
	private String desc;
	PromptionStatusEnum(int code,String desc){
		this.code=code;
		this.desc=desc;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
