package walk.maps;

import java.util.ArrayList;

import walk.main.Night;
import walk.obj.Obj;

public class Tile {
	static Night night;
	public ArrayList<Obj> hasObj = new ArrayList<Obj>();
	public ArrayList<Player> hasPlayer = new ArrayList<Player>();
	Pos pos;
	int y;
	int x;
	Tile[] aroundTiles = new Tile[10];

	public Tile(int y, int x) {
		this.pos = new Pos(y, x);
		this.y = y;
		this.x = x;
	}

	public Obj getTop() {
		return hasObj.get(hasObj.size() - 1);
	}

	public Pos getPos() {
		return pos;
	}

	public Tile[] getAroundTile() {
		for (int i = 1; i < aroundTiles.length; i++) {
			int aroundy = MapTools.edgeOverExe(y + 1 - (i - 1) / 3);
			int aroundx = MapTools.edgeOverExe(x - 1 + (i - 1) % 3);

			aroundTiles[i] = night.getMap()[aroundy][aroundx];
		}
		return aroundTiles;
	}

	public boolean isNothing() {
		if (getTop().getIndex() / 100 == 1) {
			return true;
		}
		return false;
	}

	public boolean isIndexPer10(int index) {
		if (getTop().getIndex() / 10 == index) {
			return true;
		}
		return false;
	}

	public boolean isAroundNothing() {
		for (int i = 1; i < 10; i++) {
			if (!getAroundTile()[i].isNothing()) {
				return false;
			}
		}
		return true;
	}

	public boolean isAroundHasntIndexPer10(int index) {
		for (int i = 1; i < 10; i++) {
			if (getAroundTile()[i].isIndexPer10(index)) {
				return false;
			}
		}
		return true;
	}

	public static void setNight(Night nightInst) {
		night = nightInst;
	}

}


