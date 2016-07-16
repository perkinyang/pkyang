package com.jbb.user.api.service;

import java.util.List;

import com.jbb.user.api.dto.NumberRequest;
import com.jbb.user.biz.entity.Number400;
import com.jbb.user.biz.entity.Product;

public interface Number400Service {

	List<Number400> getNumberList(NumberRequest number);

	List<com.jbb.user.biz.entity.Number400Service> getNumberServices();

	List<Product> getProductList(String cityCode, String cityName);

	Product getMinumnPrice(String number, String cityCode, String cityName);

	void numberSold(String number);

	boolean isNumbeInPrompation(String number);

	boolean isGoldlenNumber(String number);
}
