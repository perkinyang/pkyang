/**
 * Created with IntelliJ IDEA.
 * User: walker
 * Date: 15/8/5
 * Time: 23:48
 * To change this template use File | Settings | File Templates.
 */

package com.jbb.enterprise.app.response.company;

import com.jbb.enterprise.app.response.Response;
import com.jbb.user.api.dto.CompanyDTO;
import com.wordnik.swagger.annotations.ApiModelProperty;


public class GetDetailResponse extends Response{
	
	private CompanyDTO company;

	@ApiModelProperty(value = "商家相关信息")
	public CompanyDTO getCompany() {
		return company;
	}

	@ApiModelProperty(value = "商家相关信息")
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	
	
	
}
