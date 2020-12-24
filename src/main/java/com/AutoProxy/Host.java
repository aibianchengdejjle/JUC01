package com.AutoProxy;

import java.util.concurrent.locks.ReadWriteLock;

public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房屋出租");
    }
}
