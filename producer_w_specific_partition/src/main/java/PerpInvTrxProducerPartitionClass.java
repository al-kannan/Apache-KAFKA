import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.kafka.clients.producer.*;

public class PerpInvTrxProducerPartitionClass {

	public static void main(String[] args) throws Exception{

		String topicName = "kafka_topic";

		Properties props = new Properties();
		props.put("bootstrap.servers", "kafka1:9092,kafka2:9092");
		props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "PerpInvTrxSerializer");

		props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,SitePartitioner.class.getCanonicalName());
		props.put("partitions.1","SITE1");
		props.put("partitions.2","SITE2");


		Producer<String, PerpInvTrx> producer = new KafkaProducer<>(props);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		PerpInvTrx sp1 = new PerpInvTrx("SITE1","PPO1","PMIX", df.parse("2019-04-01"), 100);
		PerpInvTrx sp2 = new PerpInvTrx("SITE2","PPO1","PMIX", df.parse("2019-04-01"), 200);

		//With partition number
		producer.send(new ProducerRecord<String,PerpInvTrx>(topicName,"SITE1",sp1)).get();
		producer.send(new ProducerRecord<String,PerpInvTrx>(topicName,"SITE2",sp2)).get();

		System.out.println("PerpInvTrx Producer Completed.");
		producer.close();

	}
} 
