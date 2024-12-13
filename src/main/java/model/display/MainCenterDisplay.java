package model.display;

import java.io.Serializable;

import jakarta.servlet.http.HttpSession;

import dao.PageDAO;
import dao.TweetDAO;
import model.data.TileData;

public class MainCenterDisplay implements Serializable {
	private String jsp;
	private TileData v5Tile;
	private Object data;
	private String sdButton;

	public MainCenterDisplay() {

	}

	public MainCenterDisplay(HttpSession session) {
		MainInfoDisplay mainInfo = (MainInfoDisplay) session.getAttribute("mainInfo");
		v5Tile = mainInfo.getV5Tile();
		selectV5Display();
	}

	public void selectV5Display() {
		switch (v5Tile.getType()) {
		case "no objects":
			jsp = "mainCenter/v5/noObject.jsp";
			sdButton = "星屑を置く";
			return;
		case "tweet":
			jsp = "mainCenter/v5/tweet.jsp";
			sdButton = "星屑を広げる";
			data = TweetDAO.tileIdToTweetData(v5Tile.getId());
			return;
		case "page":
			jsp = "mainCenter/v5/page.jsp";
			sdButton = "星屑を重ねる";
			data = PageDAO.findPageDate(v5Tile.getId());
			return;
		case "book":
			jsp = "mainCenter/v5/book.jsp";
			return;
		default:
			System.out.println("MainCenterDisplay.selectV5Display:default" + v5Tile.getType());
			return;
		}
	}

	public void selectSideButton(String action) {
		switch (action) {
		case "星屑を置く":
			jsp = "mainCenter/action/putTweet.jsp";
			return;
		case "星屑を広げる":
			jsp = "mainCenter/action/spreadPage.jsp";
		}
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

	public String getSdButton() {
		return sdButton;
	}

	public void setSdButton(String sdButton) {
		this.sdButton = sdButton;
	}

}
