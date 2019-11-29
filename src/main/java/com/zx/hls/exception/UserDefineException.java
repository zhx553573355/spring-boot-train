package com.zx.hls.exception;

/**
 * 自定义异常
 */
public class UserDefineException extends RuntimeException {


    private Integer code;

    public UserDefineException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    public UserDefineException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
