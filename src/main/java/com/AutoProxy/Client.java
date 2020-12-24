package com.AutoProxy;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        //定义一个真实对象
        Host host = new Host();
        //创建代理类
        RentInvocationHandler pih = new RentInvocationHandler(host);
        //利用Proxy.newProxyInstance生成代理类
        //第一个参数：真实类对象的类加载器
        //第二个参数：真实类对象的所有的接口
        //第三个参数：代理类对象
        Rent p = (Rent) Proxy.newProxyInstance(host.getClass().getClassLoader(),host.getClass().getInterfaces(),pih);
        p.rent();
    }
}
