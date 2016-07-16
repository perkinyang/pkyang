/**
 * 
 */
package com.jbb.util;

/**
 * @author yangxiangqian
 *
 */
public enum StatusCode {

	order_success("COM1001", "下单成功"),
	
	pay_success("COM1011", "已付款"),
	
	refund_success("COM1041", "退款成功"),
	
	order_price_query("NUM100001", "顶级号码询价"),

	intenttion_COM1001("COM0001", "待处理");

	private String code;

	private String msg;

	private StatusCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
