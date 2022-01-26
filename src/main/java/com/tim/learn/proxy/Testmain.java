package com.tim.learn.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author: yangxz
 * @Description:
 * @CreateDate: 2021/4/8/008 11:11
 * @Version: 1.0
 */
public class Testmain {
    public static void main(String[] args) {
        TestInterface testInterface = new TestInterfaceImpl();
        Testhandler testhandler = new Testhandler(testInterface);

        TestInterfaceB testInterfaceB = new TestInterfaceBImpl();
//        Testhandler testhandlerb = new Testhandler(testInterfaceB);
        TestInterface iProxy = (TestInterface) Proxy.newProxyInstance(testInterface.getClass().getClassLoader(),testInterface.getClass().getInterfaces(),testhandler);
        iProxy.sayHello();
        iProxy.sayHello2();
        TestInterfaceB iProxyB = (TestInterfaceB) Proxy.newProxyInstance(testInterfaceB.getClass().getClassLoader(),testInterfaceB.getClass().getInterfaces(),testhandler);
        testhandler.setObject(testInterfaceB);
        iProxyB.sayBye();
        iProxy.sayHello2();
    }
}
