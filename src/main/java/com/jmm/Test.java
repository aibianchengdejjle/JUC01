package com.jmm;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Test {
    private  volatile static  int num=0;
    public static void main(String[] args) {
        new Thread(()->{
            while (num==0){

            }
        }).start();
        // 让线程睡一秒，让线程能够完全的被执行起来。
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        num=1;
        System.out.println(num);
    }
}
