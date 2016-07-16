package com.customer.api.service;

import com.customer.api.dto.UserDTO;

public interface UserSerivce {
	
	public UserDTO getByTelephone(String telephone);
}
