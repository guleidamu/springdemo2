package com.thinkInJava.book.Thread.Model8;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 15:06 2020/6/24
 * @ Modified By：
 * @Version: 1.0.0
 */
public class saleTainTickets {

    public static void main(String[] args) {
        TicketsByRunable ticketsByRunable1 = new TicketsByRunable();

        Thread t1 = new Thread(ticketsByRunable1);
        Thread t2 = new Thread(ticketsByRunable1);
        Thread t3 = new Thread(ticketsByRunable1);

        t1.start();
        t2.start();
        t3.start();
//        ticketsByRunable1.run();
//        ticketsByRunable2.run();
//        ticketsByRunable3.run();
//        new Thread(ticketsByRunable1).start();
//        new Thread(ticketsByRunable2).start();
//        new Thread(ticketsByRunable3).start();
    }
}
