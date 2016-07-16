package com.jbb.account.order.biz.dao;

import org.apache.ibatis.annotations.Param;

import com.jbb.account.order.biz.entity.FindAccountant;

public interface FindAccountantDao {

	public void save(@Param("entity") FindAccountant entity);

}
