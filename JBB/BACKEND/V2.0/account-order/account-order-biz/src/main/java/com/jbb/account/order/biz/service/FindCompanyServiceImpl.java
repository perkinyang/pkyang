package com.jbb.account.order.biz.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;

import com.jbb.account.order.api.dto.FindCompanyDTO;
import com.jbb.account.order.api.service.FindCompanyService;
import com.jbb.account.order.biz.dao.FindCompanyDao;
import com.jbb.account.order.biz.entity.FindCompany;

public class FindCompanyServiceImpl implements FindCompanyService {

	@Resource
    private FindCompanyDao findCompanyDao;

	@Override
	public void save(FindCompanyDTO findCompanyDTO) {
		FindCompany entity=new FindCompany();
		BeanUtils.copyProperties(findCompanyDTO,entity);
		entity.setCreateTime(new Date());
		findCompanyDao.save(entity);
	}
}
