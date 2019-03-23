name := "KafkaProject"
version := "1.0"
scalaVersion := "2.12.8"

// https://mvnrepository.com/artifact/org.apache.kafka/kafka
//libraryDependencies += "org.apache.kafka" %% "kafka" % "2.1.1"
libraryDependencies += "org.apache.kafka" %% "kafka" % "0.11.0.3"

libraryDependencies ++= Seq("org.slf4j" % "slf4j-api" % "1.7.5",
                            "org.slf4j" % "slf4j-simple" % "1.7.5")

// https://mvnrepository.com/artifact/org.apache.kafka/kafka-streams
//libraryDependencies += "org.apache.kafka" % "kafka-streams" % "2.1.1"
//libraryDependencies += "org.apache.kafka" % "kafka-streams" % "0.10.2.0"
libraryDependencies += "org.apache.kafka" % "kafka-streams" % "0.11.0.3"
