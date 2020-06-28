package com.thinkInJava.book.Thread.Model7;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 9:21 2020/6/24
 * @ Modified By：
 * @Version: 1.0.0
 */
public class Train {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread thread1 = new Thread();

            new Thread(()->{
                for (int i = 0; i< 20; i++){
                    try {
                        ticket.inscrease();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            },"A").start();

            new Thread(()->{
                for(int i = 0; i < 10; i++){
                    try {
                        ticket.inscrease();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            },"B").start();

        new Thread(()->{
            for(int i = 0; i < 15; i++){
                try {
                    ticket.inscrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        System.out.println("3个线程都执行结束了吗，实际没有");

    }
}
