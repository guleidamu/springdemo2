package com.thinkInJava.book.Thread.Model2;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 两个人AB通过一个账户A在柜台取钱和B在ATM机取钱！
 * 程序分析： 钱的数量也设置成一个静态的变量，两个人要取的同一个对象值
 */
@Slf4j
public class Bank {
    double jieqian = 928;
    //假设一个账户有1000块钱
    static double money = 1000;

    //柜台Counter取钱的方法
    private void Counter(double money) {
        Bank.money -= money;
        log.info("柜台取钱" + money + "元，余额" + Bank.money);
    }

    //ATM取钱的方法
    private void ATM(double money) {
        Bank.money -= money;
        log.info("ATM取钱" + money + "元，余额" + Bank.money);
    }

    //提供一个对外取款途径，防止直接调取方法同时取款时，并发余额显示错误
    public synchronized void outMoney(double money, String mode) throws Exception {
        if (money > Bank.money) {
            //校验余额是否充足
            throw new Exception("取款金额" + money + ",余额只剩" + Bank.money + ",取款失败");
        }
        if (Objects.equals(mode, "ATM")) {
            ATM(money);
        } else {
            Counter(money);
        }
    }
}
