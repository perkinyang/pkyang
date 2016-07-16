package com.jbb.account.order.biz.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;

import com.jbb.account.order.api.dto.OrderDTO;
import com.jbb.account.order.api.dto.OrderDetailDTO;
import com.jbb.account.order.api.dto.UserDTO;
import com.jbb.account.order.api.service.OrderService;
import com.jbb.account.order.biz.dao.CompanyOrderDao;
import com.jbb.account.order.biz.entity.Order;

public class OrderServiceImpl implements OrderService  {

	@Resource
	private CompanyOrderDao companyOrderDao;

	@Override
	public List<OrderDTO> queryOrderList(String telephone,long requestTime,Date startMonth,int status[]) {
		return companyOrderDao.findOrderList(telephone,startMonth,requestTime,status);
	}

	@Override
	public void saveOrder(OrderDTO orderDTO) {
		Order order=new Order();
		BeanUtils.copyProperties(orderDTO,order);
		order.setCreateTime(new Date());
		companyOrderDao.save(order);
	}

	@Override
	public OrderDetailDTO getOrderDetail(long orderId) {
		List<String> list=new ArrayList<String>();
		list.add("http://i2.tietuku.com/603709c3f6babce7s.jpg");
		OrderDetailDTO dto= companyOrderDao.findById(orderId);
		UserDTO user=new UserDTO();
		user.setCareerAuth(1);
		user.setCommentLevel(3);
		user.setExperience(9);
		user.setIdAuth(0);
		user.setIsVIP(1);
		user.setOrderCount(19);
		user.setPicList(list);
		user.setTelephone("18888888910");
		user.setUserId(1);
		user.setUserName("王全蛋");
		dto.setUserInfo(user);
		return dto;
	}

	@Override
	public OrderDetailDTO getLastestOrder(String telephone) {
		return companyOrderDao.findLatestOrder(telephone);
	}
	
}
