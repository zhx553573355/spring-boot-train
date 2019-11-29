package com.zx.proxy.dynamicproxy.jdk;

public class Employee implements Person {

    String name;

    public Employee(String name){
        this.name=name;
    }

    @Override
    public void talk() {
        System.out.println(this.name+":开始说话");
    }
}
