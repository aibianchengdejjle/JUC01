package com.jjle;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo02 {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                ticket02.sale();
            }
        },"A").start();

        new Thread(()->{
            for(int i=0;i<40;i++){
                ticket02.sale();
            }
        },"B").start();

        new Thread(()->{
            for(int i=0;i<40;i++){
                ticket02.sale();
            }
        },"C").start();
    }


}
class  ticket02{
    private static int number=50;
    //使用lock锁
   static Lock lock=new ReentrantLock();
    public static void sale(){

        lock.lock();
        try {
            if(number>0){
                System.out.println("卖出了第几"+number--+"票");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
