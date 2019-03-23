# kafka
Kafka

## Command Line Producer & Consumer
This is simple first step, I just created a topic using the kafka-topics.sh and kafka-console-producer.sh. Then I read the messages using kafka-console-consumer.sh

## Simple Producer Java Code
This is a simple Java code that will connect to one of the three kafka servers as bootstrap server. Created a Properties object and provide bootstrapserver, key serializer and value serializer. Then we create kafka producer object and producer record object and send it

## Simple Consumer Java Code
This is a simple Java code that will connect to one of the three kafka servers with a application id. Created a Properties object and provide bootstrapserver, key and value serializer, offset reset is set to earliest. Then I created Kafka Consumer object and got into a loop to keep poling 100 millisecond and printing records

## producer_w_get
Kafka producers can do either fire and forget approach which is fast or it can wait for a response from the broker for every message. Producer.send(record).get() will make the producer to wait for each message sent

## producer_w_acks
Kafka topics can have many partitions and can have in-sync replicas for protecting the data. When we send data to a topic we can do fire and foreget, we can do get, we can do acks with just the leader or all to ensure message is copied to leader (primary broker which takes care of the partition) and all replica brokers which maintain copies

## producer_w_callback
Kafka producer can also take some action upon successful message sent, in which case we need to hook a method call which will be executed by the producer upon receiving acknowledgement from the brokker

## producer_w_serializer
Kafka producer send message over the network, these message can be simple strings, int or any class with complex data structure in it. We can write custom serializer to create a byte array which can be transported to Kafka brokker, which in turn will write it to topic log file based on partition. This code has the feature with custom producer serializer 

## producer_idempotent
Kafka producer send messages, but there is no gaurentee that the message has been sent, to avoid duplicate message Kafka has built in mechanism to send message with a unique ID, if producer sends the same message again Kafka broker will not record the duplicate message based system generated internal ID. This is done using ENABLE_IDEMPOTENCE_CONFIG set to True

## producer_w_specific_partition
Kafka topics need to be properly partitioned based on number of nodes and key distribution. To leverage parallel streaming of message this code is tested with specific partition, this will eliminate network traffic if producer is deployed to the kafka node based on local partition

## producer_high_throughput
Kafka also support send messages in batch, this code LINGER_MS_CONFIG and BATCH_SIZE_CONFIG parameters

## producer_scala
Kafka can also implicated using Scala, I have done all the code in JAVA except this one. 

## consumer_group
Kafka Consumer Group allows to create many consumers sharing the topic by partition, if we have three partition we can have three consumers in a consumer group, this division of partition is handled by Kafka. Note: If we have more consumers than partitions then those additional consumers will be idle until one of the consumer got terminated

## consumer_offset_reset
Kafka consumers are designed to read messages based on partition offset, offset values are maintained by the kafka server, but one can reset the offset from command line or in the code to read always all lines from partition

## consumer_w_assign_seek
Kafka consumers can also be coded to read from sepcific partition and from sepecific offset number. 

## consumer_w_commit
Kafka consumer offset are managed by commits, implicit commits are handled by the Kafka broker, but we can also control the commits manally. This code shows how to do it. 

## consumer_w_deserializer
This is similar to Kafka producer message serialization, this is deserialization. This is a custom deserialization which is usefull, but AVRO is the better approach which support different versions of the data structure

## consumer_w_specific_partition
This is similar to Assign and Seek, consumer reading it from a specific partition, which is very use full to avoid network traffic, besides if we have to connect to AKKA actors to Kafka topics then this method of divide and process will be useful. 

## kafka_file_connect
This is another useful feature to load a flat file to Kafka topic

## stream_example
Kafka can also process data from a topic and write it back to another Kafka topic very efficiently, effectively this paves ways for ETL processing with many transformations. This demonstrates the stream processing. 

## stream_join
Kafka stream can also join different topic and process and then write to a sink topic 

## stream_multi_join
This demonstrates multiple topics can be joined and toplogy can be created  for Kafka steam processing, pretty cool
