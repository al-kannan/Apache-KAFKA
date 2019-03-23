../../../kafka/bin/kafka-console-producer.sh  --broker-list kafka1:9092  --topic streamorderheader  --property "parse.key=true"  --property "key.separator=:" <<!
ORD3:DeliveryDate:3-3-2000
ORD4:DeliveryDate:4-4-2000
!
