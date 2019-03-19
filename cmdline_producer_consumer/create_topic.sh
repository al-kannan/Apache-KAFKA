#Create the topic
../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic console_topic --create --partitions 3 --replication-factor 2

../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic console_topic --list

../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic console_topic --describe 
