package com.thinkInJava.book.Thread.Synchronized;

import lombok.extern.slf4j.Slf4j;

/**
 * 当两个线程同事对一个对象的一个方法进行操作，只有一个线程能够抢到锁。因为一个对象只有一把锁，一个线程获取了该对象的锁之后
 * 其他线程无法获取该对象的锁，就不能访问该对象的其他synchronized实例方法，但是可以访问非synchronized修饰的方法
 */
@Slf4j
public class SynchronizedTest implements Runnable{
    //共享资源
    static int i = 0;
    /**
     * synchronized 修饰实例方法 多线程调取的时候，有没有synchronized 效果不一样
     */
    public synchronized void increase(){
        i++;
    }
    @Override
    public void run() {
        log.info("进入run（）");
        for(int j = 0; j<10000;j++){
            increase();
        }
    }
    public static void main(String[] args) {
        try {
            SynchronizedTest test = new SynchronizedTest();
            Thread t1 = new Thread(test);
            Thread t2 = new Thread(test);
            Thread thread = new Thread(test);
            thread.start();
            t1.start();
            t2.start();
//
            //thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。
            t1.join();
            t2.join();
            thread.join();
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
