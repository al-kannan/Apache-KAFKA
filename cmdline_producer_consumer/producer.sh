#Send some messages 
../kafka/bin/kafka-console-producer.sh --broker-list kafka1:9092,kafka2:9092,kafka3:9092 --topic console_topic  <<!
This message is from console prducer 2
This is line 2  2
This is line 3 2
!
