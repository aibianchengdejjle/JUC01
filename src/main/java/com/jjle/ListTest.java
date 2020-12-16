package com.jjle;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i <10000 ; i++) {
                test Test=new test();
                Test.c();
            }
        },"c").start();


        new Thread(()->{
            for (int i = 0; i <10000; i++) {
                test Test1=new test();
                Test1.d();
            }
        },"d").start();


        new Thread(()->{
            for (int i = 0; i <50000 ; i++) {
                test Test2=new test();
                Test2.e();
            }
        },"e").start();
    }
}
class  test{
    private static int i=0;
    public  void c(){
        i++;
        System.out.println(Thread.currentThread().getName()+i);
    }

    public  void d(){
        i++;
        System.out.println(Thread.currentThread().getName()+i);
    }
    public  void e(){
        i++;
        System.out.println(Thread.currentThread().getName()+i);
    }
}

