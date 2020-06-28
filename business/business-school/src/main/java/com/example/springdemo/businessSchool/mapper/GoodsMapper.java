package com.example.springdemo.businessSchool.mapper;

import com.example.springdemo.businessSchool.data.entity.Goods;
import com.example.springdemo.businessSchool.data.entity.GoodsBo;

import java.util.List;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 14:20 2020/6/19
 * @ Modified By：
 * @Version: 1.0.0
 */
public interface GoodsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    List<GoodsBo> selectAllGoodes ();

    GoodsBo getseckillGoodsBoByGoodsId(long goodsId);

    int updateStock(long goodsId);
}
