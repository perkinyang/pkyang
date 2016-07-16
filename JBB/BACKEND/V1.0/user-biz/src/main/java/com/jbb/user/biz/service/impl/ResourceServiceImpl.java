/**
 * 
 */
package com.jbb.user.biz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.jbb.user.api.service.ResourceService;
import com.jbb.user.biz.entity.Business;
import com.jbb.user.biz.entity.BusinessExample;
import com.jbb.user.biz.entity.JbbResource;
import com.jbb.user.biz.entity.JbbResourceExample;
import com.jbb.user.biz.mapper.BusinessMapper;
import com.jbb.user.biz.mapper.JbbResourceMapper;

/**
 * @author yangxiangqian
 *
 */
@Service
public class ResourceServiceImpl implements ResourceService {

	@Resource
	private JbbResourceMapper jbbResourceMapper;

	@Resource
	private BusinessMapper businessMapper;

	@Override
	public JbbResource getResource(String resourceCode) {

		JbbResourceExample example = new JbbResourceExample();
		example.createCriteria().andResourceCodeEqualTo(resourceCode);

		List<JbbResource> list = jbbResourceMapper.selectByExample(example);
		if (!CollectionUtils.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Business> getServiceList(String city) {
		BusinessExample example = new BusinessExample();
		example.createCriteria().andStatusEqualTo(true).andCityNameEqualTo(city);
		return businessMapper.selectByExample(example);

	}

	@Override
	public List<JbbResource> getBusiness(JbbResource source) {

		JbbResourceExample example = new JbbResourceExample();
		com.jbb.user.biz.entity.JbbResourceExample.Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmpty(source.getCityCode())) {
			criteria.andCityCodeEqualTo(source.getCityCode());
		}
		if (!StringUtils.isEmpty(source.getGroupName())) {
			criteria.andGroupNameEqualTo(source.getGroupName());
		}
		example.setOrderByClause(" sequence asc");
		
		List<JbbResource> list = jbbResourceMapper.selectByExample(example);

		return list;
	}
}
