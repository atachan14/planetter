package walk.maps;

import walk.main.Night;
import walk.obj.Bridge;
import walk.obj.Dog;
import walk.obj.HomeGate;
import walk.obj.Nothing;
import walk.obj.Obj;
import walk.obj.OldBridge;
import walk.obj.River;

public class ObjGenerater {
	static Night night;
	TileSearcher tileSearcher = new TileSearcher();

	public static void setNight(Night nightInst) {
		night = nightInst;
	}

	public ObjGenerater() {
	}

	public void setTile() {
		for (int x = 0; x < night.getMap().length; x++) {
			for (int y = 0; y < night.getMap().length; y++) {
				Tile tile = new Tile(y, x);
				night.getMap()[y][x] = tile;
			}
		}
	}

	public static Obj geneForIndex(int index) {
		switch (index) {
		case 101:
			return new Nothing();

		case 210:
			return new River();

		case 220:
			return new Bridge();

		case 221:
			return new OldBridge();
			
		case 310:
			return new Dog();

		case 410:
			return new HomeGate();

		default:
			System.out.println("geneForIndex Error");
			return null;
		}
	}

	//	public ArrayList<Obj> riverGene() {
	//		ArrayList<Obj> rivers = new ArrayList<Obj>();
	//		for (int x = 0; x < night.getMap().length; x++) {
	//
	//			Pos pos = new Pos(night.getMapSize() / 2, x);
	//			River river = new River(pos);
	//			rivers.add(river);
	//		}
	//		return rivers;
	//	}

	//	public Obj[] bridgesGenerate() {
	//		int y = night.getMap().length / 2;
	//		int x = new java.util.Random().nextInt(night.getMap()[y].length - 2);
	//		Pos pos = new Pos(y, x);
	//		Bridge bridge = new Bridge(pos);
	//
	//		int oldx = 0;
	//		while (true) {
	//			oldx = new java.util.Random().nextInt(night.getMap()[y].length);
	//			if (oldx != x && oldx != x + 1 && oldx != x + 2) {
	//				break;
	//			}
	//		}
	//		Pos oldPos = new Pos(y, oldx);
	//		OldBridge oldBridge = new OldBridge(oldPos);
	//
	//		Obj[] bridges = new Obj[] { bridge, oldBridge };
	//		return bridges;
	//	}
}
