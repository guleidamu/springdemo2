package com.example.springdemo.businessSchool.mapper;

import com.example.springdemo.businessSchool.data.entity.SeckillOrder;
import org.apache.ibatis.annotations.Param;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 15:00 2020/6/22
 * @ Modified By：
 * @Version: 1.0.0
 */
public interface SeckillOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SeckillOrder record);

    int insertSelective(SeckillOrder record);

    SeckillOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillOrder record);

    int updateByPrimaryKey(SeckillOrder record);

    SeckillOrder selectByUserIdAndGoodsId(@Param("userId") long userId , @Param("goodsId") long goodsId );

}
