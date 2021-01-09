package com.girl.girlUtils;

import com.girl.result.HttpResult;

public class HttpResultUtil {
    public static HttpResult success(Object object){
        HttpResult httpResult=new HttpResult();
        httpResult.setCode("0");
        httpResult.setResultMessage("处理成功");
        httpResult.setData(object);
        return httpResult;
    }
    public static HttpResult error(String code,String msg){
        HttpResult result=new HttpResult();
        result.setCode(code);
        result.setResultMessage(msg);
        return result;
    }
}
