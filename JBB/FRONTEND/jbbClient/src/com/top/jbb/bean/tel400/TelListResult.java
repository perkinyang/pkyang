package com.top.jbb.bean.tel400;

import java.util.List;

public class TelListResult {
	private int result;
	private String errorMsg ;
	private List<TelBean> list;

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




	public List<TelBean> getList() {
		return list;
	}




	public void setList(List<TelBean> list) {
		this.list = list;
	}




	public class TelBean {
		private int id;
		private String displayNumber;
		private String type;
		private String level;
		private int status;
		private String remark;
		private int original;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDisplayNumber() {
			return displayNumber;
		}
		public void setDisplayNumber(String displayNumber) {
			this.displayNumber = displayNumber;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getLevel() {
			return level;
		}
		public void setLevel(String level) {
			this.level = level;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public int getOriginal() {
			return original;
		}
		public void setOriginal(int original) {
			this.original = original;
		}
		
		
	}
}
