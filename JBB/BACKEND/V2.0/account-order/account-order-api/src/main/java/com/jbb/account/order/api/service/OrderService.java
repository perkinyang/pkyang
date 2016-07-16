package com.jbb.account.order.api.service;

import java.util.Date;
import java.util.List;

import com.jbb.account.order.api.dto.OrderDTO;
import com.jbb.account.order.api.dto.OrderDetailDTO;

public interface OrderService {
	
	public List<OrderDTO> queryOrderList(String telephone,long requestTime,Date startMonth,int status[]);
	
	public void saveOrder(OrderDTO orderDTO);
	
	public OrderDetailDTO getOrderDetail(long orderId);
	
    public OrderDetailDTO getLastestOrder(String telephone);
}
