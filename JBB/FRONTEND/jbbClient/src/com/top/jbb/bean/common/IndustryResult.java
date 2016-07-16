package com.top.jbb.bean.common;

import java.util.List;

public class IndustryResult {
	private int result;
	private String errorMsg ;
	private List<Industry> list;
	
	
	
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



	public List<Industry> getList() {
		return list;
	}



	public void setList(List<Industry> list) {
		this.list = list;
	}



	public class Industry{
		private int id;
		private String code;
		private String name;
		private String pcode;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPcode() {
			return pcode;
		}
		public void setPcode(String pcode) {
			this.pcode = pcode;
		}
		
	}
}


