package com.jbb.user.biz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.jbb.user.api.dto.OrderDTO;
import com.jbb.user.api.dto.OrderJbbDTO;
import com.jbb.user.api.service.Number400Service;
import com.jbb.user.api.service.OrderService;
import com.jbb.user.biz.dao.CompanyOrderDao;
import com.jbb.user.biz.entity.Intention;
import com.jbb.user.biz.entity.IntentionExample;
import com.jbb.user.biz.entity.IntentionLog;
import com.jbb.user.biz.entity.IntentionStatus;
import com.jbb.user.biz.entity.IntentionStatusExample;
import com.jbb.user.biz.entity.Order;
import com.jbb.user.biz.entity.OrderDetailJbb;
import com.jbb.user.biz.entity.OrderDetailJbbExample;
import com.jbb.user.biz.entity.OrderJbb;
import com.jbb.user.biz.entity.OrderJbbExample;
import com.jbb.user.biz.entity.OrderLog;
import com.jbb.user.biz.entity.OrderStatus;
import com.jbb.user.biz.entity.OrderStatusExample;
import com.jbb.user.biz.entity.OrderStatusFlow;
import com.jbb.user.biz.entity.OrderStatusFlowExample;
import com.jbb.user.biz.entity.PaymentInfo;
import com.jbb.user.biz.entity.Product;
import com.jbb.user.biz.entity.ProductExample;
import com.jbb.user.biz.entity.StatusWorkFlow;
import com.jbb.user.biz.entity.StatusWorkFlowExample;
import com.jbb.user.biz.mapper.IntentionLogMapper;
import com.jbb.user.biz.mapper.IntentionMapper;
import com.jbb.user.biz.mapper.IntentionStatusMapper;
import com.jbb.user.biz.mapper.OrderDetailJbbMapper;
import com.jbb.user.biz.mapper.OrderJbbMapper;
import com.jbb.user.biz.mapper.OrderLogMapper;
import com.jbb.user.biz.mapper.OrderStatusFlowMapper;
import com.jbb.user.biz.mapper.OrderStatusMapper;
import com.jbb.user.biz.mapper.PaymentInfoMapper;
import com.jbb.user.biz.mapper.ProductMapper;
import com.jbb.user.biz.mapper.StatusWorkFlowMapper;
import com.jbb.util.DateUtils;
import com.jbb.util.StatusCode;

public class OrderServiceImpl implements OrderService {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Resource
	private CompanyOrderDao companyOrderDao;

	@Resource
	private Number400Service number400Service;

	@Resource
	private IntentionMapper intentionMapper;

	@Resource
	private OrderDetailJbbMapper orderDetailJbbMapper;

	@Resource
	private OrderJbbMapper orderJbbMapper;

	@Resource
	private PaymentInfoMapper paymentInfoMapper;

	@Resource
	private IntentionStatusMapper intentionStatusMapper;

	@Resource
	private OrderStatusMapper orderStatusMapper;

	@Resource
	private OrderLogMapper orderLogMapper;

	@Resource
	private IntentionLogMapper intentionLogMapper;

	@Resource
	private OrderStatusFlowMapper orderStatusFlowMapper;

	@Override
	public List<OrderDTO> queryOrderList(String telephone, long requestTime, Date startMonth, int status[]) {
		return companyOrderDao.findOrderList(telephone, startMonth, requestTime, status);
	}

	@Override
	public void saveOrder(OrderDTO orderDTO) {
		Order order = new Order();
		BeanUtils.copyProperties(orderDTO, order);
		order.setCreateTime(new Date());
		companyOrderDao.save(order);
	}

	@Override
	public OrderDTO getOrderDetail(long orderId) {
		return companyOrderDao.findById(orderId);
	}

	@Override
	public void saveIntention(Intention intention) {
		intention.setStatus(StatusCode.intenttion_COM1001.getCode());
		intention.setCreatetime(new Date());
		intentionMapper.insertSelective(intention);
	}

