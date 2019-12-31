package com.businessOracle.businessOracle.util;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 抽象类使用abstract修饰；
 * 抽象类可以含有抽象方法，也可以不含抽象方法，抽象类中可以有具体的方法
 * 抽象类无法被实例化，即不能通过new来实例化对象；
 * 含有抽象方法（使用abstract关键字修饰的方法）的类是抽象类，必须使用abstract关键字修饰；
 * 抽象方法只有声明，没有实现
 * @param <T>
 */
//
public abstract class MyThread<T> implements Runnable {

    private List<T> list;
    private CountDownLatch begin;
    private CountDownLatch end;

    //创建构造方法初始化list，和其他用到的参数
    public MyThread(List<T> list, CountDownLatch begin, CountDownLatch end){
        this.list = list;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run(){
        try {
            //执行程序
            method(list);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //计数器减一
            end.countDown();
        }
    }

    //抽象方法不能有方法体
    public abstract void method(List<T> list);

}
