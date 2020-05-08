package com.thinkInJava.book.Order.common;

public class Client {
    public static void main(String[] args) throws InterruptedException{
        OrderService orderService = new OrderService();
        for(int i = 1; i<= 50; i++){
            new Thread(()->{
                String str = orderService.getOrdNumber();
                System.out.println(str);
            },String.valueOf(i)).start();
        }
    }
}
