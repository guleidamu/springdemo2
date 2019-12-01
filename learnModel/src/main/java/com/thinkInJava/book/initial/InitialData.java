package com.thinkInJava.book.initial;

public class InitialData {

    public static void main(String[] args) {
        InitialData initialData = new InitialData();

        int i = initialData.f();
        int j = initialData.g(i);
        System.out.println("f()的值" + i);
        System.out.println("g()的值" + j);
    }

    int f(){
        return 11;
    }

    int g(int n){
        return n*10;
    }
}