	@Resource
	private ProductMapper productMapper;

	@Resource
	private StatusWorkFlowMapper statusWorkFlowMapper;

	@Override
	@Transactional
	public String saveOrder(List<OrderDetailJbb> detailJbbs, int userId) {
		String orderId = DateUtils.formatDateToStr(new Date(), DateUtils.DATESTYLED);
		OrderJbb record = new OrderJbb();
		orderId = orderId + userId;
		boolean isGoldlenNumbe = false;
		int i = 0;
		Integer price = 0;
		for (OrderDetailJbb detailJbb : detailJbbs) {
			Product product = productMapper.selectByPrimaryKey(detailJbb.getProductId());
			detailJbb.setItemPrice(product.getPrice());
			detailJbb.setCreatetime(new Date());
			orderId = orderId + product.getId();
			if (!StringUtils.isEmpty(detailJbb.getNumber())
					&& number400Service.isNumbeInPrompation(detailJbb.getNumber())) {
				price = price + product.getDiscountPrice() * Integer.valueOf(detailJbb.getQuantity());
				detailJbb.setServiceInfo(product.getDiscountInfo());
				detailJbb.setItemPrice(product.getDiscountPrice());

			} else {
				if (product.getDiscountStatus().equals(Byte.valueOf("1"))) {
					price = price + product.getDiscountPrice() * Integer.valueOf(detailJbb.getQuantity());
					detailJbb.setServiceInfo(product.getDiscountInfo());
					detailJbb.setItemPrice(product.getDiscountPrice());
				} else {
					price = price + product.getPrice() * Integer.valueOf(detailJbb.getQuantity());
					detailJbb.setServiceInfo(product.getInfo());
				}

			}
			if (!StringUtils.isEmpty(detailJbb.getNumber())) {
				number400Service.numberSold(detailJbb.getNumber());
				if (i++ == 0) {
					isGoldlenNumbe = number400Service.isGoldlenNumber(detailJbb.getNumber());
				}
			}

		}
		while (orderId.length() < 21) {
			orderId = orderId + new Random().nextInt(10);
		}
		orderId = orderId.substring(0, 20);

		for (OrderDetailJbb detailJbb : detailJbbs) {
			detailJbb.setOrderid(orderId);
			orderDetailJbbMapper.insertSelective(detailJbb);
		}

		record.setPrice(price);
		record.setUserId(userId);
		record.setOrderid(orderId);
		record.setCreatetime(new Date());

		String code = StatusCode.order_success.getCode();
		if (isGoldlenNumbe) {
			code = StatusCode.order_price_query.getCode();
			// record.setStatus(StatusCode.order_price_query.getCode());
		}
		record.setStatus(code);
		orderJbbMapper.insertSelective(record);
		logChangeStatus(record, code, userId);
		// changeOrderStatus(record.getId(), StatusCode.order_success.getCode(),
		// userId);
		return orderId;

	}

	@Override
	public List<OrderJbbDTO> getOrderDetails(Integer userid) {

		List<OrderJbbDTO> orderJbbDTOs = new ArrayList<OrderJbbDTO>();
		OrderJbbExample example = new OrderJbbExample();
		if (null != userid && userid != 0) {
			example.createCriteria().andUserIdEqualTo(userid);
		}
		List<OrderJbb> list = orderJbbMapper.selectByExample(example);
		if (!CollectionUtils.isEmpty(list)) {
			for (OrderJbb jbb : list) {
				OrderJbbDTO orderJbbDTO = new OrderJbbDTO();
				List<OrderDetailJbb> detailList = new ArrayList();
				BeanUtils.copyProperties(jbb, orderJbbDTO);
				OrderDetailJbbExample orderDetailJbbExample = new OrderDetailJbbExample();
				orderDetailJbbExample.createCriteria().andOrderidEqualTo(jbb.getOrderid());
				detailList.addAll(orderDetailJbbMapper.selectByExample(orderDetailJbbExample));
				orderJbbDTO.setDetailList(detailList);
				orderJbbDTOs.add(orderJbbDTO);
			}
		}
		return orderJbbDTOs;
	}

