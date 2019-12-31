package com.thinkInJava.book.Thread.Model3;
import com.thinkInJava.book.Thread.Model3.Animal.Calltoback;

public class LetOneStop implements Calltoback {
    //动物对象
    Animal animal;
    //获取动物对象，可以传入兔子或者乌龟的实例
    public LetOneStop(Animal animal){
        this.animal = animal;
    }
    //让动物的线程停止
    @Override
    public void win() {
        //线程停止
        animal.stop();
    }
}
