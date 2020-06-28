package com.example.springdemo.businessSchool.service;

import com.example.springdemo.businessSchool.data.entity.GoodsBo;

import java.util.List;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 11:25 2020/6/19
 * @ Modified By：
 * @Version: 1.0.0
 */
public interface SeckillGoodsService {

    List<GoodsBo> getSeckillGoodsList();

    GoodsBo getseckillGoodsBoByGoodsId(long goodsId);

    int reduceStock(long goodsId);
}
