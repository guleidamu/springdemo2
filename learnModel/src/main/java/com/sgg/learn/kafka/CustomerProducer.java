package com.sgg.learn.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class CustomerProducer {
    public static void main(String[] args) {
        //配置信息
        Properties props = new Properties();
        //kafka
        props.put("bootstrap.servers", "192.168.43.9:9092");
        //应答级别
        props.put("acks", "all");
        //重试次数
        props.put("retries", 0);
        //批量大小
        props.put("batch.size", 16384);
        //提交延时
        props.put("linger.ms", 1);
        //缓存
        props.put("buffer.memory", 33554432);
        //提供序列化，kV的序列化类
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


//        ProducerConfig
//        Producer<String, String> producer = new KafkaProducer<>(props);
//        for (int i = 0; i<10; i++){
//            producer.send(new ProducerRecord<>("my-topic", Integer.toString(i), Integer.toString(i)));
//        }
//        producer.close();

        //创建生产者duixiang
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        //循环发送对象
        for (int i = 0; i<10; i++){
            producer.send(new ProducerRecord<>("C",
                    "Hello", "Kafka"));
        }

        producer.close();
    }
}
