package com.sgg.learn.Thread.demo4;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 17:27 2020/6/23
 * @ Modified By：
 * @Version: 1.0.0
 */
public class AirConditionerTest2 {

    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        new Thread(()->{
            for (int i = 0; i<3; i++){
                try {
                    Thread.sleep(200);
                    airConditioner.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();


        new Thread(()->{
            for (int i = 0; i<3; i++){
                try {
                    Thread.sleep(200);
                    airConditioner.increase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}
