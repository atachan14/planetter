package model;

import java.util.HashMap;
import java.util.Map;

import dao.PlanetDAO;
import dao.TileDAO;
import dao.TweetDAO;
import model.data.TileData;
import model.data.TweetData;

public class AroundInfoManager {
	int x;
	int y;
	int direction;
	TileData[] aroundTile = new TileData[10];
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
			for (int i = 4; i < aroundTile.length; i++) {
				int tempx = (x - (i - 1) % 3 + 1);
				int tempy = (y - (i - 1) / 3 + 1);
				aroundTileMap.put(i, new TileData(plName, tempx, tempy));
				//				System.out.println(aroundPos[i].getxy());// debug
			}
			break;
		case 1:
			for (int i = 4; i < aroundTile.length; i++) {
				int tempx = (x - (i - 1) / 3 + 1);
				int tempy = (y + (i - 1) % 3 - 1);
				aroundTileMap.put(i, new TileData(plName, tempx, tempy));
				//				System.out.println(aroundPos[i].getxy());// debug
			}
			break;
		case 2:
			for (int i = 4; i < aroundTile.length; i++) {
				int tempx = (x + (i - 1) % 3 - 1);
				int tempy = (y + (i - 1) / 3 - 1);
				aroundTileMap.put(i, new TileData(plName, tempx, tempy));
				//				System.out.println(aroundPos[i].getxy());// debug
			}
			break;
		case 3:
			for (int i = 4; i < aroundTile.length; i++) {
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
			TileDAO.updateTileData(tile);
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
		switch (tile.getType()) {
		case "no objects":
			tile.setInfo("--");
			break;

		case "tweet":
			TweetData td =TweetDAO.findTweetDate(tile.getObjectId());
			String value = td.getValue();
			String info = value.length() > 6 ? value.substring(0, 5) + "..." : value;
			tile.setInfo(info);
			break;
		default:
			System.out.println("AroundInfoManager setupInfo null");
		}
	}

	public Map<Integer, TileData> getAroundTileMap() {
		return aroundTileMap;
	}

}
