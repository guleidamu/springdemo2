package com.thinkInJava.book.Thread.Model3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Rabbit extends Animal {
    public Rabbit(){
        setName("兔子");
    }
    @Override
    public void runing() {
        //兔子速度
        int dis = 5;
        length -= dis;
        log.info("兔子跑了" + dis + "米， 距离终点还有" + length);
        if(length <= 0){
            length = 0;
            log.info("兔子获得了胜利");
            //给回调对象赋值，让乌龟不要再跑了
            if (calltoback != null){
                calltoback.win();
            }
        }
        try {
            if ((2000 - length) % 20 == 0){
                sleep(1000);    //  每20米休息一次，休息1秒
            }else {
                sleep(100);    //   每0.1秒跑5米
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
