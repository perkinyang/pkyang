package com.jbb.account.customer.app.utils;

import com.jbb.account.customer.app.enums.ClientCode;
import com.jbb.account.customer.app.response.Response;

public class ResponseUtils {

    public static void setErrorResponse(Response response, ClientCode clientCode) {

        response.setResult(clientCode.getCode());
        response.setErrorMsg(clientCode.getMsg());
    }
}
