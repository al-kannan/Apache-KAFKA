../../../kafka/bin/kafka-console-producer.sh  --broker-list kafka1:9092  --topic streamorderpayments2  --property "parse.key=true"  --property "key.separator=:" <<!
ORD3:PaymentType:AMEX
ORD4:PaymentType:DISCOVER
!
