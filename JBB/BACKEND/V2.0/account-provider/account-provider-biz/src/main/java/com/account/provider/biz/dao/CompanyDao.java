package com.account.provider.biz.dao;

import org.apache.ibatis.annotations.Param;

import com.account.provider.api.dto.CompanyDTO;
import com.account.provider.biz.entity.Company;

public interface CompanyDao {
	
	public CompanyDTO getById( @Param("id")long id);
	
	public void save(@Param("entity") Company company);
	
	public void updateByTelephone(@Param("entity")CompanyDTO company);
    
    public CompanyDTO findByTelephone(@Param("telephone")String telephone);
 
}
