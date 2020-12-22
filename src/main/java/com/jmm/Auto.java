package com.jmm;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Auto {
    private  static volatile int num=0;
    public static void main(String[] args) throws InterruptedException {
        Lock lock=new ReentrantLock();
        for (int i = 0; i <20 ; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    lock.lock();
                    try {
                        add();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+",num="+num);
    }
    public static void add(){
       num++;
    }
}
