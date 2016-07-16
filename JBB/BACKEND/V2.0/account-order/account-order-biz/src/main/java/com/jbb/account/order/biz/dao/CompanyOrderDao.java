package com.jbb.account.order.biz.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jbb.account.order.api.dto.OrderDTO;
import com.jbb.account.order.api.dto.OrderDetailDTO;
import com.jbb.account.order.biz.entity.Order;

public interface CompanyOrderDao {
	
	public void save(@Param("entity") Order order);
    
    public List<OrderDTO> findOrderList(@Param("telephone") String telephone,
										@Param("startMonth") Date startMonth,
										@Param("requestTime") long requestTime,
										@Param("status") int status[]);

	public OrderDetailDTO findById(@Param("orderId")long orderId);
	
	public OrderDetailDTO findLatestOrder(@Param("telephone") String telephone);
 
}
