package com.sgg.learn.Thread.demo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Ticket1 {//资源类
    private int number = 30;
    private Lock lock = new ReentrantLock();
    public synchronized void saleTicket()
    {

        try {
            if(number > 0){
                System.out.println(Thread.currentThread().getName() + "\t卖出第" + (number--)+ "\t还剩下" + number+ "张票");//快捷键
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

/**
 * 题目：三个售票员 卖出 30张票
 * 1在高内聚低耦合的前提下，线程   操作(对外暴露的调用方法)   资源类
 */
//可以取消下列的注解，再开始
public class saleTicket2 {

//    public static void main(String[] args) throws Exception{
//        Ticket1 ticket1 = new Ticket1();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <= 40; i++){
//                    ticket1.saleTicket();
//                }
//            }
//        },"A").start();
//        //B
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <= 40; i++){
//                    ticket1.saleTicket();
//                }
//            }
//        },"B").start();
//        //C
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <= 40; i++){
//                    ticket1.saleTicket();
//                }
//            }
//        },"C").start();
//    }
}
