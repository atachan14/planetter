package model;

public class Pos {
	
	int x;
	int y;
	
	

	public Pos() {
		
	}
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int gety() {
		return y;
	}

	public int getx() {
		return x;
	}

	public String getxy() {
		return x + "," + y;
	}

	public void sety(int y) {
		this.y = y;
	}

	public void setx(int x) {
		this.x = x;
	}

	public void setxy(int x, int y) {
		this.x = x;
		this.y = y;

	}


	

	// public boolean getHasAround() {
	// return hasAround;
	// }

}