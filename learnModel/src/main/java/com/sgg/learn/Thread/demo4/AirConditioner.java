package com.sgg.learn.Thread.demo4;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 17:29 2020/6/23
 * @ Modified By：
 * @Version: 1.0.0
 */
public class AirConditioner {
    private int num = 0;
    public synchronized void increase() throws InterruptedException{
        //判断num的值，不要用if，用while
        while (num != 0){
            this.wait();
        }
        num ++;
        System.out.println(""+ Thread.currentThread().getName() + "\t" + num);
        this.notifyAll();
    }

    public synchronized void decrease() throws Exception{
        //判断，处理，通知
        while (num == 0){
            this.wait();
        }
        num--;
        System.out.println(""+Thread.currentThread().getName() + "\t" + num);
        this.notifyAll();
    }
}
