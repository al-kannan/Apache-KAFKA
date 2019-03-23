../../../kafka/bin/kafka-console-producer.sh  --broker-list kafka1:9092  --topic streamorderline2  --property "parse.key=true"  --property "key.separator=:" <<!
ORD3:Item5,100
ORD3:Item6,200
ORD4:Item7,200
ORD4:Item8,200
!
