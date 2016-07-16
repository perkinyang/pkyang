/**
 * 
 */
package com.jbb.user.biz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.jbb.user.api.service.OrderService;
import com.jbb.user.api.service.PaymentService;
import com.jbb.user.biz.entity.OrderJbb;
import com.jbb.user.biz.entity.OrderJbbExample;
import com.jbb.user.biz.entity.PaymentInfo;
import com.jbb.user.biz.mapper.OrderJbbMapper;
import com.jbb.user.biz.mapper.PaymentInfoMapper;
import com.jbb.util.StatusCode;

/**
 * @author yangxiangqian
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	@Resource
	private PaymentInfoMapper paymentInfoMapper;

	@Resource
	private OrderJbbMapper orderJbbMapper;

	@Resource
	private OrderService orderService;

	private static Logger logger = Logger.getLogger(PaymentServiceImpl.class);

	@Override
	public void save(PaymentInfo paymentInfo) {
		paymentInfoMapper.insertSelective(paymentInfo);
		if (paymentInfo.getTransactionType().equalsIgnoreCase("pay")) {
			OrderJbbExample example = new OrderJbbExample();
			example.createCriteria().andOrderidEqualTo(paymentInfo.getTransactionId());
			List<OrderJbb> list = orderJbbMapper.selectByExample(example);
			if (!CollectionUtils.isEmpty(list)) {
				OrderJbb jbb = list.get(0);
				if (jbb.getStatus().equalsIgnoreCase(StatusCode.pay_success.getCode())) {
					logger.error("信息已处理过了");
				}
				jbb.setStatus(StatusCode.pay_success.getCode());
				jbb.setPayAmount(paymentInfo.getTransactionFee());
				orderService.changeOrderStatus(jbb.getId(), StatusCode.pay_success.getCode(), -1);
				orderJbbMapper.updateByPrimaryKey(jbb);
				
			}
		} else if (paymentInfo.getTransactionType().equalsIgnoreCase("REFUND")) {

			OrderJbbExample example = new OrderJbbExample();
			example.createCriteria().andOrderidEqualTo(paymentInfo.getTransactionId());
			List<OrderJbb> list = orderJbbMapper.selectByExample(example);
			if (!CollectionUtils.isEmpty(list)) {
				OrderJbb jbb = list.get(0);
				if (jbb.getStatus().equalsIgnoreCase(StatusCode.refund_success.getCode())) {
					logger.error("信息已处理过了");
				}
				jbb.setStatus(StatusCode.refund_success.getCode());
				jbb.setRemark(paymentInfo.getTransactionFee() + "");
				orderJbbMapper.updateByPrimaryKey(jbb);
			}

		}

	}

}
