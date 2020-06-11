package com.thinkInJava.book.Thread.Model6;

public class PersonA extends Thread {

    Bank bank;

    public PersonA(){};

    public PersonA(Bank bank){
        this.bank = bank;
    }

    @Override
    public void run() {
        while (Bank.money >= 100) {
            bank.Counter(100);

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
