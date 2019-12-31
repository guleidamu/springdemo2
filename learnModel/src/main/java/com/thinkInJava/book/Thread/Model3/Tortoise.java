package com.thinkInJava.book.Thread.Model3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tortoise extends Animal{
    @Override
    public void runing() {
        int dis = 2;
        length -= dis;
        log.info("乌龟跑了" + dis + "米，还剩" + length);
        if(length <= 0 ){
            length = 0;
            log.info("乌龟获得了胜利");
            // 让兔子不要再跑了
            if(calltoback != null){
                calltoback.win();
            }
        }
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
