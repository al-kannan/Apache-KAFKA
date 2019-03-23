#Create the topic
../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic streamorderheader --create --partitions 3 --replication-factor 3

../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic streamorderline --create --partitions 3 --replication-factor 3

../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic streamorderheaderline --create --partitions 3 --replication-factor 3

../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --list
