import java.util.*;
    import org.apache.kafka.clients.consumer.KafkaConsumer;
    import org.apache.kafka.clients.consumer.ConsumerRecords;
    import org.apache.kafka.clients.consumer.ConsumerRecord;
                                    
    public class PerpInvConsumer{
                                    
        public static void main(String[] args) throws Exception{
                                
            String topicName = "kafka_topic";
            String groupName = "PerpInvTrxTopicGroup";
                            
            Properties props = new Properties();
            props.put("bootstrap.servers", "kafka1:9092,kafka2:9092");
            props.put("group.id", groupName);
            props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            props.put("value.deserializer", "PerpInvTrxDeSerializer");                                
                                
            KafkaConsumer<String, PerpInvTrx> consumer = new KafkaConsumer<>(props);
            consumer.subscribe(Arrays.asList(topicName));
                                
            while (true){
                ConsumerRecords<String, PerpInvTrx> records = consumer.poll(100);
                for (ConsumerRecord<String, PerpInvTrx>record : records){
                    System.out.println(
"Store Number = " + record.value().getStoreNumber() + 
" Item Number = " + record.value().getItemNumber() + 
" Trx Type = " + record.value().getTrxType() + 
" Trx Date = " + record.value().getTrxDate().toString() +
" Qty = " + String.valueOf(record.value().getQty()));
                }
            }
                                
        }
    }            
