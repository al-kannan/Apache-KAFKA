#Create the topic
../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic streamorderheader2 --create --partitions 3 --replication-factor 3

../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic streamorderpayments2 --create --partitions 3 --replication-factor 3

../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic streamorderline2 --create --partitions 3 --replication-factor 3

../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic streamorderheaderline2 --create --partitions 3 --replication-factor 3

../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --list
