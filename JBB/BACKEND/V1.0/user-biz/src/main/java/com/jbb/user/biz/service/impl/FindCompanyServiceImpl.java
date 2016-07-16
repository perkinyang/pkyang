package com.jbb.user.biz.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;

import com.jbb.user.api.dto.FindCompanyDTO;
import com.jbb.user.api.service.FindCompanyService;
import com.jbb.user.biz.dao.FindCompanyDao;
import com.jbb.user.biz.entity.FindCompany;

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
