package com.thinkInJava.book.Thread.Model8;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 14:38 2020/6/24
 * @ Modified By：
 * @Version: 1.0.0
 */
public class SaleTickets {
    public static void main(String[] args) {
        Tickets tickets1 = new Tickets("这个是1号窗口");
        Tickets tickets2 = new Tickets("这个是2号窗口");
        Tickets tickets3 = new Tickets("这个是3号窗口");
        tickets1.start();
        tickets2.start();
        tickets3.start();
    }
}
