package com.thinkInJava.book.Thread.Model;

/**
 * 龟兔赛跑 2000米
 * 设置需要的
 */
public class MainClass {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();
        LetOneStop letOneStop1 = new LetOneStop(tortoise);
        LetOneStop letOneStop2 = new LetOneStop(rabbit);
        //如果是兔子先到达，关闭乌龟的线程
        rabbit.calltoback = letOneStop1;
        //如果是乌龟先到达，关闭兔子的线程
        tortoise.calltoback = letOneStop2;
        rabbit.start();
        tortoise.start();
    }


}
