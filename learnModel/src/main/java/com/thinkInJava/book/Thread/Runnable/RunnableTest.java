package com.thinkInJava.book.Thread.Runnable;

public class RunnableTest implements Runnable {
    static int i = 0;
    public void increate(){
        i++;
    }
    @Override
    public void run() {
        System.out.println("thread");
        for(int j = 0; j<10; j++){
            System.out.println("run方法里面的j" + j);
            increate();
        }
    }

    public static void main(String[] args) throws Exception{
        RunnableTest test = new RunnableTest();
        //线程启动由Thread负责
        Thread thread = new Thread(test);
        thread.start();
//        thread.join();
        System.out.println( "i:" + i);
    }
}
