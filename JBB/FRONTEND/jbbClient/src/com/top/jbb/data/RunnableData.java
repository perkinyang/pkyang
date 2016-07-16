package com.top.jbb.data;

import java.util.ArrayList;
import java.util.List;

import com.top.jbb.bean.tel400.ProductPrice;

public class RunnableData {
	public static List<ProductPrice> packagePriceList;
	public static List<ProductPrice> additionalFunctionList;
	public static List<ProductPrice> valueAddServiceList;
	
	
	public static void  genList(List<ProductPrice> list){
		packagePriceList=new ArrayList<ProductPrice>();
		additionalFunctionList=new ArrayList<ProductPrice>();
		valueAddServiceList=new ArrayList<ProductPrice>();
		for(ProductPrice p:list){
			if("400_PACKAGE".equals(p.getServiceType())){
				packagePriceList.add(p);
			}else if("400_ADDITIONAL_FUNCTION".equals(p.getServiceType())){
				additionalFunctionList.add(p);
			}else if("400_VALUE_ADDED_SERVICE".equals(p.getServiceType())){
				valueAddServiceList.add(p);
			}
		}
	}
}
