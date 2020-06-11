package com.thinkInJava.book.Thread.Model6;

public class MainClass {
    /**
     * 两个人AB通过一个账户A在柜台取钱和B在ATM机取钱
     * */

    public static void main(String[] args) {
        Bank bank = new Bank();

        PersonA p1 = new PersonA(bank);
        PersonB p2 = new PersonB(bank);

        p1.start();
        p2.start();
    }
}
