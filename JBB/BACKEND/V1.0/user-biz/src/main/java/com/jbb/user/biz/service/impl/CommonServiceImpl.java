package com.jbb.user.biz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.util.StringUtils;

import com.jbb.user.api.service.CommonService;
import com.jbb.user.biz.dao.CityDao;
import com.jbb.user.biz.entity.Area;
import com.jbb.user.biz.entity.AreaExample;
import com.jbb.user.biz.entity.Category;
import com.jbb.user.biz.entity.CategoryExample;
import com.jbb.user.biz.entity.Industry;
import com.jbb.user.biz.entity.IndustryExample;
import com.jbb.user.biz.mapper.AreaMapper;
import com.jbb.user.biz.mapper.CategoryMapper;
import com.jbb.user.biz.mapper.IndustryMapper;

public class CommonServiceImpl implements CommonService {

	@Resource
	private CityDao cityDao;

	@Resource
	private AreaMapper areaMapper;

	@Resource
	private IndustryMapper industryMapper;

	@Resource
	private CategoryMapper categoryMapper;

	@Override
	public List<Area> getAreaList(Area area) {
		AreaExample example = new AreaExample();
		if (null == area.getCode()) {
			area.setCode(0);
		}
		if (null == area.getLevel()) {
			area.setLevel(1);
		}
		example.createCriteria().andParentidEqualTo(area.getCode()).andLevelEqualTo(area.getLevel());
		return areaMapper.selectByExample(example);
	}

	@Override
	public List<Industry> getIndustyList() {
		IndustryExample example = new IndustryExample();
		example.createCriteria().andCodeBetween("A", "Z");
		return industryMapper.selectByExample(example);
	}

	@Override
	public List<Area> getAllAreaList() {
		return areaMapper.selectAll();
	}

	@Override
	public List<Category> listKeepingType(String groupName) {
		CategoryExample example = new CategoryExample();
		if (!StringUtils.isEmpty(groupName)) {
			example.createCriteria().andGroupNameEqualTo(groupName.toUpperCase());
		}
		return categoryMapper.selectByExample(example);

	}
}
