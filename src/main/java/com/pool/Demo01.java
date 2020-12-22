package com.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo01 {


    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程
        ExecutorService threadPool2 = Executors.newFixedThreadPool(5); //创建一个固定的线程池的大小
        ExecutorService threadPool3 = Executors.newCachedThreadPool(); //可伸缩的

        try {
            //使用了线程池要用线程池的方法调用
            for (int i = 0; i <5 ; i++) {
                threadPool3.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"ok");
                });
             }
        } catch (Exception e) {
             e.printStackTrace();
            } finally {
            threadPool3.shutdown();
        }


    }
}
