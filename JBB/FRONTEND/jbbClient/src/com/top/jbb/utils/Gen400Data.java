package com.top.jbb.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.top.jbb.bean.Number400;

public class Gen400Data {

	public static List<Map<String,List<Number400>>> getList(){
		List<Map<String,List<Number400>>> list=new ArrayList<Map<String,List<Number400>>>();
		list.add(genSelect());
		list.add(genSelect());
		list.add(genSelect());
		return list;
	}
	
	
	private static Map<String,List<Number400>> genSelect(){
		Map<String,List<Number400>> map=new HashMap<String,List<Number400>>();
		
		Number400 number1=new Number400();
		number1.setId(1);
		number1.setDisplayNumber("400888888");
		
		List<Number400> list1=new ArrayList<Number400>();
		for(int i=0;i<9;i++){
			list1.add(number1);
		}
		map.put("AAAA", list1);
		
		
		List<Number400> list2=new ArrayList<Number400>();
		for(int i=0;i<9;i++){
			list2.add(number1);
		}
		map.put("AABB", list1);
		
		return map;
	}
	
	public static List<List<Number400>> getMoreList(){
		Number400 number1=new Number400();
		number1.setId(1);
		number1.setDisplayNumber("400888888");
		
		List<Number400> list1=new ArrayList<Number400>();
		for(int i=0;i<3;i++){
			list1.add(number1);
		}
		
		List<List<Number400>> list=new ArrayList<List<Number400>>();
		for(int i=0;i<20;i++){
			list.add(list1);
		}
		return list;
	}

}
