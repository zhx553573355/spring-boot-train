package com.zx.proxy.staticproxy;

public class Test {
    public static void main(String[] args) {
        /**
         * 为什么需要增加代理：
         * 优点可以不需要修改原来的类对应的方法，直接新增一个代理类，调用代理类方法，增加处理逻辑
         * 缺点是  需要新增很多代理类。代码冗余
         */
        Person zhangsan = new Employee("zhangsan");
        Person lisi = new EmployeeProxy("lisi", zhangsan);
        lisi.talk();
    }
}
