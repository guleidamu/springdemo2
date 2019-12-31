package com.thinkInJava.book.Thread.Model2;

public class PersonB extends Thread {
    Bank bank;

    String mode;

    public PersonB(Bank bank, String mode){
        this.bank = bank;
        this.mode = mode;
    }

    public void run(){
        while (bank.money >= 200){
            try {
                bank.outMoney(200, mode);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
