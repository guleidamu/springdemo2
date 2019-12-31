package com.thinkInJava.book.Thread.Model1;

import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 三个售票窗口同时出售20张票
 * 程序分析：
 * 1、票数要使用同一个静态值
 * 2、为保证不会出现卖出同一票数，要Java多线程同步锁。
 */
@Slf4j
public class Station extends Thread {

    //通过构造方法给线程名字赋值
    public Station(String name) {
        super(name);//给线程名字赋值
    }
    //有没有静态修饰，这边明显的体现了出来。因为静态修饰的变量会单独给一块空间。
    // 实际上当多线程调用static的时候，是调用到同一个内存空间
    //如果是非静态修饰的变量，调取的时候是该对象下的变量空间，是独立的。
    //静态的票数
    static int sumTick = 0;
    //卖的票数
    int total = 0;
    //为了保持票数的一致，票数要静态
    static int tick = 100;

    //创建一个静态钥匙
//    static Object ob = "aa";//值是任意的
    Object ob = "aa";//值是任意的

    //重写run方法，实现买票操作
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginTime = new Date();
        while (tick > 0) {
            synchronized (ob) { //这个很重要，必须使用一个锁.如果没有添加这个会出现同一张票被多次售卖的情况，导致多线程调取的总数大于总数ticket
                //进去的人会把钥匙拿在手上，出来后才把钥匙让出来
                if (tick > 0) {
                    log.info(getName() + "卖出了第" + tick + "张票");
                    tick--;
                    total++;
                    sumTick++;
                } else {
                    log.info(tick + "票卖完了");
                }
            }
            try {
                sleep(100);//休息1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Date endTime = new Date();
        log.info(getName() + "开始卖票时间" + df.format(beginTime));
        log.info(getName() + "卖完票时间" + df.format(endTime));
        float interval = (float) (endTime.getTime() - beginTime.getTime()) / 1000;
        log.info(getName() + " 卖了" + total + "张票，一总共花费了" + interval + "秒。" +"n个窗口总共卖了sumTick:" + sumTick);
    }

}
