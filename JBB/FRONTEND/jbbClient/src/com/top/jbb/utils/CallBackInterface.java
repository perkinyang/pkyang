package com.top.jbb.utils;

import java.util.Map;

import com.lidroid.xutils.http.ResponseInfo;

public interface CallBackInterface {
	abstract public void successCallBack(ResponseInfo<String> response,Map<String,Object> map2);
	abstract public void failCallBack(Map<String,Object> map);
	abstract public boolean preCallBack(Map<String,Object> map);
	abstract public void postCallBack(Map<String,Object> map);
	
}
