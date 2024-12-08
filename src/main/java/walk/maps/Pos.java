package walk.maps;

public class Pos {
	int y;
	int x;
	// boolean hasAround = false;

	// public Pos() {
	// }

	public Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}

	public Pos(Pos pos) {
		this.y = pos.y;
		this.x = pos.x;
	}

	// public void setyx(int y, int x) {
	// this.y = y;
	// this.x = x;
	// }

	public int gety() {
		return y;
	}

	public int getx() {
		return x;
	}

	public String getyx() {
		return y + "," + x;
	}

	public void sety(int y) {
		this.y = y;
	}

	public void setx(int x) {
		this.x = x;
	}

	public void setyx(int y, int x) {
		this.y = y;
		this.x = x;
	}

	// public boolean getHasAround() {
	// return hasAround;
	// }

}