package com.thinkInJava.book.Thread.Model8;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 14:21 2020/6/24
 * @ Modified By：
 * @Version: 1.0.0
 */
@Slf4j
public class Tickets extends Thread{

    public Tickets(String name){
        super(name);
    }

    static int sumTickets = 0;
    int total = 0;
    static int tickets=31;
    Object object = "aa";

    @Override
    public void run(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginTime = new Date();
        while (tickets > 0){
            synchronized (object){
                if(tickets > 0){
                    tickets--;
                    total++;
                    sumTickets++;
                    log.info(getName()+"卖出去了一张票，还剩" + tickets + "张票");
                } else {
                    log.info(getName() + "票卖完了");
                }
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Date endTime = new Date();
        log.info(getName() + "此次开始卖票的时间" + df.format(beginTime));
        log.info(getName() + "全部卖完票的时间" + df.format(endTime));
        float interval = (float) (endTime.getTime() - beginTime.getTime()) / 1000;
        log.info(getName() + " 卖了" + total + "张票，一总共花费了" + interval + "秒。" +"n个窗口总共卖了sumTick:" + sumTickets);
    }

}
