package com.example.springdemo.businessSchool.service.impl;

import com.example.springdemo.businessSchool.data.entity.GoodsBo;
import com.example.springdemo.businessSchool.mapper.GoodsMapper;
import com.example.springdemo.businessSchool.service.SeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 11:42 2020/6/19
 * @ Modified By：
 * @Version: 1.0.0
 */
@Service
public class SeckillGoodsServiceImpl implements SeckillGoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<GoodsBo> getSeckillGoodsList() {
        return goodsMapper.selectAllGoodes();
    }

    @Override
    public GoodsBo getseckillGoodsBoByGoodsId(long goodsId) {
        return goodsMapper.getseckillGoodsBoByGoodsId(goodsId);
    }

    @Override
    public int reduceStock(long goodsId) {
        return goodsMapper.updateStock(goodsId);
    }
}
