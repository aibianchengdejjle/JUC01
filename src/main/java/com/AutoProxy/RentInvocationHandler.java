package com.AutoProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RentInvocationHandler implements InvocationHandler {
    private Object object;

    public  RentInvocationHandler(Object object) {
        this.object = object;
    }

    /**
     * @param proxy:代理类
     * @param method：代理类调用处理程序的方法对象
     * @param args：方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("使用动态代理做的一些增强的操作......");
        //第一个参数表示真实对象
        //第二个参数表示参数
        Object result = method.invoke(object, args);
        return result;
    }
}
