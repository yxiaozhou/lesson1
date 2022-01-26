package com.tim.learn.staticproxy;

/**
 * @Author: yangxz
 * @Description:
 * @CreateDate: 2021/4/8/008 10:48
 * @Version: 1.0
 */
public class TestInterfaceImpl implements TestInterface {
    @Override
    public void sayHello() {
        System.out.println("hello yxz;");
    }
}
