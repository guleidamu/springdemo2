package com.sgg.learn.kafka;


import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;



public class producter {


    public static void main(String[] args) {
        producter sendDataToKafka = new producter();
        sendDataToKafka.send("mysql0531", "", "this is a test data too");
    }

    public void send(String topic,String key,String data){
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.43.9:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        KafkaProducer<String, String> producer = new KafkaProducer<String,String>(props);
        for(int i=1;i<2;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            producer.send(new ProducerRecord<String, String>(topic, ""+i, data));
        }
        producer.close();
    }

}
