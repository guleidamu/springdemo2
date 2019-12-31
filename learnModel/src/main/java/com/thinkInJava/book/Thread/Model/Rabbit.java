package com.thinkInJava.book.Thread.Model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Rabbit extends Animal {
    int speed = 50;
    @Override
    public void running() {
        length = length - speed;
        log.info("兔子跑了" + speed + "米，还剩" + length);
        if(length <= 0){
            length = 0;
            log.info("兔子跑完了.兔子取得胜利");
            if(calltoback != null){
                calltoback.win();
            }
        }
        try {
            if(length % 20 == 0){
                Thread.sleep(1000);
            } else{
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
