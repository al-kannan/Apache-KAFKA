../../../kafka/bin/kafka-console-producer.sh  --broker-list kafka1:9092  --topic streamorderline2  --property "parse.key=true"  --property "key.separator=:" <<!
ORD1:Item1,100
ORD1:Item2,200
ORD2:Item3,200
ORD2:Item4,200
!
