/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.jbb.enterprise.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jbb.user.api.dto.UserLoginDTO;
import com.jbb.user.biz.entity.ExpertLogin;

/**
 * @author yangxiangqian
 *
 */
public class UserConextInterceptor extends HandlerInterceptorAdapter {

	public static ThreadLocal<UserLoginDTO> userContext = new ThreadLocal<UserLoginDTO>();
	public static ThreadLocal<ExpertLogin> loginContext = new ThreadLocal<ExpertLogin>();

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (null != request.getSession().getAttribute("user")) {
			UserLoginDTO user = (UserLoginDTO) request.getSession().getAttribute("user");
			userContext.set(user);
		}
		if (null != request.getSession().getAttribute("expert")) {
			ExpertLogin user = (ExpertLogin) request.getSession().getAttribute("expert");
			loginContext.set(user);
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		userContext.remove();
		loginContext.remove();
	}
}
