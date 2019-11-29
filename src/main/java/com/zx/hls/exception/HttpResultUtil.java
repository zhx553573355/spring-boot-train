package com.zx.hls.exception;

public class HttpResultUtil {

    public static HttpResult success() {
        HttpResult result = new HttpResult();
        result.setStatus(0);
        result.setMsg("success");
        return result;
    }


    public static HttpResult success(Object object) {
        HttpResult result = new HttpResult();
        result.setStatus(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    public static HttpResult error(Integer code, String msg) {
        HttpResult result = new HttpResult();
        result.setStatus(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    /**
     * 请求异常处理
     *
     * @param exceptionEnum
     * @return
     */
    public static HttpResult error(ExceptionEnum exceptionEnum) {
        HttpResult result = new HttpResult();
        result.setStatus(exceptionEnum.getCode());
        result.setMsg(exceptionEnum.getMsg());
        result.setData(null);
        return result;
    }
}
