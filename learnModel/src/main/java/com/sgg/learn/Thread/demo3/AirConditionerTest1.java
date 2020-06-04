package com.sgg.learn.Thread.demo3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirConditioner2{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increase() throws InterruptedException{
        lock.lock();

        try {
            //判断
            while(number != 0){
                //为什么不用sleep，而用wait
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" +number);
            //通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrease() throws InterruptedException{
        lock.lock();
        try {
            while (number == 0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" +number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class AirConditionerTest1 {




    public static void main(String[] args) {
        System.out.println("AirConditioner2");
        AirConditioner2 airConditioner = new AirConditioner2();
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
