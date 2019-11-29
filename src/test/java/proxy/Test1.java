package proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test1 {

    public Test1(){

    }

    public void testDynamic(){
        System.out.println("1234");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Test1 test1=new Test1();
        Class c1=Class.forName("proxy.Test1");
        Constructor c2= c1.getConstructor();
        Test1 c= (Test1)c2.newInstance(new Object[] {});
        c.testDynamic();
    }
}
