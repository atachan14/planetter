package model;

import java.util.HashMap;
import java.util.Map;

import dao.PlanetDAO;
import dao.TileDAO;

public class PosInfoManager {
	int x;
	int y;
	int direction;
	Pos[] aroundPos = new Pos[10];

	String plName;
	int pxsize;
	int pysize;

	public PosInfoManager(int x, int y, int direction, String plName) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.plName = plName;

		Pos pos = PlanetDAO.getSize(plName);
		System.out.println("pim"+pos.getx());
		this.pxsize = pos.getx();
		this.pysize = pos.gety();

		setupAroundPos();
	}

	void setupAroundPos() {
		switch (direction) {
		case 0:
			for (int i = 1; i < aroundPos.length; i++) {
				int tempx = (x - (i - 1) % 3 + 1);
				int tempy = (y - (i - 1) / 3 + 1);
				aroundPos[i] = new Pos(tempx, tempy);
				System.out.println(aroundPos[i].getxy());// debug
			}
			break;
		case 1:
			for (int i = 1; i < aroundPos.length; i++) {
				int tempx = (x - (i - 1) / 3 + 1);
				int tempy = (y + (i - 1) % 3 - 1);
				aroundPos[i] = new Pos(tempx, tempy);
				System.out.println(aroundPos[i].getxy());// debug
			}
			break;
		case 2:
			for (int i = 1; i < aroundPos.length; i++) {
				int tempx = (x + (i - 1) % 3 - 1);
				int tempy = (y + (i - 1) / 3 - 1);
				aroundPos[i] = new Pos(tempx, tempy);
				System.out.println(aroundPos[i].getxy());// debug
			}
			break;
		case 3:
			for (int i = 1; i < aroundPos.length; i++) {
				int tempx = (x + (i - 1) / 3 - 1);
				int tempy = (y - (i - 1) % 3 + 1);
				aroundPos[i] = new Pos(tempx, tempy);
				System.out.println(aroundPos[i].getxy());// debug
			}
			break;
		default:
			System.out.println("setupAroundPos direction error");
			break;
		}
		//		System.out.println("↓updated↓");
		for (int i = 1; i < aroundPos.length; i++) {
			edgeOverUpdate(aroundPos[i]);
			//			System.out.println(aroundPos[i].getxy());
		}
	}

	void edgeOverUpdate(Pos pos) {
		int x = edgeOverInt(pos.getx(), pxsize);
		int y = edgeOverInt(pos.gety(), pysize);
		pos.setx(x);
		pos.sety(y);
	}

	int edgeOverInt(int num, int psize) {
		if (num > pxsize - 1)
			num = num - pxsize;
		if (num < 0)
			num = pxsize + num;

		return num;
	}

	public String getTileInfo(Pos pos) {
		switch (TileDAO.findType(plName, pos)) {
		case "no objects":
			return "no objects";

		case "tweet":
			return "tweetの一番上";

		default:
			return "";
		}
	}

	public Map<Integer, String> getAroundInfoMap() {
		Map<Integer, String> aroundInfoMap = new HashMap<>();

		for (int i = 4; i < aroundPos.length; i++) {
			aroundInfoMap.put(i, getTileInfo(aroundPos[i]));
		}
		return aroundInfoMap;
	}
	

	//	public String getLeftForwardInfo() {
	//		return getType(aroundPos[7]);
	//	}
	//
	//	public String getNextInfo() {
	//		return getType(aroundPos[8]);
	//	}
	//
	//	public String getRightForwardInfo() {
	//		return getType(aroundPos[9]);
	//	}
	//
	//	public String getLeftInfo() {
	//		return getType(aroundPos[4]);
	//	}
	//
	//	public String getNowInfo() {
	//		return getType(aroundPos[5]);
	//	}
	//
	//	public String getRightInfo() {
	//		return getType(aroundPos[6]);
	//	}

}
