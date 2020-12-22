package com.function;

import java.util.function.Supplier;
/*
    只有参数没有返回就是供给型接口

 */
public class Demo04 {
    public static void main(String[] args) {
            Supplier<String> supplier = ()->{return "1024";};
            System.out.println(supplier.get());
    }
}
