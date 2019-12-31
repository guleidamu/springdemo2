package com.thinkInJava.book.Extend;

import lombok.extern.slf4j.Slf4j;

//重载和重写
//①重载是指不同的函数使用相同的函数名，但是函数的参数个数或类型不同。调用的时候根据函数的参数来区别不同的函数。
//
//        ②覆盖（也叫重写）是指在派生类中重新对基类中的虚函数（注意是虚函数）重新实现。即函数名和参数都一样，只是函数的实现体不一样。
//
//        2.类的关系区别
//
//        覆盖是子类和父类之间的关系，是垂直关系；重载是同一个类中方法之间的关系，是水平关系。
//
//        3.产生方法区别
//
//        覆盖只能由一个方法或只能由一对方法产生关系；重载是多个方法之间的关系

@Slf4j
public class Son extends Father{
    public void fatherMethodPublic(){
      log.info("我是son的方法,对父类方法进行重写" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void leave1(){
        log.info("我是son的方法" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void leave1(String leve1Param){
        log.info("我是son的方法" + Thread.currentThread().getStackTrace()[1].getMethodName() + leve1Param);
    }

//    public StringMethod leave1(StringMethod leve1Param){
//        log.info("我是son的方法" + Thread.currentThread().getStackTrace()[1].getMethodName() + "leve1Param");
//        return leve1Param;
//    }



}
