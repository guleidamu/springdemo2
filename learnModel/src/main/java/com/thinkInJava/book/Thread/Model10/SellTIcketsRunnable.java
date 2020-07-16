package com.thinkInJava.book.Thread.Model10;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 18:20 2020/6/29
 * @ Modified By：
 * @Version: 1.0.0
 */
public class SellTIcketsRunnable implements Runnable{

    private int tickets = 100;

    @Override
    public void run() {
        while (tickets > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
        }
    }
}


class SellTIcketsRunnableMain{
    public static void main(String[] args) {
        SellTIcketsRunnable sellTIcketsRunnable1 = new SellTIcketsRunnable();
        SellTIcketsRunnable sellTIcketsRunnable2 = new SellTIcketsRunnable();
        SellTIcketsRunnable sellTIcketsRunnable3 = new SellTIcketsRunnable();
//        new Thread(sellTIcketsRunnable1).start();
//        new Thread(sellTIcketsRunnable2).start();
//        new Thread(sellTIcketsRunnable3).start();
        new Thread(new SellTIcketsRunnable()).start();
        new Thread(new SellTIcketsRunnable()).start();
        new Thread(new SellTIcketsRunnable()).start();
    }
}