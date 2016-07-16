package com.jbb.enterprise.app.enums;

public enum ClientCode {
    SUCCESS(1, "成功"),
    USER_NOT_LOGIN(-1000,"用户未登录"),
    SYSTEM_WRONG(-1001, "系统繁忙，请稍后重试"),
    CHECK_VERIFYCODE_NOTEXIST(-1002,"验证码不存在或已失效"),
    USER_EXIST(-1003,"用户已注册"),
    USER_NOT_EXIST(-1004,"用户已注册"),
    
    OBJECT_NOT_FOUND(-201,"未找到请求的数据"),
    BAD_REQUEST(-203,"无效的请求"),
    UPLOAD_FILE_ERROR(-204,"文件上传错误"),

    

    PWD_INVALID(-1002,"密码格式不合法"),

    BANKCARD_NOT_EXIST(-2001,"未绑定银行卡"),

    

    

    LOGIN_ERROR(-100,"登录失败，用户不存在或密码错误"),
    SET_PWD_ERROR(-101,"用户已经注册"),
    ;

    private int code;

    private String msg;

    private ClientCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
