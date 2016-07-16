package com.top.jbb.bean.tel400;

import java.util.List;

public class ProductPriceListResult {
	private int result;
	private String errorMsg ;
	private List<ProductPrice> list;
	
	
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


	public List<ProductPrice> getList() {
		return list;
	}


	public void setList(List<ProductPrice> list) {
		this.list = list;
	}
}
