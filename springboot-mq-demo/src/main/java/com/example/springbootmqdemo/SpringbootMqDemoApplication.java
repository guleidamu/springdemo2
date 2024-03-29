package com.example.springbootmqdemo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 *1、RabbitAutoConfiguration
 * 2、自动配置了连接工厂ConnectionFactory;
 * 3、RabbitProperties 封装了RabbitMQ的配置
 * 4、RabbitTemplate:给RabbitMQ发送和接收消息
 * 5、AmqpAdmin: RabbitMQ系统管理功能组件
 *      AmqpAdmin：创建和删除Queue，Exchange，Binding
 * 6.@EnableRabbit + @RabbitListener监听消息队列的内容
 */
@EnableRabbit //开启基于注解的RabbitMq模式
@SpringBootApplication
public class SpringbootMqDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMqDemoApplication.class, args);
    }

}
