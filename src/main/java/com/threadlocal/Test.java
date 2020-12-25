package com.threadlocal;

import java.util.concurrent.TimeUnit;

public class Test {
    static  ThreadLocal<Person>test=new ThreadLocal<Person>();

    public static void main(String[] args) {
        new Thread(()->{
            test.set(new Person("ljjsb"));
            test.set(new Person("jjl"));
            System.out.println(test.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(test.get());
        }).start();
    }
}
class Person{
    String name;
    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
