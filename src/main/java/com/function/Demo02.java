package com.function;

import java.util.function.Predicate;

/*
    有一个输入参数只能返回一个bool值

*/
public class Demo02 {
    public static void main(String[] args) {
        Predicate<String> predicate = (str)->{return str.isEmpty();};
        System.out.println(predicate.test("11"));
        System.out.println(predicate.test(""));
    }
}
