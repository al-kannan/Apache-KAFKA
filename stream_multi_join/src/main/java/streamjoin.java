import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.kstream.JoinWindows;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.GlobalKTable;
import org.apache.kafka.streams.kstream.KStream;
import java.util.concurrent.TimeUnit;

import java.util.Properties;

public class streamjoin {
    public static void main(String[] args) {

        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "streammultijoin-app2");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka1:9092");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        StreamsBuilder builder = new StreamsBuilder();

        GlobalKTable<String, String> headertable = builder.globalTable("streamorderheader2");

        GlobalKTable<String, String> paymenttable = builder.globalTable("streamorderpayments2");

        KStream<String, String> linestream = builder.stream("streamorderline2");

        // we want to enrich that stream
        KStream<String, String> streamorderheaderline =
                linestream.join(headertable,
                        (key, value) -> key, /* map from the (key, value) of this stream to the key of the GlobalKTable */
                        (line_info, deli_info) -> "PaymentInfo=" + line_info + ",DeliveryInfo=" + deli_info 
                );

        KStream<String, String> streamorderheaderlinepayment =
                streamorderheaderline.join(paymenttable,
                        (key, value) -> key, /* map from the (key, value) of this stream to the key of the GlobalKTable */
                        (line_info, pmt_info) -> "LineInfo=" + line_info + ",PaymentInfo=" + pmt_info 
                );

        streamorderheaderlinepayment.to("streamorderheaderline2");

        KafkaStreams streams = new KafkaStreams(builder.build(), config);
        streams.cleanUp(); // only do this in dev - not in prod
        streams.start();

        // print the topology
        streams.localThreadsMetadata().forEach(data -> System.out.println(data));

        // shutdown hook to correctly close the streams application
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

    }
}
