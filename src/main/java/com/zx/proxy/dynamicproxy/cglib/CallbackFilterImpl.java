package com.zx.proxy.dynamicproxy.cglib;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class CallbackFilterImpl implements CallbackFilter {

    //返回的数字代表回调函数的数组索引，可以支持多个回调函数
    @Override
    public int accept(Method method) {
        if (method.getName()=="talk"){
            System.out.println("是talk方法");
        return 0;
        }else {
            System.out.println("不是talk方法");
            return 1;
        }
    }
}
