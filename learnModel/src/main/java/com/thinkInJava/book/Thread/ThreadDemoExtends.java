package com.thinkInJava.book.Thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadDemoExtends extends Thread {

    private Thread thread;
    private String threadName;

    ThreadDemoExtends(String name){
        threadName = name;
        log.info("Creating" + threadName);
    }

    public void run(){
        log.info("Running " + threadName);
        try {
            for (int i = 5; i> 0; i--){
                log.info("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        log.info("Starting " + threadName);
    }

}
