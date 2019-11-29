package com.zx.proxy.dynamicproxy.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MethodInteceptProxy implements MethodInterceptor {

    /**
     *
     * @param o 动态生成的代理对象
     * @param method 被代理的抽象方法
     * @param objects 方法入参
     * @param methodProxy 代理方法
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        if (method.getName()=="talk") {

            System.out.println("大家欢迎。。。");
            System.out.println("调用方法；" + method.getName());
            System.out.println("调用实例：" + o.getClass().getName());

            for (Object ob : objects) {
                System.out.println(ob.getClass().getName());
            }

            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("大家鼓掌。。。");
            return result;
        }else
        {
            return o;
        }

    }
}
