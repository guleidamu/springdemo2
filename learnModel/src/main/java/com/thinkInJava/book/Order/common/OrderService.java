package com.thinkInJava.book.Order.common;

import com.thinkInJava.book.Order.util.OrderNumCreateUtil;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderService {

   private OrderNumCreateUtil orderNumCreateUtil = new OrderNumCreateUtil();
    public String getOrdNumber() {
        return orderNumCreateUtil.getOrdNumber();
    }
//    private Lock lock = new ReentrantLock();
//
//    public String getOrdNumber(){
//        lock.lock();
//        try {
//            return orderNumCreateUtil.getOrdNumber();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            lock.unlock();
//        }
//        return null;
//    }
}
