package com.jbb.user.api.service;

import com.jbb.user.api.dto.UserDTO;

public interface UserInfoService {
	
    public void updateByTelephone(UserDTO userDTO);
    
    public void updateCompanyDetailByTelephone(UserDTO userDTO);
    
    public UserDTO findById(Long userId);
    
    public UserDTO findByTelephone(String telephone);

}
