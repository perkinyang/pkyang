package com.jbb.user.biz.service.impl;

import com.jbb.user.api.dto.CompanyDTO;
import com.jbb.user.api.service.CompanyService;
import com.jbb.user.biz.dao.CompanyDao;
import com.jbb.user.biz.dao.UserLoginDao;
import com.jbb.user.biz.entity.Company;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.Date;

public class CompanyServiceImpl implements CompanyService {

	@Resource
    private CompanyDao companyDao;
	
	@Resource
	private UserLoginDao UserLoginDao;

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
