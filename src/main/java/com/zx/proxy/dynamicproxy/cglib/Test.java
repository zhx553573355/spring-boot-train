package com.zx.proxy.dynamicproxy.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;

public class Test {
    //正常的调用
    public void test(){
        Person zhangsan =new Employee("张三");
        zhangsan.talk();
    }



    public static void main(String[] args) {
        //代理类保存到指定文件夹
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");

        //增强
        Enhancer enhancer = new Enhancer();

        //设置父类
        enhancer.setSuperclass(Employee.class);

        //设置回调
        enhancer.setCallback(new MethodInteceptProxy());

        //设置回调过滤器
        //enhancer.setCallbackFilter(new CallbackFilterImpl());

        //创建代理类实例
        Employee lisi=(Employee)enhancer.create();
        lisi.setName("张三");
        lisi.talk();

    }
}
