/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.amazone;
import java.io.IOException;
import kafka.api.*;
import kafka.cluster.Broker;
import kafka.common.OffsetAndMetadata;
import kafka.common.OffsetMetadataAndError;
import kafka.common.TopicAndPartition;
import kafka.javaapi.ConsumerMetadataResponse;
import kafka.javaapi.OffsetCommitRequest;
import kafka.javaapi.OffsetCommitResponse;
import kafka.javaapi.OffsetFetchRequest;
import kafka.javaapi.OffsetFetchResponse;
import kafka.network.BlockingChannel;
import java.util.*;
import kafka.common.ErrorMapping;
/**
 *
 * @author parth
 */
public class kafkaoffset {
    public static void main(String[] args) {
        BlockingChannel channel = new BlockingChannel("172.16.8.195", 9092,
                BlockingChannel.UseDefaultBufferSize(),
                BlockingChannel.UseDefaultBufferSize(),
                5000 /* read timeout in millis */);
        channel.connect();
        final String MY_GROUP = "demoGroup";
        final String MY_CLIENTID = "demoClientId";
        int correlationId = 0;
        final TopicAndPartition testPartition0 = new TopicAndPartition("tenant7-Raw", 0);
        final TopicAndPartition testPartition1 = new TopicAndPartition("tenant7-Raw", 1);
        channel.send(new ConsumerMetadataRequest(MY_GROUP, ConsumerMetadataRequest.CurrentVersion(), correlationId++, MY_CLIENTID));
        ConsumerMetadataResponse metadataResponse = ConsumerMetadataResponse.readFrom(channel.receive().buffer());
        if (metadataResponse.errorCode() == ErrorMapping.NoError()) {
            Broker offsetManager = metadataResponse.coordinator();
            // if the coordinator is different, from the above channel's host then reconnect
            channel.disconnect();
            channel = new BlockingChannel(offsetManager.host(), offsetManager.port(),
                    BlockingChannel.UseDefaultBufferSize(),
                    BlockingChannel.UseDefaultBufferSize(),
                    5000 /* read timeout in millis */);
            channel.connect();
        } else {
            // retry (after backoff)
        }
         List<TopicAndPartition> partitions = new ArrayList<TopicAndPartition>();
        partitions.add(testPartition0);
        OffsetFetchRequest fetchRequest = new OffsetFetchRequest(
                MY_GROUP,
                partitions,
                (short) 1 /* version */, // version 1 and above fetch from Kafka, version 0 fetches from ZooKeeper
                correlationId,
                MY_CLIENTID);
        channel.send(fetchRequest.underlying());
        OffsetFetchResponse fetchResponse = OffsetFetchResponse.readFrom(channel.receive().buffer());
        OffsetMetadataAndError result = fetchResponse.offsets().get(testPartition0);
        short offsetFetchErrorCode = result.error();
        boolean errorCode;
        if (offsetFetchErrorCode == ErrorMapping.NotCoordinatorForConsumerCode()) {
            channel.disconnect();
            // Go to step 1 and retry the offset fetch
     // retry the offset fetch (after backoff)
        } else {
            long retrievedOffset = result.offset();
            String retrievedMetadata = result.metadata();
        }
    }
}
