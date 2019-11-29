package com.zx.proxy.dynamicproxy.jdk;

import com.sun.xml.internal.stream.buffer.MutableXMLStreamBuffer;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.*;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {

    }


    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Person zhangsan = new Employee("zhangsan");
        //创建代理类
        Class<?> proxyClass=Proxy.getProxyClass(Test.class.getClassLoader(),new Class<?>[]{Person.class});
        //代理类构造函数
        Constructor<?> constructor= proxyClass.getConstructor();

        Object o=constructor.newInstance();
    }


    public void test3(){
        //打印动态生成的代理文件的字节码，并保存在根目录下；
        //D:\my_idea\spring-boot-train\com\sun\proxy\$Proxy0.class
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        Person zhangsan = new Employee("zhangsan");

        //调用操作
        InvocationHandler invocationHanderProxy = new InvocationHanderProxy(zhangsan);
        //创建代理对象，
        Person lisi = (Person) Proxy.newProxyInstance(zhangsan.getClass().getClassLoader(), zhangsan.getClass().getInterfaces(), invocationHanderProxy);
        lisi.talk();
    }
}