	@Override
	public void syncPay(PaymentInfo paymentInfo) {
		paymentInfoMapper.insertSelective(paymentInfo);
	}

	@Override
	public List<IntentionStatus> intentionStatusList() {
		IntentionStatusExample example = new IntentionStatusExample();
		return intentionStatusMapper.selectByExample(example);

	}

	@Override
	public List<OrderStatus> orderStatusList() {
		OrderStatusExample example = new OrderStatusExample();
		return orderStatusMapper.selectByExample(example);

	}

	@Override
	public void updateIntentionStatus(long id, String statusCode, int userid) {
		Intention record = intentionMapper.selectByPrimaryKey(id);
		String originalStatus = record.getStatus();
		record.setStatus(statusCode);
		intentionMapper.updateByPrimaryKey(record);
		IntentionLog intentionLog = new IntentionLog();
		intentionLog.setCreatetime(new Date());
		intentionLog.setOperator(userid);
		intentionLog.setOriginalStatus(originalStatus);
		intentionLog.setUpdatedStatus(statusCode);
		intentionLogMapper.insertSelective(intentionLog);
	}

	private void logChangeStatus(OrderJbb orderJbb, String statusCode, int userid) {
		// isStatusCanUpdate(orderJbb, statusCode);

		OrderLog record = new OrderLog();
		record.setOperator(userid);
		record.setOriginalStatus(orderJbb.getStatus());
		record.setUpdatedStatus(statusCode);
		record.setOriginalTotalAmount(record.getOriginalTotalAmount());
		record.setUpdatedTotalAmount(record.getOriginalTotalAmount());
		record.setCreatetime(new Date());
		record.setOrderid(orderJbb.getOrderid());
		orderLogMapper.insertSelective(record);
		OrderStatusFlow orderStatusFlowRecord = new OrderStatusFlow();
		orderStatusFlowRecord.setOrderId(orderJbb.getId() + "");
		orderStatusFlowRecord.setStatusId(statusCode);
		orderStatusFlowRecord.setCreateTime(new Date());
		orderStatusFlowMapper.insertSelective(orderStatusFlowRecord);

	}

	@Override
	public void changeOrderStatus(long id, String statusCode, int userid) {
		OrderJbb orderJbb = orderJbbMapper.selectByPrimaryKey(id);
		if (!isStatusCanUpdate(orderJbb, statusCode)) {
			return;
		}
		logChangeStatus(orderJbb, statusCode, userid);
		orderJbb.setStatus(statusCode);
		orderJbbMapper.updateByPrimaryKey(orderJbb);
		StatusAutoChangeJob autoChangeJob = new StatusAutoChangeJob(id, statusCode);
		Thread t = new Thread(autoChangeJob);
		t.start();
	}

	private boolean isStatusCanUpdate(OrderJbb orderJbb, String statusCode) {
		StatusWorkFlowExample statusWorkFlowExample = new StatusWorkFlowExample();
		statusWorkFlowExample.createCriteria().andStatusIdEqualTo(orderJbb.getStatus());
		List<StatusWorkFlow> workFolwList = statusWorkFlowMapper.selectByExample(statusWorkFlowExample);
		if (!CollectionUtils.isEmpty(workFolwList)) {
			for (StatusWorkFlow flow : workFolwList) {
				if (flow.getStatusNextId().equals(statusCode)) {
					return true;
				}
			}

		}
		return false;

	}

	class StatusAutoChangeJob implements Runnable {
		long id;
		String statusCode;

		StatusAutoChangeJob(long orderId, String statusCode) {
			this.id = orderId;
			this.statusCode = statusCode;
		}

