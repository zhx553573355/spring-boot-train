package com.zx.proxy.dynamicproxy.aop;

public class Employee implements Person {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(){

    }

    public Employee(String name){
        this.name=name;
    }

    @Override
    public void talk() {
        System.out.println(this.name+":开始说话");
    }
}
