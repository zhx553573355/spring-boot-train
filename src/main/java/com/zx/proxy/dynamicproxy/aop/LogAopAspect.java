package com.zx.proxy.dynamicproxy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 切面类，用于对业务层进行增强
 */
@Aspect
@Component
public class LogAopAspect {
    private Logger logger = LoggerFactory.getLogger(LogAopAspect.class);

    /**
     * 切入点，EmployeeService类下的talk带任何参数的方法
     */
    @Pointcut("execution (public * com.zx.proxy.dynamicproxy.aop.EmployeeService.talk(..))")
    public void log(){
        System.out.println("定义切入点");
    }


    //在
    @Before("log()")
    public void writeLogBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }
}
