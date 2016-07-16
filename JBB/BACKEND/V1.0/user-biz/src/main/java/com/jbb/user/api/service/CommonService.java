package com.jbb.user.api.service;

import java.util.List;

import com.jbb.user.biz.entity.Area;
import com.jbb.user.biz.entity.Category;
import com.jbb.user.biz.entity.Industry;

public interface CommonService {

	public List<Area> getAreaList(Area area);

	public List<Industry> getIndustyList();

	public List<Area> getAllAreaList();

	List<Category> listKeepingType(String groupName);

}
