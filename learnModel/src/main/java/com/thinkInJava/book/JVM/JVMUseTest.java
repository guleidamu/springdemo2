package com.thinkInJava.book.JVM;

public class JVMUseTest {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long usableMemory = maxMemory - totalMemory + freeMemory;

        System.out.println("可以获得的最大内存是" + maxMemory);
        System.out.println("已经分配到的内存大小是" + totalMemory);
        System.out.println("所分配内存的剩余大小是：" + freeMemory);
        System.out.println("最大可用内存大小是：" + usableMemory);
    }
}
