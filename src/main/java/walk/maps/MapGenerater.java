package walk.maps;

import walk.main.Night;

public class MapGenerater {
	static Night night;
	ObjGenerater objGenerater;
	TileSearcher tileSearcher;
	MapTools mapTools;

	public MapGenerater() {
		this.mapTools = new MapTools();
		this.objGenerater = new ObjGenerater();
		this.tileSearcher = new TileSearcher();
	}

	public static void setNight(Night nightInst) {
		night = nightInst;
	}

	public void selectNight() {
		switch (night.getNightCount()) {
		case 0:
			nightDebug();
			break;
		case 1:
//			night1gene();
			break;
		case 2:
			night2gene();
			break;
		case 3:
			night3gene();
			break;
		case 4:
			night4gene();
			break;
		default:
			break;
		}
	}

	public void nightDebug() {
		night.setMapSize(11);
		night.setMap(new Tile[night.getMapSize()][night.getMapSize()]);

		objGenerater.setTile();
		TileSearcher.addToAll(101);
		TileSearcher.addToRiverZone(210);
		TileSearcher.addToBridgePoint(220);
		TileSearcher.addToBridgePoint(221);
		TileSearcher.addToAlonePoint(410);

		night.setPlayer(new Player(tileSearcher.getAloneTile().getPos()));

	}

//	public void night1gene() {
//		night.setMapSize(11);
//		night.setMap(new Tile[night.getMapSize()][night.getMapSize()]);
//
//		objGenerater.setTile();
//		objGenerater.setNothing();
//
//		night.addTileOfMap(objGenerater.riverGene());
//		night.addTileOfMap(objGenerater.bridgesGenerate());
//
//		System.out.println(night.getMapTop(0, 0).getName());
//		System.out.println("setP前" + tileSearcher.getAloneTile().getTop().getName());
//		night.setPlayer(new Player(tileSearcher.getAloneTile().getPos()));
//
//	}

	public void night2gene() {

	}

	public void night3gene() {

	}

	public void night4gene() {
	}

}
