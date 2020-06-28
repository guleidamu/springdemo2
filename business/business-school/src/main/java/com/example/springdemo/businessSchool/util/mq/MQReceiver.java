package com.example.springdemo.businessSchool.util.mq;


import com.example.springdemo.businessSchool.data.dto.SeckillMessage;
import com.example.springdemo.businessSchool.data.entity.GoodsBo;
import com.example.springdemo.businessSchool.data.entity.SeckillOrder;
import com.example.springdemo.businessSchool.data.entity.User;
import com.example.springdemo.businessSchool.service.OrderService;
import com.example.springdemo.businessSchool.service.RedisService;
import com.example.springdemo.businessSchool.service.SeckillGoodsService;
import com.example.springdemo.businessSchool.service.SeckillOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQReceiver {

		private static Logger log = LoggerFactory.getLogger(MQReceiver.class);
		
		@Autowired
		RedisService redisService;
		
		@Autowired
		SeckillGoodsService goodsService;
		
		@Autowired
		OrderService orderService;
		
		@Autowired
		SeckillOrderService seckillOrderService;
		
		@RabbitListener(queues=MQConfig.MIAOSHA_QUEUE)
		public void receive(String message) {
			log.info("客户端监听获取rabbitMq里面的数据:"+message);
			SeckillMessage mm  = RedisService.stringToBean(message, SeckillMessage.class);
			User user = mm.getUser();
			long goodsId = mm.getGoodsId();
			
			GoodsBo goods = goodsService.getseckillGoodsBoByGoodsId(goodsId);
	    	int stock = goods.getStockCount();
	    	if(stock <= 0) {
	    		return;
	    	}
	    	//判断是否已经秒杀到了
	    	SeckillOrder order = seckillOrderService.getSeckillOrderByUserIdGoodsId(user.getId(), goodsId);
	    	if(order != null) {
	    		return;
	    	}
	    	//减库存 下订单 写入秒杀订单
			seckillOrderService.insert(user, goods);
		}
}
