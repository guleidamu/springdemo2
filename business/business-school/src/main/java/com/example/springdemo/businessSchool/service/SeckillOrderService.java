package com.example.springdemo.businessSchool.service;

import com.example.springdemo.businessSchool.data.entity.GoodsBo;
import com.example.springdemo.businessSchool.data.entity.OrderInfo;
import com.example.springdemo.businessSchool.data.entity.SeckillOrder;
import com.example.springdemo.businessSchool.data.entity.User;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 18:17 2020/6/21
 * @ Modified By：
 * @Version: 1.0.0
 */
public interface SeckillOrderService {

    SeckillOrder getSeckillOrderByUserIdGoodsId(long userId , long goodsId);


    OrderInfo insert(User user , GoodsBo goodsBo);

    OrderInfo getOrderInfo(long orderId);

    long getSeckillResult(Long userId, long goodsId);

    boolean checkPath(User user, long goodsId, String path);

    String createMiaoshaPath(User user, long goodsId);

}
