../../../kafka/bin/kafka-console-producer.sh  --broker-list kafka1:9092  --topic streamorderheader2  --property "parse.key=true"  --property "key.separator=:" <<!
ORD1:DeliveryDate:1-1-2000
ORD2:DeliveryDate:2-2-2000
!
