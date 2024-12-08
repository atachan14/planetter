package walk.main;

import java.util.ArrayList;

import walk.maps.MapGenerater;
import walk.maps.MapTools;
import walk.maps.ObjGenerater;
import walk.maps.Player;
import walk.maps.Pos;
import walk.maps.Tile;
import walk.maps.TileRider;
import walk.maps.TileSearcher;
import walk.obj.Obj;

public class Night {
	MapGenerater mapGenerater;
	Fase fase;

	int nightCount = 0;
	Tile[][] map;
	int mapSize;

	public Player p;

	public Night() {

	}

	public void setUp(int nightCount) {
		this.nightCount = nightCount;

		MapGenerater.setNight(this);
		MapTools.setNight(this);
		TileRider.setNight(this);
		ObjGenerater.setNight(this);
		Tile.setNight(this);
		TileSearcher.setNight(this);

		mapGenerater = new MapGenerater();
		fase = new Fase(this);

	}

	public void game() {
		mapGenerater.selectNight();

		fase.start();
		Fase.walk();
		while (true) {
			MapTools.cheetMap();		
			fase.overDisplay();
			fase.underDisplay();
		}
	}

	public int getNightCount() {
		return this.nightCount;
	}

	public Tile[][] getMap() {
		return map;
	}

	public void setMap(Tile[][] map) {
		this.map = map;
	}

	public Player getPlayer() {
		return p;
	}

	public void setPlayer(Player p) {
		this.p = p;
		System.out.println("setPlayer");
	}

	public int getMapSize() {
		return mapSize;
	}

	public void setMapSize(int num) {
		this.mapSize = num;
	}

	public Tile getMapTile(int y, int x) {
		return map[y][x];
	}

	public Pos getMapPos(int y, int x) {
		return map[y][x].getPos();
	}

	public Obj getMapTop(int y, int x) {
		return map[y][x].hasObj.get(map[y][x].hasObj.size() - 1);
	}

	public Obj getTopByPos(Pos pos) {
		int y = pos.gety();
		int x = pos.getx();
		return map[y][x].getTop();
	}

	public void addTileOfMap(Obj obj) {
		//		System.out.println(obj.getName());
		int y = obj.gety();
		int x = obj.getx();
		getMap()[y][x].hasObj.add(obj);
		//		System.out.println(getMap()[y][x].hasObj.get(getMap()[y][x].hasObj.size() - 1).getName());
	}

	public void addTileOfMap(ArrayList<Obj> objs) {
		for (Obj obj : objs) {
			int y = obj.gety();
			int x = obj.getx();
			getMap()[y][x].hasObj.add(obj);
		}
	}

	public void addTileOfMap(Obj[] objs) {
		for (Obj obj : objs) {
			int y = obj.gety();
			int x = obj.getx();
			getMap()[y][x].hasObj.add(obj);
		}
	}

	public void addTileOfMap(int y, int x, Obj obj) {
		getMap()[y][x].hasObj.add(obj);
	}

	public void addTileOfMap(Player player) {
		int y = player.gety();
		int x = player.getx();
		getMap()[y][x].hasPlayer.add(player);
	}
}
