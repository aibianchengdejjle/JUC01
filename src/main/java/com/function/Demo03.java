package com.function;

import java.util.function.Consumer;
/*
    只有输入没有返回值
 */
public class Demo03 {
    public static void main(String[] args) {
        Consumer<String> consumer = (str)->{
            System.out.println(str);
        };
        consumer.accept("abc");
    }
}
