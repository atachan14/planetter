package walk.maps;

import walk.main.Night;

public class TileRider {
	public static Night night;
	Pos pos;

	public TileRider() {

	}

	public TileRider(Pos pos) {
		this.pos = pos;
	}

	public TileRider(int y, int x) {
		this.pos = new Pos(y, x);
	}

	public Pos getPos() {
		return pos;
	}

	public int gety() {
		return pos.y;
	}

	public int getx() {
		return pos.x;
	}

	public String getyx() {
		return pos.y + "," + pos.x;
	}

	public void setPos(Pos pos) {
		this.pos = pos;
	}

	public void sety(int y) {
		this.pos.y = y;
	}

	public void setx(int x) {
		this.pos.x = x;
	}

	public static void setNight(Night nightInst) {
		night = nightInst;
	}
}
