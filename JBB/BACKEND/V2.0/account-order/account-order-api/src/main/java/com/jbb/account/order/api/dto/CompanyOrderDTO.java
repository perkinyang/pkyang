package com.jbb.account.order.api.dto;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModelProperty;


public class CompanyOrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private String loginName;

    private String password;

    private Integer version;

    //1：android 2：ios 3：web
    private Integer appType;

    private String appCode;

    private String token;

    @ApiModelProperty(value = "登录用户名",required = true)
    public String getLoginName() {
        return loginName;
    }

    @ApiModelProperty(value = "登录用户名",required = true)
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @ApiModelProperty(value = "登录密码",required = true)
    public String getPassword() {
        return password;
    }

    @ApiModelProperty(value = "登录密码",required = true)
    public void setPassword(String password) {
        this.password = password;
    }

    @ApiModelProperty(value = "客户端版本号")
    public Integer getVersion() {
        return version;
    }

    @ApiModelProperty(value = "客户端版本号")
    public void setVersion(Integer version) {
        this.version = version;
    }

    @ApiModelProperty(value = "客户端类型 1：android 2：iphone 3：web",required = true)
    public Integer getAppType() {
        return appType;
    }

    @ApiModelProperty(value = "客户端类型 1：android 2：iphone 3：web",required = true)
    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    @ApiModelProperty(value = "客户端AppCode 货主：yunma_cargo_iphone,yunma_cargo_android 经纪人：yunma_broker_iphone,yunma_broker_android")
    public String getAppCode() {
        return appCode;
    }

    @ApiModelProperty(value = "客户端AppCode 货主：yunma_cargo_iphone,yunma_cargo_android 经纪人：yunma_broker_iphone,yunma_broker_android")
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    @ApiModelProperty(value = "推送token")
    public String getToken() {
        return token;
    }

    @ApiModelProperty(value = "userId")
    public void setToken(String token) {
        this.token = token;
    }
    @ApiModelProperty(value = "推送token")
    public Long getUserId() {
        return userId;
    }
    @ApiModelProperty(value = "userId")
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
