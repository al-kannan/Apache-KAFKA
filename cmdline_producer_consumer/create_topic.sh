#Create the topic
../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic topic1 --create --partitions 3 --replication-factor 2

../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic topic1 --list

../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic topic1 --describe 
