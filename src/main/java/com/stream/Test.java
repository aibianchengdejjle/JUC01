package com.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        User user1 = new User(1,"a",21);
        User user2 = new User(2,"b",22);
        User user3 = new User(3,"c",23);
        User user4 = new User(4,"d",24);
        User user5 = new User(5,"e",25);
        User user6 = new User(6,"f",26);


        List<User>list=Arrays.asList(user1, user2, user3, user4, user5, user6);

        //流式计算，链式编程
        list.stream()
                .filter((u)->{return u.getAge()%2==0;})// 用于计算年龄是否为偶数
                .filter((u)->{return u.getAge()>23;})  //计算年龄是否大于23
                .map((u)->{return u.getName().toUpperCase();})  //把名字大写
                .sorted((uu1,uu2)->{        //比较倒序排列
                    return uu2.compareTo(uu1);
                })
                .limit(1)   // 只能输出一个
                .forEach(System.out::println);
    }
}
