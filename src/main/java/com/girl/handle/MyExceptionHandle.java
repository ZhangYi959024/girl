package com.girl.handle;

import com.girl.exception.GirlException;
import com.girl.girlUtils.HttpResultUtil;
import com.girl.result.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandle {
    private final static Logger logger= LoggerFactory.getLogger(MyExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HttpResult HttpResultHandle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException=(GirlException) e;
            return HttpResultUtil.error(((GirlException) e).getCode(),e.getMessage());
        }else{
            logger.error("[系统异常]{}",e);
            return HttpResultUtil.error("-1","系统异常");
        }
    }
}
