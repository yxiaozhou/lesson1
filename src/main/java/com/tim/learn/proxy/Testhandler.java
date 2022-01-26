package com.tim.learn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: yangxz
 * @Description:
 * @CreateDate: 2021/4/8/008 11:05
 * @Version: 1.0
 */
public class Testhandler implements InvocationHandler {
    private Object object;
    public Testhandler(Object object){
        this.object = object;
    }
    public void setObject(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        method.invoke(object,args);
        System.out.println("after invoke");
        return null;
    }
}
