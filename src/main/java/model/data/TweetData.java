package model.data;

public class TweetData {
	String value;
	String criater;
	String date;

	public TweetData(String value, String criater, String date) {
		this.value = value;
		this.criater = criater;
		this.date = date;

	}

	public String getValue() {
		return value;
	}

	public String getCriater() {
		return criater;
	}

	public String getDate() {
		return date;
	}
	
	

}
