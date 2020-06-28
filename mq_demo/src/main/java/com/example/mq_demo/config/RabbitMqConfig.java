package com.example.mq_demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Bean
    public Queue Queue1() {
        return new Queue("lyhTest1");
    }

    @Bean
    public Queue Queue2() {
        return new Queue("lyhTest2");
    }
}
