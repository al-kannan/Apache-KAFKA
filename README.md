# kafka
Kafka

## Command Line Producer & Consumer
This is simple first step, I just created a topic using the kafka-topics.sh and kafka-console-producer.sh. Then I read the messages using kafka-console-consumer.sh

## Simple Producer Java Code
This is a simple Java code that will connect to one of the three kafka servers as bootstrap server. Created a Properties object and provide bootstrapserver, key serializer and value serializer. Then we create kafka producer object and producer record object and send it

## Simple Consumer Java Code
This is a simple Java code that will connect to one of the three kafka servers with a application id. Created a Properties object and provide bootstrapserver, key and value serializer, offset reset is set to earliest. Then I created Kafka Consumer object and got into a loop to keep poling 100 millisecond and printing records

## producer_w_get

## producer_w_acks

## producer_w_callback

## producer_w_serializer

## producer_idempotent

## producer_w_specific_partition

## producer_high_throughput

## producer_scala

## consumer_group

## consumer_offset_reset

## consumer_w_assign_seek

## consumer_w_commit

## consumer_w_deserializer

## consumer_w_specific_partition

## kafka_file_connect

## stream_example

## stream_join

## stream_multi_join
