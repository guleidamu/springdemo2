package com.thinkInJava.book.Thread.Model7;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 9:17 2020/6/24
 * @ Modified By：
 * @Version: 1.0.0
 */
@Slf4j
public class Ticket {

    public static int tickets = 20;

    public synchronized void inscrease() throws Exception{
        while (tickets > 0){
            tickets--;
            log.info(Thread.currentThread().getName()+"站点购买了一张票，还剩" + tickets + "张");
            //这边用sleep和wait效果是不一样的，下面这行代码在内部和外部也是不一样
            wait(100);
        }
//        wait(500);
//        sleep(800);
    }

}
