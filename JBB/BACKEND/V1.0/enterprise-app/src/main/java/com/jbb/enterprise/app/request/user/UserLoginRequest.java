package com.jbb.enterprise.app.request.user;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2016/1/2.
 */
public class UserLoginRequest {

    private String telephone;

    private String passwd;

    @ApiModelProperty(value = "手机号")
    public String getTelephone() {
        return telephone;
    }

    @ApiModelProperty(value = "手机号")
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @ApiModelProperty(value = "密码")
    public String getPasswd() {
        return passwd;
    }

    @ApiModelProperty(value = "密码")
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
