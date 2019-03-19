import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.errors.SerializationException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.nio.ByteBuffer;

public class PerpInvTrxSerializer implements Serializer<PerpInvTrx> {
	private String encoding = "UTF8";

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		//nothing to configure
	}

	@Override
	public byte[] serialize(String topic, PerpInvTrx data) {
		int sizeOfStoreNumber;
		int sizeOfItemNumber;
		int sizeOfTrxType;
		int sizeOfTrxDate;
		byte[] serializedStoreNumber;
		byte[] serializedItemNumber;
		byte[] serializedTrxType;
		byte[] serializedTrxDate;

		try {
			if (data == null)
			return null;


			serializedStoreNumber = data.getStoreNumber().getBytes(encoding);
			sizeOfStoreNumber = serializedStoreNumber.length;

			serializedItemNumber = data.getItemNumber().getBytes(encoding);
			sizeOfItemNumber = serializedItemNumber.length;

			serializedTrxType = data.getTrxType().getBytes(encoding);
			sizeOfTrxType = serializedTrxType.length;

			serializedTrxDate = data.getTrxDate().toString().getBytes(encoding);
			sizeOfTrxDate = serializedTrxDate.length;

			ByteBuffer buf = ByteBuffer.allocate(
					4+sizeOfStoreNumber+
					4+sizeOfItemNumber+
					4+sizeOfTrxDate+
					4+sizeOfTrxDate+
					4+4
					);
			buf.putInt(sizeOfStoreNumber);
			buf.put(serializedStoreNumber);
			buf.putInt(sizeOfItemNumber);
			buf.put(serializedItemNumber);
			buf.putInt(sizeOfTrxType);
			buf.put(serializedTrxType);
			buf.putInt(sizeOfTrxDate);
			buf.put(serializedTrxDate);
			buf.putInt(4);
			buf.putInt(data.getQty());

			return buf.array();

		} catch (Exception e) {
			throw new SerializationException("Error when serializing Supplier to byte[]");
		}
	}

	@Override
	public void close() {
		//nothing to do
	}
}                             
