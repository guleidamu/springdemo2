package com.example.springdemo.businessSchool.controller;

import com.example.springdemo.businessSchool.constant.Const;
import com.example.springdemo.businessSchool.constant.redis.UserKey;
import com.example.springdemo.businessSchool.data.dto.SeckillDto;
import com.example.springdemo.businessSchool.data.dto.SeckillMessage;
import com.example.springdemo.businessSchool.data.entity.GoodsBo;
import com.example.springdemo.businessSchool.data.entity.SeckillOrder;
import com.example.springdemo.businessSchool.data.entity.User;
import com.example.springdemo.businessSchool.response.Result;
import com.example.springdemo.businessSchool.response.ResultBuilder;
import com.example.springdemo.businessSchool.response.ResultCode;
import com.example.springdemo.businessSchool.service.RedisService;
import com.example.springdemo.businessSchool.service.SeckillGoodsService;
import com.example.springdemo.businessSchool.service.SeckillOrderService;
import com.example.springdemo.businessSchool.util.CookieUtil;
import com.example.springdemo.businessSchool.constant.redis.GoodsKey;
import com.example.springdemo.businessSchool.util.mq.MQSender;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;


//因为implements InitializingBean,启动的时候就初始化下面的方法
@RestController
//学习一下RestController 和Controller的区别
//@Controller
@RequestMapping("secondKill")
public class SeckillController implements InitializingBean {

    @Autowired
    RedisService redisService;

    @Autowired
    SeckillGoodsService seckillGoodsService;

    @Autowired
    SeckillOrderService seckillOrderService;

    @Autowired
    MQSender mqSender;

    private HashMap<Long, Boolean> localOverMap = new HashMap<Long, Boolean>();

    /**
     * 系统初始化
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        List<GoodsBo> goodsList = seckillGoodsService.getSeckillGoodsList();
        if (goodsList == null) {
            return;
        }
        for (GoodsBo goods : goodsList) {
            redisService.set(GoodsKey.getSeckillGoodsStock, "" + goods.getId(), goods.getStockCount(), Const.RedisCacheExtime.GOODS_LIST);
            localOverMap.put(goods.getId(), false);
        }
    }

    @PostMapping("/secondKillGoods")
    @ApiOperation(value = "用户权限设置")
    public Result secondKillGoods(@RequestBody SeckillDto seckillDto, HttpServletRequest request){
        String loginToken = CookieUtil.readLoginToken(request);
        Long goodsId = seckillDto.getGoodsId();
        User user = redisService.get(UserKey.getByName, loginToken, User.class);
        if(null == user){
            return ResultBuilder.error(ResultCode.USER_NO_LOGIN);
        }
        long stock = redisService.decr(GoodsKey.getSeckillGoodsStock, "" + goodsId);//10
//

        if(stock < 0){
            localOverMap.put(goodsId,true);
//            return ResultBuilder.error("23","sf");
        }
        //判断是否已经秒杀到了
        SeckillOrder order = seckillOrderService.getSeckillOrderByUserIdGoodsId(user.getId(), goodsId);
        if(null != order){
            return ResultBuilder.error(ResultCode.REPEAT_SECONDKILL);
        }
        //入队
        SeckillMessage mm = new SeckillMessage();
        mm.setUser(user);
        mm.setGoodsId(goodsId);
        mqSender.sendSeckillMessage(mm);
        return ResultBuilder.success(stock);
    }
}
