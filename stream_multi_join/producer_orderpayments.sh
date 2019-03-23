../../../kafka/bin/kafka-console-producer.sh  --broker-list kafka1:9092  --topic streamorderpayments2  --property "parse.key=true"  --property "key.separator=:" <<!
ORD1:PaymentType:VISA
ORD2:PaymentType:MASTER
!
