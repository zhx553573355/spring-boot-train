package com.zx.proxy.staticproxy;

import java.util.Date;

/**
 * 代理员工发表演讲
 */
public class EmployeeProxy implements Person {
    String name;
    Person person;

    EmployeeProxy(String name,Person person){
        this.name=name;
        this.person=person;
    }

    public void talk(){
        System.out.println("需要增加的内容:");
        this.person.talk();
        System.out.println("讲话结束");
    }

}
