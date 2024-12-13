package model.data;

import java.util.ArrayList;
import java.util.List;

public class PageData {
	String name;
	String criater;
	String date;
	List<TweetData> tweetList = new ArrayList<>();

	public PageData(String name, String criater, String date) {
		this.name = name;
		this.criater = criater;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public String getCriater() {
		return criater;
	}

	public String getDate() {
		return date;
	}

	public List<TweetData> getTweetList() {
		return tweetList;
	}
}
