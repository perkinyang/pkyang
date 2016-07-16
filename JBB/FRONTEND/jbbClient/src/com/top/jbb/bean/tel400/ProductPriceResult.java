package com.top.jbb.bean.tel400;


public class ProductPriceResult {
	private int result;
	private String errorMsg ;
	private ProductPrice obj;
	
	
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

	public ProductPrice getObj() {
		return obj;
	}


	public void setObj(ProductPrice obj) {
		this.obj = obj;
	}
}
