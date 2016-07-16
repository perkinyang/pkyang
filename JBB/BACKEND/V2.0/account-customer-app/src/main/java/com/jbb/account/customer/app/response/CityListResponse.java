/**
 * Created with IntelliJ IDEA.
 * User: walker
 * Date: 15/8/5
 * Time: 23:48
 * To change this template use File | Settings | File Templates.
 */

package com.jbb.account.customer.app.response;

import java.util.List;

import com.jbb.user.center.api.dto.CityDTO;
import com.wordnik.swagger.annotations.ApiModelProperty;


public class CityListResponse extends Response{
	
	private List<CityDTO> list;	
	
	@ApiModelProperty(value = "城市列表")
	public List<CityDTO> getList() {
		return list;
	}

	@ApiModelProperty(value = "城市列表")
	public void setList(List<CityDTO> list) {
		this.list = list;
	}
	
	
}
