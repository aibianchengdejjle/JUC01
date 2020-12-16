package com.jjle;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
*   a b c 三个按照顺序执行
*
*/
public class CustomProvider03 {
    public static void main(String[] args) {
        Data03 data03=new Data03();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                data03.printA();
            }
        },"a").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                data03.printB();
            }
        },"b").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                data03.printC();
            }
        },"c").start();
    }

}
class  Data03{  //资源类
    private Lock lock=new ReentrantLock();
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();
    private  int number=1;
    public  void printA(){
        lock.lock();
        try {
            while (number!=1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"AAA");
            //唤醒指定的人
            number++;
            condition2.signal();
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           lock.unlock();
       }
    }


    public  void printB(){
        lock.lock();
        try {
            while (number!=2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"bbbb");
            number++;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public  void printC(){
        lock.lock();
        try {
            while (number!=3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"ccc");
            number=1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
