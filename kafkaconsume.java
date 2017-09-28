/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amazone;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRebalanceCallback;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

import java.util.Collection;
import org.apache.kafka.common.TopicPartition;

/**
 *
 * @author parth
 */
public class kafkaconsume {
    public static void main(String[] args) {
        
          Properties consumerConfig = new Properties();
       consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.16.8.194:9092,172.16.8.195:9092,172.16.8.196:9092");
       consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group");
       consumerConfig.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
       consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
       consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
       KafkaConsumer<byte[], byte[]> consumer = new KafkaConsumer<>(consumerConfig);
   //    TestConsumerRebalanceListener rebalanceListener = new TestConsumerRebalanceListener();
  //     consumer.subscribe(Collections.singletonList("tenant1-Raw"), rebalanceListener);

       while (true) {
    //       ConsumerRecords<byte[], byte[]> records = consumer.poll(1000);
    //       for (ConsumerRecord<byte[], byte[]> record : records) {
         //      System.out.printf("Received Message topic =%s, partition =%s, offset = %d, key = %s, value = %s\n", record.topic(), record.partition(), record.offset(), record.key(), record.value());
           }

       //    consumer.commitSync();
       }
   
    }
  /*   private static class  TestConsumerRebalanceListener implements ConsumerRebalanceListener {
       public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
           System.out.println("Called onPartitionsRevoked with partitions:" + partitions);
       }

       public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
           System.out.println("Called onPartitionsAssigned with partitions:" + partitions);
       }
   }*/

