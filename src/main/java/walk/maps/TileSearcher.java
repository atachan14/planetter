package walk.maps;

import walk.main.Night;

public class TileSearcher {
	static Night night;

	public static void setNight(Night nightInst) {
		night = nightInst;
	}

	public static void addToAll(int index) {
		for (int y = 0; y < night.getMap().length; y++) {
			for (int x = 0; x < night.getMap().length; x++) {
				night.getMap()[y][x].hasObj.add(ObjGenerater.geneForIndex(index));
			}
		}
	}

	public static void addToRiverZone(int index) {
		int y = night.getMapSize() / 2;
		for (int x = 0; x < night.getMap()[y].length; x++) {
			night.getMap()[y][x].hasObj.add(ObjGenerater.geneForIndex(index));
		}
	}

	public static void addToBridgePoint(int index) {
		int y = night.getMap().length / 2;
		while (true) {
			int x = new java.util.Random().nextInt(night.getMap()[y].length - 2);
			if (night.getMap()[y][x].isAroundHasntIndexPer10(22)) {
				night.getMap()[y][x].hasObj.add(ObjGenerater.geneForIndex(index));
				return;
			}
		}
	}

	public static void addToAlonePoint(int index) {
		getAloneTile().hasObj.add(ObjGenerater.geneForIndex(index));
	}

	public static Tile getAloneTile() {
		int count = 0;
		while (count < 100) {
			int y = new java.util.Random().nextInt(night.getMap().length);
			int x = new java.util.Random().nextInt(night.getMap()[y].length);
			if (night.getMapTile(y, x).isAroundNothing()) {
				return night.getMapTile(y, x);
			}
			count++;
		}
		//error用メッセ
		System.out.println("TileSearchr.aloneTile();100count");
		return new Tile(-100, -100);
	}
}
