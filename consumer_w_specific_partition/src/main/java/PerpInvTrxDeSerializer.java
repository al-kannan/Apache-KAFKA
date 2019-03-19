import java.nio.ByteBuffer;
    import java.util.Date;
    import java.text.DateFormat;
    import java.text.SimpleDateFormat;
    import org.apache.kafka.common.errors.SerializationException;
    import org.apache.kafka.common.serialization.Deserializer;
    import java.io.UnsupportedEncodingException;
    import java.util.Map;
                                    
    public class PerpInvTrxDeSerializer implements Deserializer<PerpInvTrx> {
        private String encoding = "UTF8";
                                    
        @Override
        public void configure(Map<String, ?> configs, boolean isKey) {
            //Nothing to configure
        }
                                    
        @Override
        public PerpInvTrx deserialize(String topic, byte[] data) {
                                    
            try {
                    if (data == null){
                        System.out.println("Null recieved at deserialize");
                        return null;
                    }
                
                    ByteBuffer buf = ByteBuffer.wrap(data);
                                        
                    int sizeOfStoreNumber = buf.getInt();
                    byte[] StoreNumberBytes = new byte[sizeOfStoreNumber];
                    buf.get(StoreNumberBytes);
                    String deserializedStoreNumber = new String(StoreNumberBytes, encoding);

                    int sizeOfItemNumber = buf.getInt();
                    byte[] ItemNumberBytes = new byte[sizeOfItemNumber];
                    buf.get(ItemNumberBytes);
                    String deserializedItemNumber = new String(ItemNumberBytes, encoding);

                    int sizeOfTrxType = buf.getInt();
                    byte[] TrxTypeBytes = new byte[sizeOfTrxType];
                    buf.get(TrxTypeBytes);
                    String deserializedTrxType = new String(TrxTypeBytes, encoding);
                                        
                    int sizeOfTrxDate = buf.getInt();
                    byte[] TrxDateBytes = new byte[sizeOfTrxDate];
                    buf.get(TrxDateBytes);
                    String TrxDateString = new String(TrxDateBytes,encoding);                                    
                    DateFormat df = new SimpleDateFormat("EEE MMM ddHH:mm:ss Z yyyy");

                    int sizeOfQty = buf.getInt();
                    int Qty = buf.getInt();
                                        
                    return new PerpInvTrx(deserializedStoreNumber,deserializedItemNumber, deserializedTrxType,df.parse(TrxDateString), Qty);
                                    
                } catch (Exception e) {
                    throw new SerializationException("Error when deserializing byte[] to PerpInvTrx");
            }
        }
                                    
        @Override
        public void close() {
            // nothing to do
        }
    }                            
