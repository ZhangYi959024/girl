package com.girl.exception;

import com.girl.enums.HttpResultEnum;

public class GirlException extends RuntimeException {
    private String code;
    public GirlException(HttpResultEnum httpResultEnum){
        super(httpResultEnum.getMessage());
        this.code=httpResultEnum.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
