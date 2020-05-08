package com.sgg.learn.Thread.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {//资源类
    private int number = 30;
    private Lock lock = new ReentrantLock();
    public void saleTicket(){
        lock.lock();

        if(number > 0){
            System.out.println(Thread.currentThread().getName() + "\t卖出第" + (number--)+ "\t还剩下" + number+ "张票");//快捷键
        }
    }
}

/**
 * 题目：三个售票员 卖出 30张票
 * 1在高内聚低耦合的前提下，线程   操作(对外暴露的调用方法)   资源类
 */

public class saleTicket {

    public static void main(String[] args) throws Exception{
        Ticket ticket = new Ticket();

        //lambda表达式
        new Thread(()->{for (int i = 1; i <= 40; i++)ticket.saleTicket();},"A").start();
        new Thread(()->{for (int i = 1; i <= 40; i++)ticket.saleTicket();},"B").start();
        new Thread(()->{for (int i = 1; i <= 40; i++)ticket.saleTicket();},"C").start();

//        Thread t1 = new Thread();
//        t1.start();
        //Thread(Runnable target, String name) Allocates a new Thread object.
        //匿名内部类，new接口的情况
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++){
                    ticket.saleTicket();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++){
                    ticket.saleTicket();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++){
                    ticket.saleTicket();
                }
            }
        },"C").start();*/
//        Thread t1 = new Thread();
//        Thread t2 = new Thread();
//        t1.start();
//        t2.start();
    }
}
