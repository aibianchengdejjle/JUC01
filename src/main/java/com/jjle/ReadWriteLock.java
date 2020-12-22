package com.jjle;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
* readwritelock
* 读读 可以共存
* 读写 不行
* 写写 不行
*
*/
public class ReadWriteLock {
    public static void main(String[] args) {
        mycache mycache=new mycache();
        //写入
        for (int i = 1; i <=5 ; i++) {
            final  int temp=i;
            new Thread(()->{
                mycache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        //读取
        for (int i = 1; i <=5 ; i++) {
            final  int temp=i;
            new Thread(()->{
                mycache.get(temp);
            },String.valueOf(i)).start();
        }
    }
}
class mycache{
    private  volatile Map<String,Object>map=new HashMap<>();
    private ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    //存 一个存
   public void put(String key, Object o){
        readWriteLock.writeLock().lock();
       try {
           System.out.println(Thread.currentThread().getName()+"存取");
           map.put(key,o);
           System.out.println(Thread.currentThread().getName()+"存取完毕");
       } catch (Exception e) {
           e.printStackTrace();
       }finally {
           readWriteLock.writeLock().unlock();
       }

    }
    //读 多个线程读
    public   void get(Object o){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读");
            Object o1 = map.get(o);
            System.out.println(Thread.currentThread().getName()+"读完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
}
