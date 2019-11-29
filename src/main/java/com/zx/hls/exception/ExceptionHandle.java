package com.zx.hls.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {


    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HttpResult exceptionGet(Exception e){
        if(e instanceof UserDefineException){
            UserDefineException MyException = (UserDefineException) e;
            return HttpResultUtil.error(MyException.getCode(),MyException.getMessage());
        }

        LOGGER.error("【系统异常】{}",e);
        return HttpResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
    }

}
