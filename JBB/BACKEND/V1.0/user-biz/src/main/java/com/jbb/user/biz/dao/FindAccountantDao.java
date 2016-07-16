package com.jbb.user.biz.dao;

import org.apache.ibatis.annotations.Param;

import com.jbb.user.biz.entity.FindAccountant;

public interface FindAccountantDao {

	public void save(@Param("entity") FindAccountant entity);

}
