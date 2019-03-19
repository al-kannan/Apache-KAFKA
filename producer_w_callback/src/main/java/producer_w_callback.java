package com.mycompany.app;


import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;

import java.util.Properties;

public class producer_w_callback {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

	final Logger logger = LoggerFactory.getLogger(producer_w_callback.class);
        String bootstrapServers = "kafka1:9092";

        // create Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        // create a producer record
        ProducerRecord<String, String> record =
                new ProducerRecord<String, String>("kafka_topic", "key2", "producer with key value");

        //producer.send(record).get();

	producer.send(record, new Callback() {
		public void onCompletion(RecordMetadata recordMetadata, Exception e) {
			if (e == null) {
				logger.info("Received new metadata. \n" +
				"Topic:" + recordMetadata.topic() + "\n" +
				"Partition: " + recordMetadata.partition() + "\n" +
				"Offset: " + recordMetadata.offset() + "\n" +
				"Timestamp: " + recordMetadata.timestamp());
			} else {
				logger.error("Error while producing", e);
			}
		}
	}
	).get();



	System.out.println("Successfully sent");

        // flush data
        producer.flush();
        // flush and close producer
        producer.close();

    }
}
