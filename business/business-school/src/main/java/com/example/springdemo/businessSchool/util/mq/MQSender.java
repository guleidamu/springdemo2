package com.example.springdemo.businessSchool.util.mq;

import com.example.springdemo.businessSchool.data.dto.SeckillMessage;
import com.example.springdemo.businessSchool.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MQSender {

	private static Logger log = LoggerFactory.getLogger(MQSender.class);
	
	@Autowired
    AmqpTemplate amqpTemplate ;
	
	public void sendSeckillMessage(SeckillMessage mm) {
		String msg = RedisService.beanToString(mm);
		log.info("开始给消息队列推送数据send message:"+msg);
		amqpTemplate.convertAndSend(MQConfig.MIAOSHA_QUEUE, msg);
		amqpTemplate.convertAndSend(MQConfig.MIAOSHA_QUEUE_TEST1, msg);
	}

}
