package com.function;

import java.util.function.Function;
/**
 * Function函数型接口
 */
public class Demo01 {
    public static void main(String[] args) {
    /*    Function function=new Function<String,String>(){
            @Override
            public String apply(String string) {
                return string;
            }
        };*/
         Function<String,String> function = (str) ->{return str;};
        System.out.println(((Function<String, String>) function).apply("ljjsb"));
    }
}
