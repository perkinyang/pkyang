package com.top.jbb.utils.tel400;

public enum Tel400OrderStatusEnum {

	START(10,"成功开通"),UPLOAD(20,"上传资料"),LOCK(30,"上传资料");
	private int status;
	private String desc;
	
	Tel400OrderStatusEnum(int status,String desc){
		this.status=status;
		this.desc=desc;
	}
	
	public static String getDesc(int status){
		if(START.getStatus()==status){
			return START.getDesc();
		}
		if(UPLOAD.getStatus()==status){
			return UPLOAD.getDesc();
		}
		if(LOCK.getStatus()==status){
			return LOCK.getDesc();
		}
		return START.getDesc();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
