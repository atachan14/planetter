package model.data;

public class UpGradeData {
	int destiny;
	String ugName;
	int sd;
	public UpGradeData(int destiny,String ugName,int sd){
		this.destiny=destiny;
		this.ugName=ugName;
		this.sd=sd;
	}
	
	
	
	public int getDestiny() {
		return destiny;
	}

	public void setDestiny(int destiny) {
		this.destiny = destiny;
	}

	public String getUgName() {
		return ugName;
	}
	public void setUgName(String ugName) {
		this.ugName = ugName;
	}
	public int getSd() {
		return sd;
	}
	public void setSd(int sd) {
		this.sd = sd;
	}
	
	
}
