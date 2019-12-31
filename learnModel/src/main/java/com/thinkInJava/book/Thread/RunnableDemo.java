package com.thinkInJava.book.Thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnableDemo implements Runnable{

    private Thread t;
    private String threadName;

    RunnableDemo(String name){
        threadName = name;
        log.info("Creating " + threadName);
    }

    @Override
    public void run() {
    log.info("Running " + threadName);
        try {
            for(int i = 0; i <10; i++ ){
                log.info("Thread: " + threadName + "," + i);
                //让线程休息一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            log.info("Thread " + threadName + " interrupted");
            e.printStackTrace();
        }
        log.info("Thread " + threadName + " exiting.");
    }

    public void start(){
        log.info("Starging " + threadName);
        if(null == t){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
