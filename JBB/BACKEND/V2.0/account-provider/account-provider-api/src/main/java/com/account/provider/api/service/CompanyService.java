package com.account.provider.api.service;

import com.account.provider.api.dto.CompanyDTO;


public interface CompanyService {
	
    public void updateByTelephone(CompanyDTO company);
    
    public CompanyDTO findById(Long companyId);
    
    public CompanyDTO findByTelephone(String telephone);

}
