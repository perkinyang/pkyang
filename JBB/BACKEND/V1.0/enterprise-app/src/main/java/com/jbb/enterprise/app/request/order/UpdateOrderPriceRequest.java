/**
 * 
 */
package com.jbb.enterprise.app.request.order;

/**
 * @author 003747
 *
 */
public class UpdateOrderPriceRequest extends AbstractStringBuilder  {
	Integer fee;
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	long id;
}
