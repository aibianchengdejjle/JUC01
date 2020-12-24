package com.staticproxy;

public class User {
    public static void main(String[] args) {
        Host host=new Host();
        Proxy proxy=new Proxy(host);
        proxy.rent();
    }
}
