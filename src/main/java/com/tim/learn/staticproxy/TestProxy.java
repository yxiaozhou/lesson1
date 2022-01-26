package com.tim.learn.staticproxy;

/**
 * @Author: yangxz
 * @Description:
 * @CreateDate: 2021/4/8/008 11:00
 * @Version: 1.0
 */
public class TestProxy implements TestInterface {
    TestInterfaceImpl testInterface = new TestInterfaceImpl();
    @Override
    public void sayHello() {
        System.out.println("before hello");
        testInterface.sayHello();
        System.out.println("after hello");
    }
}
