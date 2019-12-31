package com.thinkInJava.book.Thread.Model;

public abstract class Animal extends Thread{

    //如果是静态的static，那就相当于兔子和乌龟加起来走length的长度。
    //如果非静态的，就相当于兔子和乌龟各自走length的长度
    public int length = 200;
    //抽象方法不能用private修饰。因为抽象方法没有方法体，是要被继承用的，所以不能用private修饰。
    public abstract void running();
    @Override
    public void run(){
        super.run();
        while(length > 0){
            running();
        }
    }

    //在需要回调数据的地方，声明一个接口
    public static interface Calltoback{
        public void win();
    }

    //创建接口对象
    public Calltoback calltoback;
}
