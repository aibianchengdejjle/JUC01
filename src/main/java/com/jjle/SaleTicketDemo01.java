package com.jjle;

public class SaleTicketDemo01 {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
               ticket.sale();
            }
        },"A").start();

        new Thread(()->{
            for(int i=0;i<40;i++){
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for(int i=0;i<40;i++){
                ticket.sale();
            }
        },"C").start();
    }


}
class    ticket{
    private static   int number=50;
    public  synchronized static void sale(){
        if(number>0){
            System.out.println(Thread.currentThread().getName()+"卖出了第几"+number--+"票");
        }
    }
}
