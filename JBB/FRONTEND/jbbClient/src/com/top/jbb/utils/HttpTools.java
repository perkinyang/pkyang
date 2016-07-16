package com.top.jbb.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class HttpTools {
	
	public static void httpGet(String url,Map<String,String> map,final CallBackInterface callBack) {
		if(!callBack.preCallBack(null)){
			return;
		}
		HttpUtils httpUtils = new HttpUtils();
		RequestParams params = new RequestParams();
		if(map!=null && map.size()>0){
			for(Map.Entry<String, String> entry:map.entrySet()){
				params.addQueryStringParameter(entry.getKey(),entry.getValue());
			}
		}
		httpUtils.send(HttpMethod.GET, url,
				params, new RequestCallBack<String>() {
					@Override
					public void onFailure(HttpException arg0, String arg1) {					
						callBack.failCallBack(null);
					}
					@Override
					public void onSuccess(ResponseInfo<String> response) {
						callBack.successCallBack(response,null);
					}
				});

	}

	public static void httpPost(String url,Map<String,String> map,final CallBackInterface callBack) {
		if(!callBack.preCallBack(null)){
			return;
		}
		HttpUtils httpUtils = new HttpUtils();
		RequestParams params = new RequestParams();
		params.setHeader("Content-Type", "application/json");
		try {
			StringEntity entity = new StringEntity(mapToJson(map));
			params.setBodyEntity(entity);
		} catch (Exception e) {
		}
		
		httpUtils.send(HttpMethod.POST,url,params, new RequestCallBack<String>() {
					@Override
					public void onFailure(HttpException arg0, String arg1) {
						Map<String,Object> map=new HashMap<String,Object>();
						map.put("exception", arg0);
						map.put("desc", arg1);
						callBack.failCallBack(map);
					}

					@Override
					public void onSuccess(ResponseInfo<String> response) {
						callBack.successCallBack(response, null);
					}
				});

	}
	
	public static void httpPost(String url,JSONObject json,final CallBackInterface callBack) throws UnsupportedEncodingException {
		if(!callBack.preCallBack(null)){
			return;
		}
		HttpUtils httpUtils = new HttpUtils();
		RequestParams params = new RequestParams();
		params.setHeader("Content-Type", "application/json");
		if(json!=null){
			params.setBodyEntity(new StringEntity(json.toString()));
		}
		httpUtils.send(HttpMethod.POST,url,params, new RequestCallBack<String>() {
					@Override
					public void onFailure(HttpException arg0, String arg1) {
						Map<String,Object> map=new HashMap<String,Object>();
						map.put("exception", arg0);
						map.put("desc", arg1);
						callBack.failCallBack(map);
					}

					@Override
					public void onSuccess(ResponseInfo<String> response) {
						callBack.successCallBack(response, null);
					}
				});

	}
	private static String mapToJson(Map<String,String> map){
		JSONObject json=new JSONObject();
		try {
			for(Map.Entry<String, String> entry:map.entrySet()){
				json.put(entry.getKey(),entry.getValue());
			}
		} catch (JSONException e) {
			
		}
		return json.toString();
	}
}
