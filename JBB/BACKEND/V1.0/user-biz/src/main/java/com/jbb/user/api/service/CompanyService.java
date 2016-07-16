package com.jbb.user.api.service;

import com.jbb.user.api.dto.CompanyDTO;

public interface CompanyService {
	
    public void updateByTelephone(CompanyDTO company);
    
    public CompanyDTO findById(Long companyId);
    
    public CompanyDTO findByTelephone(String telephone);

}
