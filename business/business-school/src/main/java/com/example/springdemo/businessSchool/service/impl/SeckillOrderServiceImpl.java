package com.example.springdemo.businessSchool.service.impl;

import com.example.springdemo.businessSchool.constant.Const;
import com.example.springdemo.businessSchool.constant.redis.SeckillKey;
import com.example.springdemo.businessSchool.data.entity.GoodsBo;
import com.example.springdemo.businessSchool.data.entity.OrderInfo;
import com.example.springdemo.businessSchool.data.entity.SeckillOrder;
import com.example.springdemo.businessSchool.data.entity.User;
import com.example.springdemo.businessSchool.mapper.SeckillOrderMapper;
import com.example.springdemo.businessSchool.service.OrderService;
import com.example.springdemo.businessSchool.service.RedisService;
import com.example.springdemo.businessSchool.service.SeckillGoodsService;
import com.example.springdemo.businessSchool.service.SeckillOrderService;
import com.example.springdemo.businessSchool.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 18:23 2020/6/21
 * @ Modified By：
 * @Version: 1.0.0
 */
@Slf4j
@Service
public class SeckillOrderServiceImpl implements SeckillOrderService {

    @Autowired
    SeckillOrderMapper seckillOrderMapper;

    @Autowired
    SeckillGoodsService seckillGoodsService;

    @Autowired
    RedisService redisService;

    @Autowired
    OrderService orderService;

    @Override
    public SeckillOrder getSeckillOrderByUserIdGoodsId(long userId, long goodsId) {
        return seckillOrderMapper.selectByUserIdAndGoodsId(userId , goodsId);
    }

    @Transactional
    @Override
    public OrderInfo insert(User user, GoodsBo goods) {
        //秒杀商品库存减一
        int success = seckillGoodsService.reduceStock(goods.getId());
        if(success == 1) {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setCreateDate(new Date());
            orderInfo.setAddrId(0L);
            orderInfo.setGoodsCount(1);
            orderInfo.setGoodsId(goods.getId());
            orderInfo.setGoodsName(goods.getGoodsName());
            orderInfo.setGoodsPrice(goods.getSeckillPrice());
            orderInfo.setOrderChannel(1);
            orderInfo.setStatus(0);
            orderInfo.setUserId((long)user.getId());
            //添加信息进订单
            long orderId = 0;
            try {
                orderId = orderService.addOrder(orderInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("orderId -->" +orderId+"");
            SeckillOrder seckillOrder = new SeckillOrder();
            seckillOrder.setGoodsId(goods.getId());
            seckillOrder.setOrderId(orderInfo.getId());
            seckillOrder.setUserId((long)user.getId());
            //插入秒杀表
            seckillOrderMapper.insertSelective(seckillOrder);
            return orderInfo;
        }else {
            setGoodsOver(goods.getId());
            return null;
        }
    }

    @Override
    public OrderInfo getOrderInfo(long orderId) {
        SeckillOrder seckillOrder = seckillOrderMapper.selectByPrimaryKey(orderId);
        if(seckillOrder == null){
            return null;
        }
        return orderService.getOrderInfo(seckillOrder.getOrderId());
    }

    public long getSeckillResult(Long userId, long goodsId) {
        SeckillOrder order = getSeckillOrderByUserIdGoodsId(userId, goodsId);
        if(order != null) {//秒杀成功
            return order.getOrderId();
        }else {
            boolean isOver = getGoodsOver(goodsId);
            if(isOver) {
                return -1;
            }else {
                return 0;
            }
        }
    }
    public boolean checkPath(User user, long goodsId, String path) {
        if(user == null || path == null) {
            return false;
        }
        String pathOld = redisService.get(SeckillKey.getSeckillPath, ""+user.getId() + "_"+ goodsId, String.class);
        return path.equals(pathOld);
    }

    public String createMiaoshaPath(User user, long goodsId) {
        if(user == null || goodsId <=0) {
            return null;
        }
        String str = MD5Util.md5(UUID.randomUUID()+"123456");
        redisService.set(SeckillKey.getSeckillPath, ""+user.getId() + "_"+ goodsId, str , Const.RedisCacheExtime.GOODS_ID);
        return str;
    }

    /*
     * 秒杀商品结束标记
     * */
    private void setGoodsOver(Long goodsId) {
        redisService.set(SeckillKey.isGoodsOver, ""+goodsId, true , Const.RedisCacheExtime.GOODS_ID);
    }
    /*
     * 查看秒杀商品是否已经结束
     * */
    private boolean getGoodsOver(long goodsId) {
        return redisService.exists(SeckillKey.isGoodsOver, ""+goodsId);
    }

}