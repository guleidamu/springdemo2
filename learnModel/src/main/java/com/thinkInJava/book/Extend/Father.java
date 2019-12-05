package com.thinkInJava.book.Extend;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Father {
    public static void main(String[] args) {
//        log.info("Class" + this.getClass().getName());1、在类的实例中可使用this.getClass().getName();但在static method中不能使用该方法；
//
//
//
//2、在static method中使用方法:Thread.currentThread().getStackTrace()[1].getClassName();
        log.info("我是父类"+Thread.currentThread().getStackTrace()[1].getClassName());
    }
    private void fatherMethod(){
        log.info("我是父类的方法"+Thread.currentThread().getStackTrace()[1].getMethodName());
    }
    public void fatherMethodPublic(){
        log.info("我是父类的方法"+Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
