package com.thinkInJava.book.Thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnableDemoTest implements Runnable {

    private String threadName;
    private Thread thread;

    public RunnableDemoTest(String threadName){
        log.info("create thread: " + threadName);
        this.threadName = threadName;
    }

    @Override
    public void run() {
        log.info("running Thread: " + threadName);
        try {
            for(int i = 0; i< 10; i++){
                log.info("Thread " + threadName + "," + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            log.info("Thread " + threadName +"interrupted");
            e.printStackTrace();
        }
        log.info("Thread " + threadName + " exiting.");
    }

    public void start(){
        log.info("Starting " + threadName);
        if(null == thread){
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

}
