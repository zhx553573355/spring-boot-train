package com.zx.proxy.dynamicproxy.jdk;

import org.springframework.data.relational.core.sql.In;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHanderProxy implements InvocationHandler {

    Object target;

    public InvocationHanderProxy(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("开始代理对象："+ this.target+","+ method.getName());
        Object obj=method.invoke(this.target,args);
        return obj;
    }
}
