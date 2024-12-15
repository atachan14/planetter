package model;

import java.util.HashMap;
import java.util.Map;

import dao.AccountDAO;
import dao.PageDAO;
import dao.PlanetDAO;
import dao.TileDAO;
import dao.TweetDAO;
import model.data.AccountData;
import model.data.PageData;
import model.data.TileData;
import model.data.TweetData;
import model.tool.Color;

public class AroundInfoManager {
	int x;
	int y;
	int direction;
	Map<Integer, TileData> aroundTileMap = new HashMap<>();

	String plName;
	int pxsize;
	int pysize;

	public AroundInfoManager(int x, int y, int direction, String plName) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.plName = plName;

		Pos pos = PlanetDAO.getSize(plName);
		this.pxsize = pos.getx();
		this.pysize = pos.gety();

		setupAroundTile();
	}

	void setupAroundTile() {
		switch (direction) {
		case 0:
			for (int i = 4; i < 10; i++) {
				int tempx = (x - (i - 1) % 3 + 1);
				int tempy = (y - (i - 1) / 3 + 1);
				aroundTileMap.put(i, new TileData(plName, tempx, tempy));
				//				System.out.println(aroundPos[i].getxy());// debug
			}
			break;
		case 1:
			for (int i = 4; i < 10; i++) {
				int tempx = (x - (i - 1) / 3 + 1);
				int tempy = (y + (i - 1) % 3 - 1);
				aroundTileMap.put(i, new TileData(plName, tempx, tempy));
				//				System.out.println(aroundPos[i].getxy());// debug
			}
			break;
		case 2:
			for (int i = 4; i < 10; i++) {
				int tempx = (x + (i - 1) % 3 - 1);
				int tempy = (y + (i - 1) / 3 - 1);
				aroundTileMap.put(i, new TileData(plName, tempx, tempy));
				//				System.out.println(aroundPos[i].getxy());// debug
			}
			break;
		case 3:
			for (int i = 4; i < 10; i++) {
				int tempx = (x + (i - 1) / 3 - 1);
				int tempy = (y - (i - 1) % 3 + 1);
				aroundTileMap.put(i, new TileData(plName, tempx, tempy));
				//				System.out.println(aroundPos[i].getxy());// debug
			}
			break;
		default:
			System.out.println("setupAroundPos direction error");
			break;
		}
		//		System.out.println("↓updated↓");
		for (TileData tile : aroundTileMap.values()) {
			edgeOverUpdate(tile);
			TileDAO.posTileUpgrade(tile);
			setupInfo(tile);

			//			System.out.println(aroundPos[i].getxy());
		}
	}

	void edgeOverUpdate(TileData pos) {
		int x = edgeOverInt(pos.getX(), pxsize);
		int y = edgeOverInt(pos.getY(), pysize);
		pos.setX(x);
		pos.setY(y);
	}

	static int edgeOverInt(int num, int psize) {
		if (num > psize - 1)
			num = num - psize;
		if (num < 0)
			num = psize + num;

		return num;
	}

	public void setupInfo(TileData tile) {
		//プレイヤー確認
		AccountData anotherPlayer = AccountDAO.posTileSearchAccount(tile);
		if(anotherPlayer.getName()!=null) {
			tile.setInfo(anotherPlayer.getName());
			tile.setInfoColor(Color.getPlayer());
			return;
		}
		
		//いなかったらタイル確認
		switch (tile.getType()) {
		case "no objects":
			tile.setInfo("--");
			tile.setInfoColor(Color.getNoObject());
			return;

		case "tweet":
			TweetData tweetData = TweetDAO.tileIdToTweetData(tile.getId());
			String value = tweetData.getValue();
			String info = value.length() > 6 ? value.substring(0, 5) + "..." : value;
			tile.setInfo(info);
			tile.setInfoColor(Color.getTweet());
			return;
			
		case "page":
			PageData pageData = PageDAO.criatePageDate(tile.getId());
			String pageValue = pageData.getTweetList().get(0).getValue();
			String pageInfo = pageValue.length() > 16 ? pageValue.substring(0, 16) + "..." : pageValue;
			tile.setInfo(pageInfo);
			tile.setInfoColor(Color.getPage());
			return;

		default:
			System.out.println("AroundInfoManager setupInfo null");
			return;
		}
	}

	public Map<Integer, TileData> getAroundTileMap() {
		return aroundTileMap;
	}

}
