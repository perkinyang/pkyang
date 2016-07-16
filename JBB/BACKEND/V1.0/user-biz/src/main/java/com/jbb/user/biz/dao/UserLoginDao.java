package com.jbb.user.biz.dao;

import com.jbb.user.api.dto.UserLoginDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface UserLoginDao {
	

	//public void save(@Param("entity") UserLogin entity);
	
	public void setPwd(@Param("telephone")String telephone,@Param("password")String passwd);

	public UserLoginDTO findByTelephone(@Param("telephone")String telephone);

	public void updateLoginCount(@Param("telephone")String telephone);

	public void updatePwd(@Param("telephone")String telephone,@Param("password")String password);
}
