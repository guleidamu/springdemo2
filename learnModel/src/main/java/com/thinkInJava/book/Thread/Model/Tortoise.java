package com.thinkInJava.book.Thread.Model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tortoise extends Animal {
    int speed = 20;

    @Override
    public void running() {
        length -= speed;
        log.info("乌龟跑了 " + speed + "米， 还剩下" + length);
        if (length <= 0) {
            length = 0;
            log.info("乌龟跑完了，乌龟取得胜利");
            if (calltoback != null) {
                calltoback.win();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
