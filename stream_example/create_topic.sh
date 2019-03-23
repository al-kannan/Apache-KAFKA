#Create the topic
../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic streamsourcetopic --create --partitions 3 --replication-factor 3

../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic streamintertopic1 --create --partitions 3 --replication-factor 3

../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic streamintertopic2 --create --partitions 3 --replication-factor 3

../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --topic streamsinktopic --create --partitions 3 --replication-factor 3

../../../kafka/bin/kafka-topics.sh --zookeeper zookeeper1:2181/kafka --list
