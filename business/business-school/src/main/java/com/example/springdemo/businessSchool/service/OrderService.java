package com.example.springdemo.businessSchool.service;


import com.example.springdemo.businessSchool.data.entity.OrderInfo;

/**
 * Created by: HuangFuBin
 * Date: 2018/7/17
 * Time: 10:49
 * Such description:
 */
public interface OrderService {

    long addOrder(OrderInfo orderInfo);

    OrderInfo getOrderInfo(long rderId);
}
