package com.thinkInJava.book.object;

public class test {

    private String son;

    public static void main(String args[]) {
        Circle circle = new Circle();
        circle.setWhite("33");
//        circle.move();
        circle.erase();
        circle.height();
        //son = circle.father;
    }
    private test(){
        Circle circle = new Circle();
        circle.height();
        son = circle.father;
    }


    public String getWhatYouWant(){
        Student student = new Student();
        student.setClassNo(4);
        return null;
    }
}
