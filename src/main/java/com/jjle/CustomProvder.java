package com.jjle;

/*
*  生产者消费这问题
*/
public class CustomProvder {
    public static void main(String[] args) {
        Data data=new Data();

        //生产者线程
        new Thread(()->{
            for (int i = 0; i <20 ; i++) {
                try {
                    data.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        //消费者线程
        new Thread(()->{
            try {
                for (int i = 0; i <20 ; i++) {
                    data.decr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i <20 ; i++) {
                try {
                    data.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i <20 ; i++) {
                try {
                    data.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();

    }
}
class  Data{
    private  int number=0;
    //+1
    public synchronized  void incr() throws InterruptedException {
        //没有东西了我们需要生产
        if(number==0){
           number++;
            System.out.println(Thread.currentThread().getName()+"=>"+number);
            //我加一完毕
            this.notifyAll(); //唤醒
        } else {
            this.wait();
        }

    }
    //-1
    public  synchronized void decr() throws InterruptedException {
        //有东西可以被消费
        if (number!=0){
           number--;
            System.out.println(Thread.currentThread().getName()+"=>"+number);
            //通知其他线程我-1完毕
            this.notifyAll(); //唤醒
        } else {
            this.wait();
        }
    }
}
