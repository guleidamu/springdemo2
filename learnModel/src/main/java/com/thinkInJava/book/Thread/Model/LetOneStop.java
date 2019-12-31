package com.thinkInJava.book.Thread.Model;

public class LetOneStop implements Animal.Calltoback {
    //动物对象
    Animal an;
    public LetOneStop(Animal animal){
        this.an = animal;
    }
    //让动物的线程静止
    @Override
    public void win() {
        //线程停止
        an.stop();
    }
}
