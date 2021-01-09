package com.girl.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 拦截器
 */
@Component
@Aspect
public class HttpGirlAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpGirlAspect.class);

    /**
     *  需要拦截的方法
     */
    @Pointcut("execution(public * com.girl.controller.GirlController.*(..))")
    public void log() {
    }

    /**
     *  拦截前执行方法
     * @param joinPoint 需要拦截的方法
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = attributes.getRequest();
        //url
        logger.info("url={}", httpServletRequest.getRequestURL());
        //method
        logger.info("method={}", httpServletRequest.getMethod());
        //ip
        logger.info("ip={}", httpServletRequest.getRemoteAddr());
        logger.info("ip={}", httpServletRequest.getRemoteHost());
        //port
        logger.info("port={}",httpServletRequest.getRemotePort());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("class_args={}",joinPoint.getArgs());
    }

    /**
     * 拦截后的方法
     */
    @After("log()")
    public void doAfter() {
        logger.info("拦截后的方法");
    }
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("++++++++++++++++++++++++reponse={}",object.toString());
    }
}
