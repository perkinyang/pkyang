package com.jbb.user.biz.dao;

import org.apache.ibatis.annotations.Param;

import com.jbb.user.api.dto.UserDTO;

public interface UserDao {
	
	public UserDTO getById( @Param("id")long id);
	
	public void save(@Param("entity") UserDTO userDTO);
	
	public void updateByTelephone(@Param("entity")UserDTO userDTO);
    
    public UserDTO findByTelephone(@Param("telephone")String telephone);
 
}
