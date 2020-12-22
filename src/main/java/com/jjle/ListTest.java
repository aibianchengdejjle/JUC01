package com.jjle;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {

    public static void main(String[] args) {
        List<String>listTest=new CopyOnWriteArrayList<>();
        //List<String>listTest=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                listTest.add(UUID.randomUUID().toString());
                System.out.println(listTest);

            },String.valueOf(i)).start();
        }
    }
}

