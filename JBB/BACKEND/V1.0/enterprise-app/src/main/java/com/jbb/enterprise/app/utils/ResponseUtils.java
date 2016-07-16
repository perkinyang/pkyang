package com.jbb.enterprise.app.utils;

import com.jbb.enterprise.app.enums.ClientCode;
import com.jbb.enterprise.app.response.Response;

public class ResponseUtils {
	
	public static void setErrorResponse(Response response,ClientCode code){
		response.setErrorMsg(code.getMsg());
		response.setResult(code.getCode());
	}
}
