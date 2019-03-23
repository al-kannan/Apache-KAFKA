../../../kafka/bin/kafka-console-producer.sh  --broker-list kafka1:9092  --topic streamsourcetopic  --property "parse.key=true"  --property "key.separator=:" <<!
key1:100
key2:200
key3:300
!
