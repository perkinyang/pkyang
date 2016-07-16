/**
 * 
 */
package com.jbb.user.biz.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.jbb.user.api.dto.NumberRequest;
import com.jbb.user.api.service.Number400Service;
import com.jbb.user.biz.entity.Number400;
import com.jbb.user.biz.entity.Number400Example;
import com.jbb.user.biz.entity.Number400Example.Criteria;
import com.jbb.user.biz.entity.Number400ServiceExample;
import com.jbb.user.biz.entity.NumberLevelProudct;
import com.jbb.user.biz.entity.NumberLevelProudctExample;
import com.jbb.user.biz.entity.Product;
import com.jbb.user.biz.entity.ProductExample;
import com.jbb.user.biz.mapper.Number400Mapper;
import com.jbb.user.biz.mapper.Number400ServiceMapper;
import com.jbb.user.biz.mapper.NumberLevelProudctMapper;
import com.jbb.user.biz.mapper.ProductMapper;

/**
 * @author yangxiangqian
 *
 */

public class Number400ServiceImpl implements Number400Service {

	@Resource
	private Number400Mapper numberMapper;

	@Resource
	private Number400ServiceMapper number400ServiceMapper;

	@Resource
	private ProductMapper productMapper;

	@Resource
	private NumberLevelProudctMapper numberLevelProudctMapper;

	@Override
	public List<Number400> getNumberList(NumberRequest number) {
		Number400Example example = new Number400Example();
		Criteria e = example.createCriteria();
		if (!StringUtils.isEmpty(number.getLevel())) {
			e.andLevelEqualTo(number.getLevel());
		}
		if (!StringUtils.isEmpty(number.getType())) {
			e.andTypeEqualTo(number.getType().toUpperCase());
		}
		if (!StringUtils.isEmpty(number.getPromptionStatus())) {
			e.andPromptionStatusEqualTo(number.getPromptionStatus());
			// e.and(number.getPromptionStatus().e);
		}

		example.setLimitStart(number.getLimitStart());
		example.setLimitEnd(number.getLimitEnd());
		return numberMapper.selectByExample(example);

	}

	@Override
	public boolean isNumbeInPrompation(String number) {
		Number400Example example = new Number400Example();
		Criteria e = example.createCriteria();
		e.andNumberEqualTo(number).andPromptionStatusEqualTo((byte) 1);
		Criteria criteria = example.createCriteria().andDisplayNumberEqualTo(number.trim())
				.andPromptionStatusEqualTo((byte) 1);
		example.or(criteria);
		return !CollectionUtils.isEmpty(numberMapper.selectByExample(example));

	}

	@Override
	public void numberSold(String number) {
		Number400Example example = new Number400Example();
		Criteria e = example.createCriteria();
		e.andNumberEqualTo(number).andStatusEqualTo((byte) 1);
		Number400 number400 = new Number400();
		number400.setStatus((byte) 0);
		number400.setUpdatetime(new Date());
		numberMapper.updateByExampleSelective(number400, example);

	}

	@Override
	public List<com.jbb.user.biz.entity.Number400Service> getNumberServices() {
		Number400ServiceExample example = new Number400ServiceExample();
		return number400ServiceMapper.selectByExample(example);

	}

	@Override
	public List<Product> getProductList(String cityCode, String cityName) {
		ProductExample example = new ProductExample();
		com.jbb.user.biz.entity.ProductExample.Criteria e = example.createCriteria();
		e.andSubBusinessNameEqualTo("400").andProductStatusEqualTo((byte) 1);
		if (!StringUtils.isEmpty(cityCode)) {
			e.andCityCodeEqualTo(Integer.valueOf(cityCode));
		}
		if (!StringUtils.isEmpty(cityName)) {
			e.andCityNameEqualTo(cityName);
		}
		return productMapper.selectByExample(example);
	}

	@Override
	public Product getMinumnPrice(String number, String cityCode, String cityName) {
		Number400Example example = new Number400Example();
		Criteria e = example.createCriteria();
		e.andStatusEqualTo(Byte.valueOf("1"));
		e.andNumberEqualTo(number);
		List<Number400> number400s = numberMapper.selectByExample(example);

		if (!CollectionUtils.isEmpty(number400s)) {
			Number400 number400 = number400s.get(0);
			NumberLevelProudctExample numberlevel = new NumberLevelProudctExample();
			com.jbb.user.biz.entity.NumberLevelProudctExample.Criteria criteria = numberlevel.createCriteria();
			criteria.andLevelEqualTo(number400.getLevel());
			if (!StringUtils.isEmpty(cityCode)) {
				criteria.andCityCodeEqualTo(Integer.valueOf(cityCode));
			}
			if (!StringUtils.isEmpty(cityName)) {
				criteria.andCityNameEqualTo(cityName);
			}
			List<NumberLevelProudct> list = numberLevelProudctMapper.selectByExample(numberlevel);
			if (!CollectionUtils.isEmpty(list)) {
				NumberLevelProudct levelProudct = list.get(0);
				return productMapper.selectByPrimaryKey(Long.valueOf(levelProudct.getPriceId()));
			}
		}
		return null;
	}

	@Override
	public boolean isGoldlenNumber(String number) {
		Number400Example example = new Number400Example();
		Criteria e = example.createCriteria().andNumberEqualTo(number.trim()).andLevelEqualTo("TOP");
		Criteria criteria = example.createCriteria().andDisplayNumberEqualTo(number.trim()).andLevelEqualTo("TOP");
		example.or(criteria);

		List<Number400> listNumer = numberMapper.selectByExample(example);
		if (!CollectionUtils.isEmpty(listNumer) && listNumer.size() >= 1) {
			return true;
		} else {
			return false;
		}
	}

}
