package com.thinkInJava.book.Thread.Model2;

/**
 * 两个人AB通过一个账户，A在柜台取钱，B在ATM取钱。
 */
public class MainClass {
    public static void main(String[] args) {
        Bank bank = new Bank();
        //实例化2个人，传入同一个银行的对象
        PersonA a = new PersonA(bank, "Counter");
        PersonB b = new PersonB(bank, "ATM");
        a.start();
        b.start();
    }
}
