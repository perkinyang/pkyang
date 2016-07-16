package com.jbb.user.biz.dao;

import org.apache.ibatis.annotations.Param;

import com.jbb.user.api.dto.CompanyDTO;
import com.jbb.user.biz.entity.Company;

public interface CompanyDao {
	
	public CompanyDTO getById( @Param("id")long id);
	
	public void save(@Param("entity") Company company);
	
	public void updateByTelephone(@Param("entity")CompanyDTO company);
    
    public CompanyDTO findByTelephone(@Param("telephone")String telephone);
 
}
