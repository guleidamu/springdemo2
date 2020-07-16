package com.thinkInJava.book.Thread.Model10;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 17:26 2020/6/29
 * @ Modified By：
 * @Version: 1.0.0
 */

import lombok.extern.slf4j.Slf4j;

/**
 * 经典的买票问题
 * 某电影院正在上映贺岁大片（妹妹你大胆的往前走）
 * 共有100张票，有3个窗口售卖，请设计一个程序模拟该电影院售票
 */
@Slf4j
public class SellTicket extends Thread {

    public SellTicket() {
    }

    public SellTicket(String name) {
        super(name);
    }

    static int tickets = 100;
    Object object = "aa";

    @Override
    public void run() {
        while (tickets > 0){
//            synchronized(object){
                if(tickets > 0){
//                    tickets --;
                    log.info(Thread.currentThread().getName() + "卖出去了一张，还有"  + (--tickets) + "张");
                } else {
                    log.info("票已卖完");
                }
//            }
//            try {
//                sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}

class SellTicketsMain {
    public static void main(String[] args) {
        SellTicket sellTicket1 = new SellTicket("易建联");
        SellTicket sellTicket2 = new SellTicket("加内特");
        SellTicket sellTicket3 = new SellTicket("姚明明");
        sellTicket1.start();
        sellTicket2.start();
        sellTicket3.start();
    }
}
