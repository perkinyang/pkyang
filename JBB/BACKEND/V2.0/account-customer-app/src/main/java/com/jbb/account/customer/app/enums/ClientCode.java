package com.jbb.account.customer.app.enums;

public enum ClientCode {
    SUCCESS(1, "成功"),


    SYSTEM_WRONG(-200, "系统繁忙，请稍后重试"),
    OBJECT_NOT_FOUND(-201,"未找到请求的数据"),
    BAD_REQUEST(-203,"无效的请求"),
    UPLOAD_FILE_ERROR(-204,"文件上传错误"),

    USER_NOT_LOGIN(-1000,"用户未登录"),
    FORBIDDEN(403,"权限不足"),

    EXIST_REPORT(601,"存在已上报的记录，上报失败"),

    PWD_INVALID(-1002,"密码格式不合法"),

    BANKCARD_NOT_EXIST(-2001,"未绑定银行卡"),

    IDENTITY_ERROR(-3001,"身份证号码错误"),

    CHECK_VERIFYCODE_INCORRECT(-4001,"验证码错误"),
    CHECK_VERIFYCODE_NOTEXIST(-4002,"验证码不存在或已失效"),
    LOGIN_ERROR(-100,"登录失敗，用户不存在或密码错误")
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
