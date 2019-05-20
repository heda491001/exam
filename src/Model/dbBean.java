package Model;

import java.util.ArrayList;
import java.util.List;

import DAO.OneRecord;

public class dbBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<OneRecord> allRecord=null;
	public dbBean() {
	}
	public dbBean(OneRecord one) {
		this.allRecord=new ArrayList<OneRecord>();
		allRecord.add(one);
	}
	public dbBean(List<OneRecord> allRecord) {
		this.allRecord=allRecord;
	}
	
	public List<OneRecord> getAllRecord() {
		return allRecord;
	}
	public void setAllRecord(List<OneRecord> allRecord) {
		this.allRecord = allRecord;
	}
}
