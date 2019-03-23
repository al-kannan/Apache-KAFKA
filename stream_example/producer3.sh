../../../kafka/bin/kafka-console-producer.sh  --broker-list kafka1:9092  --topic streamsourcetopic  --property "parse.key=true"  --property "key.separator=:" <<!
key1:21234
key2:24567
key3:28798
!
