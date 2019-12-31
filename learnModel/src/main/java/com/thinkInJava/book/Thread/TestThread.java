package com.thinkInJava.book.Thread;

public class TestThread {
    public static void main(String[] args) {
        RunnableDemo r1 = new RunnableDemo("Thread-1");
        r1.start();

        RunnableDemoTest r2 = new RunnableDemoTest("Thread-2-RunnableDemoTest:");
        r2.start();
    }
}
