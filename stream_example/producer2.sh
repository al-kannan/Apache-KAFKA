../../../kafka/bin/kafka-console-producer.sh  --broker-list kafka1:9092  --topic streamsourcetopic  --property "parse.key=true"  --property "key.separator=:" <<!
key1:400
key2:500
key3:600
!
