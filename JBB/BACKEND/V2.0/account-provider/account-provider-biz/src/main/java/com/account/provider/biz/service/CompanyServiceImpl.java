package com.account.provider.biz.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;

import com.account.provider.api.dto.CompanyDTO;
import com.account.provider.api.service.CompanyService;
import com.account.provider.biz.dao.CompanyDao;
import com.account.provider.biz.entity.Company;

public class CompanyServiceImpl implements CompanyService {

	@Resource
    private CompanyDao companyDao;

	@Override
	public CompanyDTO findById(Long companyId) {
		return companyDao.getById(companyId);
	}

	@Override
	public void updateByTelephone(CompanyDTO company) {
		CompanyDTO dto=companyDao.findByTelephone(company.getTelephone());
		if(dto==null){
			Company entity=new Company();
			BeanUtils.copyProperties(company,entity);
			entity.setCreateTime(new Date());
			companyDao.save(entity);
		}else{
			companyDao.updateByTelephone(company);
		}
	}

	@Override
	public CompanyDTO findByTelephone(String telephone) {
		
		return companyDao.findByTelephone(telephone.trim());
	}



}
