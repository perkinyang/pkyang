package com.jbb.user.biz.dao;

import org.apache.ibatis.annotations.Param;

import com.jbb.user.biz.entity.FindCompany;

public interface FindCompanyDao {

	public void save(@Param("entity") FindCompany entity);

}
