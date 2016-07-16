package com.jbb.account.customer.app.request.user;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2016/1/2.
 */
public class ValidateCodeRequest {

    private String telephone;

    private String smsAuthCode;

    @ApiModelProperty(value = "手机号")
    public String getTelephone() {
        return telephone;
    }

    @ApiModelProperty(value = "手机号")
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @ApiModelProperty(value = "验证码")
    public String getSmsAuthCode() {
        return smsAuthCode;
    }

    @ApiModelProperty(value = "验证码")
    public void setSmsAuthCode(String smsAuthCode) {
        this.smsAuthCode = smsAuthCode;
    }

}
