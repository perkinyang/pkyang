package com.jbb.account.order.biz.dao;

import org.apache.ibatis.annotations.Param;

import com.jbb.account.order.biz.entity.FindCompany;

public interface FindCompanyDao {

	public void save(@Param("entity") FindCompany entity);

}
