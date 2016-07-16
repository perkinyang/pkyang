package com.jbb.user.biz.dao;

import com.jbb.user.api.dto.CompanyDTO;
import com.jbb.user.api.dto.OrderDTO;
import com.jbb.user.biz.entity.Company;
import com.jbb.user.biz.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CompanyOrderDao {
	
	public void save(@Param("entity") Order order);
    
    public List<OrderDTO> findOrderList(@Param("telephone") String telephone,
										@Param("startMonth") Date startMonth,
										@Param("requestTime") long requestTime,
										@Param("status") int status[]);

	public OrderDTO findById(@Param("orderId")long orderId);
 
}
