/**
 * 
 */
package com.jbb.enterprise.app.request.order;

/**
 * @author 003747
 *
 */
public class RechargeRequest extends AbstractStringBuilder {
	private String fee;
	private	String number;
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
