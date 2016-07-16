package com.jbb.user.biz.service.impl;

import javax.annotation.Resource;

import com.jbb.user.api.dto.UserDTO;
import com.jbb.user.api.dto.UserLoginDTO;
import com.jbb.user.api.service.UserInfoService;
import com.jbb.user.biz.dao.UserDao;
import com.jbb.user.biz.dao.UserLoginDao;

public class UserInfoServiceImpl implements UserInfoService {

	@Resource
    private UserDao userDao;
	
	@Resource
    private UserLoginDao userLoginDao;
	@Override
	public UserDTO findById(Long userId) {
		return userDao.getById(userId);
	}

	@Override
	public void updateByTelephone(UserDTO user) {
		UserDTO dto=userDao.findByTelephone(user.getTelephone());
		if(dto==null){
			UserLoginDTO userLoginDTO=userLoginDao.findByTelephone(user.getTelephone());
			user.setUserLoginId(userLoginDTO.getId());
			userDao.save(user);
		}else{
			userDao.updateByTelephone(user);
		}
	}

	@Override
	public UserDTO findByTelephone(String telephone) {
		return userDao.findByTelephone(telephone.trim());
	}

	@Override
	public void updateCompanyDetailByTelephone(UserDTO userDTO) {
		UserDTO dto=userDao.findByTelephone(userDTO.getTelephone());
		dto.setCompanyName(userDTO.getCompanyName());
		dto.setIndustry(userDTO.getIndustry());
		dto.setIndustryName(userDTO.getIndustryName());
		userDao.updateByTelephone(dto);
	}
}
