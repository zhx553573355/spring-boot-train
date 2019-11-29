package com.zx.proxy.dynamicproxy.jdk;

import java.lang.reflect.*;

/**
 * 手工调用代理
 */
public class Test2 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        //创建对象
        Person zhangsan = new Employee("zhangsan");
        //获取对象的类加载器
        ClassLoader zhangsanClassLoader =zhangsan.getClass().getClassLoader();
        //获取对象的接口列表
        Class<?>[]  zhangsanInterface =zhangsan.getClass().getInterfaces();
        //通过反射动态创建代理对象，生成代理对象，被代理类必须为接口的实现类，非接口实现类无法动态生成代理对象，
        //因为JDK代理的原理是通过被代理类的接口，来动态创建一个实现类，并重写实现类的方法，达到重新重装的作用
        Class<?> cl = Proxy.getProxyClass(zhangsanClassLoader, zhangsanInterface);


        //创建代理类，代理对象为zhangsan
        InvocationHandler invocationHanderProxy =new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName()=="talk") {
                    System.out.println("大家安静，领导要开始讲话了");
                }
                    Object result= method.invoke(zhangsan,args);

                if (method.getName()=="talk") {
                    System.out.println("大家鼓掌");
                }
                return result;
            }
        };

        //获取构造
        Constructor c=cl.getDeclaredConstructor(InvocationHandler.class);

        //创建代理对象实例，并转换成PERSON
        Person proxyPerson= (Person)c.newInstance(invocationHanderProxy);

        //调用方法，实现
        proxyPerson.talk();

    }
}
