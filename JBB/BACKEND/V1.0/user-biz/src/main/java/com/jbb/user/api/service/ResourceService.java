package com.jbb.user.api.service;

import java.util.List;

import com.jbb.user.biz.entity.Business;
import com.jbb.user.biz.entity.JbbResource;

public interface ResourceService {

	JbbResource getResource(String resourceCode);

	List<Business> getServiceList(String city);

	List<JbbResource> getBusiness(JbbResource source);

}
