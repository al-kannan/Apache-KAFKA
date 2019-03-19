package com.mycompany.app;


import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;

import java.util.Properties;

public class producer_w_acks{

    public static void main(String[] args) throws ExecutionException, InterruptedException {

	final Logger logger = LoggerFactory.getLogger(producer_w_acks.class);
        String bootstrapServers = "kafka1:9092";

        // create Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

	// Leader and follower brokers need to acknowledege the receipt of the message
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "all");

        // create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        // create a producer record
        ProducerRecord<String, String> record =
                new ProducerRecord<String, String>("kafka_topic", "key2", "producer with key value");

        //producer.send(record).get();

	producer.send(record).get();

	System.out.println("Successfully sent");

        // flush data
        producer.flush();
        // flush and close producer
        producer.close();

    }
}
