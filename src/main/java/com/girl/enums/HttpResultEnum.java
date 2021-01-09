package com.girl.enums;

public enum HttpResultEnum {
    UNKNOW_EXCEPTION("-1","系统未知异常"),
    SUCCESS("0000","成功"),
    PRIMARY_SCHOOL("1000","你还在上小学吧"),
    MIDDLE_SCHOOL("1001","你可能还在上初中");
    private String code;
    private String message;

    HttpResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
