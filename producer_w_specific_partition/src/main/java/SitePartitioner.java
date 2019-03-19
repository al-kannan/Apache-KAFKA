import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

public class SitePartitioner implements Partitioner {
	private static Map<String,Integer> siteToPartitionMap;

	public void configure(Map<String, ?> configs) {
		System.out.println("Inside SitePartitioner.configure " + configs);
		siteToPartitionMap = new HashMap<String, Integer>();
		for(Map.Entry<String,?> entry: configs.entrySet()){
			if(entry.getKey().startsWith("partitions.")){
				String keyName = entry.getKey();
				String value = (String)entry.getValue();
				System.out.println( keyName.substring(11));
				int paritionId = Integer.parseInt(keyName.substring(11));
				siteToPartitionMap.put(value,paritionId);
			}
		}
	}

	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		List partitions = cluster.availablePartitionsForTopic(topic);
		if(siteToPartitionMap.containsKey(key)){
				System.out.println("Yes inside partition map");
				return siteToPartitionMap.get(key);
			}else {
				//If no site is mapped to particular partition distribute between remaining partitions
				System.out.println("Not inside partition map" );
				int noOfPartitions = cluster.topics().size();
				return  value.hashCode()%noOfPartitions + siteToPartitionMap.size() ;
			}
	}

	public void close() {}
}
