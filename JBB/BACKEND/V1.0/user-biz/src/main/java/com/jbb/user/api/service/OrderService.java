package com.jbb.user.api.service;

import java.util.Date;
import java.util.List;

import com.jbb.user.api.dto.OrderDTO;
import com.jbb.user.api.dto.OrderJbbDTO;
import com.jbb.user.biz.entity.Intention;
import com.jbb.user.biz.entity.IntentionStatus;
import com.jbb.user.biz.entity.OrderDetailJbb;
import com.jbb.user.biz.entity.OrderStatus;
import com.jbb.user.biz.entity.OrderStatusFlow;
import com.jbb.user.biz.entity.PaymentInfo;
import com.jbb.user.biz.entity.Product;

public interface OrderService {

	public List<OrderDTO> queryOrderList(String telephone, long requestTime, Date startMonth, int status[]);

	public void saveOrder(OrderDTO orderDTO);

	public OrderDTO getOrderDetail(long orderId);

	public void saveIntention(Intention intention);

	public String saveOrder(List<OrderDetailJbb> detailJbbs, int userId);



	public List<OrderJbbDTO> getOrderDetails(Integer userid);

	public void syncPay(PaymentInfo paymentInfo);

	public List<IntentionStatus> intentionStatusList();

	public List<OrderStatus> orderStatusList();

	public void updateIntentionStatus(long id, String statusCode, int userid);

	public void changeOrderStatus(long id, String statusCode, int userid);

	public void changeOrderPrice(long id, Integer fee, int userid);

	public List<Product> listKeepingType();
	
	public List<Product> getCityProductList(Integer cityCode);

	public List<Intention> getIntentionList();

	public List<OrderStatusFlow> getOrderStatusFlow(Long orderId);

	List<Product> listKeepingType(String cityCode, String cityName);

	public List<Product> listCompanyProduct(String statusCode);

}
