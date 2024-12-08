package walk.obj;

import walk.maps.Pos;
import walk.maps.Tile;
import walk.maps.TileRider;

public class Obj extends TileRider {
	String name;
	char nam;
	int index;

	boolean ride;
	String hereMesse;
	String nextMesse;
	String aroundMesse;
	String cantWalkMesse;

	public Obj() {

	}

	public Obj(Tile tile) {
		tile.hasObj.add(this);
	}

	public Obj(Pos pos) {
		super(pos);
	}

	public Obj(int y, int x) {
		super(y, x);
	}

	public void hereExe() {
		printHereMesse();
		effectHere();
	}

	public void printHereMesse() {
		System.out.println(hereMesse);

	}

	public void effectHere() {

	}

	public String getName() {
		return name;
	}

	public char getNam() {
		return nam;
	}

	public int getIndex() {
		return index;
	}

	public boolean isRide() {
		return ride;
	}

	public String getHereMesse() {
		return hereMesse;
	}

	public String getNextMesse() {
		return nextMesse;
	}

	public String getAroundMesse() {
		return aroundMesse;
	}


}