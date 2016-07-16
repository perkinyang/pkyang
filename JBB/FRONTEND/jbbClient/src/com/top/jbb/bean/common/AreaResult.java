package com.top.jbb.bean.common;

import java.util.List;

public class AreaResult {
	private int result;
	private String errorMsg ;
	private List<Area> list;
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
	public List<Area> getList() {
		return list;
	}
	public void setList(List<Area> list) {
		this.list = list;
	}
}
