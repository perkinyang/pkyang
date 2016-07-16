package com.jbb.account.order.biz.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;

import com.jbb.account.order.api.dto.FindAccountantDTO;
import com.jbb.account.order.api.service.FindAccountantService;
import com.jbb.account.order.biz.dao.FindAccountantDao;
import com.jbb.account.order.biz.entity.FindAccountant;

public class FindAccountantServiceImpl implements FindAccountantService {

	@Resource
    private FindAccountantDao findAccountantDao;

	@Override
	public void save(FindAccountantDTO findAccountantDTO) {
		FindAccountant entity=new FindAccountant();
		BeanUtils.copyProperties(findAccountantDTO,entity);
		entity.setCreateTime(new Date());
		entity.setLoginTelephone("3333");
		findAccountantDao.save(entity);
	}
}
