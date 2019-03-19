import java.util.Date;

public class PerpInvTrx{

	private String StoreNumber;
	private String ItemNumber;
	private String TrxType;
	private Date TrxDate;
	private int Qty;

	public PerpInvTrx(String siteid, String item, String trxtype, Date trxdate, int qty){
		this.StoreNumber = siteid;
		this.ItemNumber = item;
		this.TrxType = trxtype;
		this.TrxDate = trxdate;
		this.Qty = qty;
	}

	public String getStoreNumber(){
		return StoreNumber;
	}

	public String getItemNumber(){
		return ItemNumber;
	}

	public String getTrxType(){
		return TrxType;
	}

	public Date getTrxDate(){
		return TrxDate;
	}

	public int getQty(){
		return Qty;
	}
}  
