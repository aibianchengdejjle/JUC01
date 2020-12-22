package com.Single;

public class lazy {
    private  lazy(){
        System.out.println(Thread.currentThread().getName());
    }
    //必须加入volatile 禁止多线程情况下的指令重排序
    private  volatile static  lazy lazyMan;
    public static lazy getInstance(){
        if(lazyMan==null){
            synchronized (lazy.class){
                if (lazyMan==null){
                    lazyMan=new lazy();   //不是一个原子性操作
                }
            }
        }
        return  lazyMan;
    }

    //但是有反射
    public static void main(String[] args) {

    }
}
