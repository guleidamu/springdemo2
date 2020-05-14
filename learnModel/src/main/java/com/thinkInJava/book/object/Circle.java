package com.thinkInJava.book.object;

public class Circle extends Shape {

    public String test;

    private String rightHeight;

    public void setTest(String test) {
        this.test = test;
    }

    public void setRightHeight(String rightHeight) {
        this.rightHeight = rightHeight;
    }

    public String getTest() {
        return test;
    }

    public String getRightHeight() {
        return rightHeight;
    }

    public String getWhite() {
        return white;
    }

    private void example(){
        this.erase();
        this.height();
        rightHeight = this.white;
    }

    public void erase(){
        System.out.println("这是Circle类的erase()方法");
    }

    private void draw(){
        System.out.println("这个是Circle 的draw()方法");
    }


    private String white = "23";

    public void setWhite(String num){
        this.white = num;
    }

    private String move(){
        System.out.println("这个是Circle里面的move()");
        return null;
    }
}
