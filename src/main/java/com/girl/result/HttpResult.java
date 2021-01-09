package com.girl.result;

public class HttpResult<Object> {
    private String  code;
    private String resultMessage;
    private Object data;

    public HttpResult() {
    }

    public HttpResult(String code, String resultMessage, Object data) {
        this.code = code;
        this.resultMessage = resultMessage;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "code='" + code + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                ", data=" + data +
                '}';
    }
}
