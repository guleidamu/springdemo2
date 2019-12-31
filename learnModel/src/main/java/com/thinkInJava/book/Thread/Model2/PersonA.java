package com.thinkInJava.book.Thread.Model2;

public class PersonA extends Thread {

    Bank bank;
    String mode;

    public PersonA(Bank bank, String mode){
        this.mode = mode;
        this.bank = bank;
    }

    public void run(){
        while (bank.money>= 100){
            try {
                bank.outMoney(100,mode);
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
