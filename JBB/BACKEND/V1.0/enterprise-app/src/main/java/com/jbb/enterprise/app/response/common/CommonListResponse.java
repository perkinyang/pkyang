/**
 * Created with IntelliJ IDEA.
 * User: walker
 * Date: 15/8/5
 * Time: 23:48
 * To change this template use File | Settings | File Templates.
 */

package com.jbb.enterprise.app.response.common;

import com.jbb.enterprise.app.response.Response;
import com.jbb.user.api.dto.CityDTO;
import com.jbb.user.api.dto.CompanyDTO;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.List;


public class CommonListResponse<T> extends Response{
	
	private List<T> list;

	@ApiModelProperty(value = "地区列表")
	public List<T> getList() {
		return list;
	}
	@ApiModelProperty(value = "地区列表")
	public void setList(List<T> list) {
		this.list = list;
	}
}
