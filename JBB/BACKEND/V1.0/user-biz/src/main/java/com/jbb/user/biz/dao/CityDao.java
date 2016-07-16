package com.jbb.user.biz.dao;

import com.jbb.user.api.dto.CityDTO;
import com.jbb.user.api.dto.CompanyDTO;
import com.jbb.user.biz.entity.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityDao {

    public List<CityDTO> getList();
 
}
