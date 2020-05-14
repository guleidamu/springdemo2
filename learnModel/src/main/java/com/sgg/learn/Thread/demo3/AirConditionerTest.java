package com.sgg.learn.Thread.demo3;


class AirConditioner{
    private int number = 0;
    public synchronized void increase() throws InterruptedException{
        //判断
        while(number != 0){
            //为什么不用sleep，而用wait
            this.wait();
        }
        //干活
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" +number);
        //通知
        this.notifyAll();
    }

    public synchronized void decrease() throws InterruptedException{
        while (number == 0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" +number);
        this.notifyAll();
    }
}
//多线程心法口诀
//线程  操作  资源类
//判断/干活/通知
//多线程交换中，必须要防止多线程的虚假唤醒，也即（多线程中判断不许用if，只能用while）；

public class AirConditionerTest {



    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        new Thread(() ->{
            for(int i = 0; i< 10; i++){
                try {
                    Thread.sleep(200);
                    airConditioner.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(() ->{
            for(int i = 0; i< 10; i++){
                try {
                    Thread.sleep(200);
                    airConditioner.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(() ->{
            for(int i = 0; i< 10; i++){
                try {
                    Thread.sleep(400);
                    airConditioner.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(() ->{
            for(int i = 0; i< 10; i++){
                try {
                    Thread.sleep(500);
                    airConditioner.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();

    }
}
