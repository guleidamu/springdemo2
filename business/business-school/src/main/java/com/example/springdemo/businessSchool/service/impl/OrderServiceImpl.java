package com.example.springdemo.businessSchool.service.impl;


import com.example.springdemo.businessSchool.data.entity.OrderInfo;
import com.example.springdemo.businessSchool.mapper.OrdeInfoMapper;
import com.example.springdemo.businessSchool.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by: HuangFuBin
 * Date: 2018/7/17
 * Time: 10:50
 * Such description:
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdeInfoMapper ordeInfoMapper;

    @Override
    public long addOrder(OrderInfo orderInfo) {
        return ordeInfoMapper.insertSelective(orderInfo);
    }

    @Override
    public OrderInfo getOrderInfo(long orderId) {
        return ordeInfoMapper.selectByPrimaryKey(orderId);
    }
}
