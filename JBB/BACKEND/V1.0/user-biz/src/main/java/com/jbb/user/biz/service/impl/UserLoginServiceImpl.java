package com.jbb.user.biz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.util.CollectionUtils;

import com.jbb.user.api.dto.UserLoginDTO;
import com.jbb.user.api.service.UserLoginService;
import com.jbb.user.biz.dao.UserLoginDao;
import com.jbb.user.biz.entity.ExpertLogin;
import com.jbb.user.biz.entity.ExpertLoginExample;
import com.jbb.user.biz.mapper.ExpertLoginMapper;

public class UserLoginServiceImpl implements UserLoginService {

	@Resource
	private UserLoginDao userLoginDao;

	@Resource
	private ExpertLoginMapper expertLoginMapper;

	@Override
	public UserLoginDTO findByUserId(Long userId) {
		return null;
	}

	@Override
	public UserLoginDTO findByTelephone(String telephone) {
		return userLoginDao.findByTelephone(telephone);
	}

	@Override
	public UserLoginDTO findByLoginName(String loginName) {
		return null;
	}

	@Override
	public void updateToken(Long userId, String token) {

	}

	@Override
	public void update(UserLoginDTO userLogin) {

	}

	@Override
	public String getRegistAuthCode(String telephone) {
		return null;
	}

	@Override
	public UserLoginDTO register(String s, String s1) {
		return null;
	}

	@Override
	public void setPwd(String telephone, String userName, String passwd) {
		userLoginDao.setPwd(telephone, passwd);
	}

	public UserLoginDTO login(String telephone, String password) {

		UserLoginDTO dto = userLoginDao.findByTelephone(telephone);
		if (dto != null && password.equals(dto.getPassword())) {
			userLoginDao.updateLoginCount(telephone);
		} else {
			return null;
		}
		return dto;
	}

	@Override
	public void updatePwd(String telephone, String password) {
		userLoginDao.updatePwd(telephone, password);
	}

	@Override
	public ExpertLogin login(String telephone, String passwd, boolean b) {
		ExpertLoginExample example = new ExpertLoginExample();
		example.createCriteria().andTelephoneEqualTo(telephone).andPasswordEqualTo(passwd);
		List<ExpertLogin> list = expertLoginMapper.selectByExample(example);
		UserLoginDTO dto = new UserLoginDTO();
		if (!CollectionUtils.isEmpty(list)) {
			ExpertLogin login =	list.get(0);
			return login;
		}
		
		
		return null;
	}

}
