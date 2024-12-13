package model.display;

import java.io.Serializable;

import jakarta.servlet.http.HttpSession;

import dao.TweetDAO;
import model.data.TileData;

public class MainCenterDisplay implements Serializable {
	private String jsp;
	private TileData v5Tile;
	private Object data;
	public MainCenterDisplay() {

	}

	public MainCenterDisplay(HttpSession session) {
		MainInfoDisplay mainInfo = (MainInfoDisplay) session.getAttribute("mainInfo");
		v5Tile = mainInfo.getV5Tile();
		selectV5Display();
	}

	public void selectV5Display() {
		switch (v5Tile.getType()) {
		case "--":
			jsp = "mainCenter/v5/noObject.jsp";
			return;
		case "tweet":
			jsp = "mainCenter/v5/tweet.jsp";
			data =TweetDAO.findTweetDate(v5Tile.getObjectId());
			return;
		case "page":
			jsp = "mainCenter/v5/page.jsp";
			return;
		case "book":
			jsp = "mainCenter/v5/book.jsp";
			return;
		default:
			System.out.println("MainCenterDisplay.selectV5Display:default"+v5Tile.getType());
			return;
		}
	}

	public void selectSideButton(String action) {
		switch (action) {
		case "星屑を置いてく":
			jsp = "mainCenter/action/putTweet.jsp";
			return;

		}
	}
	
	void tweetDisplay() {
		
	}
	

	public String getJsp() {
		return jsp;
	}

	public void setJsp(String jsp) {
		this.jsp = jsp;
	}

	public Object getData() {
		return data;
	}

	

}
