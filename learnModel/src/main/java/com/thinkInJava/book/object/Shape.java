package com.thinkInJava.book.object;

public class Shape {

    public String father = "important";
    private String color = "white";

    //private 修饰的方法，其他类引用不了，即使是子类
    private void draw(){
        System.out.println("这是Shape类的draw()方法");
    }

    //protectd 修饰的，同一个包或者子类都可以引用到
    protected void height(){
        System.out.println("这是Shape类的height()方法");
    }

    private String getColor(){
        return this.color;
    }

    //public 任何都可以引用
    public void erase(){
        System.out.println("这是Shape类的erase()方法");
    }
}
