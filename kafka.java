/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amazone;
import org.apache.kafka.clients.*;
import java.util.Properties;
import java.util.Random;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 *
 * @author parth
 */
public class kafka {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.16.8.194:9092,172.16.8.195:9092,172.16.8.196:9092");
        prop.put(ProducerConfig.ACKS_CONFIG, "all");
        prop.put(ProducerConfig.RETRIES_CONFIG,0);
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        Producer<String,String> producer = new KafkaProducer<String,String>(prop);
        TestCallback callback = new TestCallback();
        Random rnd = new Random();
        for(long i=0;i< 100;i++)
        {
            ProducerRecord<String,String> data = new ProducerRecord<String,String>("tenant1-Raw","key-" + i,"message-"+i);
                       producer.send(data, callback);

            
        }
          producer.close();
    }   
    private static class TestCallback implements Callback{
          public void onCompletion(RecordMetadata recordMetadata, Exception e) {
           if (e != null) {
               System.out.println("Error while producing message to topic :" + recordMetadata);
               e.printStackTrace();
           } else {
               String message = String.format("sent message to topic:%s partition:%s  offset:%s", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset());
               System.out.println(message);
    }
          }
    }
}