		@Override
		public void run() {
			OrderStatusExample example = new OrderStatusExample();
			example.createCriteria().andOrderStatusIdEqualTo(statusCode);
			List<OrderStatus> orderStatusList = orderStatusMapper.selectByExample(example);
			if (!CollectionUtils.isEmpty(orderStatusList)) {
				OrderStatus orderStatus = orderStatusList.get(0);
				if (null != orderStatus.getChangeToNext()) {
					StatusWorkFlowExample statusWorkFlowExample = new StatusWorkFlowExample();
					statusWorkFlowExample.createCriteria().andStatusIdEqualTo(statusCode);
					List<StatusWorkFlow> workFolwList = statusWorkFlowMapper.selectByExample(statusWorkFlowExample);
					if (!CollectionUtils.isEmpty(workFolwList)) {
						try {
							TimeUnit.SECONDS.sleep(orderStatus.getChangeToNext());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						changeOrderStatus(id, workFolwList.get(0).getStatusNextId(), -1);

					}
				}

			}

		}

	}

	@Override
	public void changeOrderPrice(long id, Integer fee, int userid) {
		OrderJbb orderJbb = orderJbbMapper.selectByPrimaryKey(id);
		if (orderJbb.getStatus().equalsIgnoreCase(StatusCode.order_price_query.getCode())
				|| orderJbb.getStatus().equalsIgnoreCase(StatusCode.order_success.getCode())) {
			Integer price = orderJbb.getPrice();
			orderJbb.setPrice(Integer.valueOf(fee));
			orderJbb.setStatus(StatusCode.order_success.getCode());
			orderJbbMapper.updateByPrimaryKey(orderJbb);
			OrderLog record = new OrderLog();
			record.setOperator(userid);
			record.setOriginalStatus(orderJbb.getStatus());
			record.setUpdatedStatus(orderJbb.getStatus());
			record.setOriginalTotalAmount(price);
			record.setUpdatedTotalAmount(Integer.valueOf(fee));
			record.setCreatetime(new Date());
			record.setOrderid(orderJbb.getOrderid());
			orderLogMapper.insertSelective(record);
		} else {
			logger.error("不能更改价格，状态不对");
		}

	}

	@Override
	public List<Product> listKeepingType() {
		ProductExample example = new ProductExample();
		example.createCriteria().andServiceTypeEqualTo("BOOKKEEPING");
		return productMapper.selectByExample(example);

	}

	@Override
	public List<Intention> getIntentionList() {
		return intentionMapper.selectByExample(new IntentionExample());

	}

	@Override
	public List<OrderStatusFlow> getOrderStatusFlow(Long orderId) {
		OrderStatusFlowExample example = new OrderStatusFlowExample();
		example.createCriteria().andOrderIdEqualTo(orderId + "");
		return orderStatusFlowMapper.selectByExample(example);

	}

	@Override
	public List<Product> listKeepingType(String cityCode, String cityName) {
		ProductExample example = new ProductExample();
		com.jbb.user.biz.entity.ProductExample.Criteria e = example.createCriteria();
		e.andServiceTypeEqualTo("BOOKKEEPING").andProductStatusEqualTo((byte) 1);
		if (!StringUtils.isEmpty(cityCode)) {
			e.andCityCodeEqualTo(Integer.valueOf(cityCode));
		}
		if (!StringUtils.isEmpty(cityName)) {
			e.andCityNameEqualTo(cityName);
		}
		return productMapper.selectByExample(example);

	}

	@Override
	public List<Product> listCompanyProduct(String cityCode) {
		ProductExample example = new ProductExample();
		com.jbb.user.biz.entity.ProductExample.Criteria e = example.createCriteria();
		e.andServiceTypeEqualTo("COMPANY_REGISTER").andPackageStatusEqualTo((byte) 1);
		if (!StringUtils.isEmpty(cityCode)) {
			e.andCityCodeEqualTo(Integer.valueOf(cityCode));
		}
		return productMapper.selectByExample(example);

	}

	@Override
	public List<Product> getCityProductList(Integer cityCode) {
		ProductExample example = new ProductExample();
		example.createCriteria().andCityCodeEqualTo(cityCode);
		return productMapper.selectByExample(example);
	}

}
