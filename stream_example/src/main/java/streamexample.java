import java.util.Properties;
import java.util.Arrays;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.kafka.streams.kstream.KTable;

public class streamexample {
    public static void main(String[] args) {
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "StreamAppId1");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka1:9092");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        // 1 - stream from Kafka
	KStreamBuilder builder = new KStreamBuilder();

        KStream<String, String> kStream = builder.stream("streamsourcetopic");
        // do stuff

	kStream = kStream.map((key, value) -> {
		KeyValue<String, String> keyvalue;
		keyvalue = new KeyValue(key, Integer.toString(Integer.parseInt(value)*1000));
		return keyvalue;
	}
	);

	kStream.to("streamsinktopictmp");

        KafkaStreams streams = new KafkaStreams(builder, config);
        streams.cleanUp();

        streams.start();

        // print the topology
        System.out.println(streams.toString());

        // shutdown hook to correctly close the streams application
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
	}

}
