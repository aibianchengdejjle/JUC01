package com.staticproxy;


public class Proxy  implements  Rent{


    //我们可以对他的原有的方法进行扩充
    @Override
    public void rent() {
        pay();
        host.rent();
    }
    private Host host;
    public Proxy(Host host) {
        this.host = host;
    }

    public  void pay(){
        System.out.println("中介费");
    }

}
