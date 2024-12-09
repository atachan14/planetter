package model;

public class Account {
	String name;
	int stardust;
	
	String nowPlanet;
	int x;
	int y;
	int direction;

	int nextPosx;
	int nextPosy;

	public Account(String name) {
		this.name = name;
		this.stardust = 100;

		this.nowPlanet="beginerPlanet";
		this.x=5;
		this.y=5;
		this.direction=2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStardust() {
		return stardust;
	}

	public void setStardust(int stardust) {
		this.stardust = stardust;
	}

	public String getNowPlanet() {
		return nowPlanet;
	}

	public void setNowPlanet(String nowPlanet) {
		this.nowPlanet = nowPlanet;
	}

	

	public int getNowPosx() {
		return x;
	}

	public void setNowPosx(int nowPosx) {
		this.x = nowPosx;
	}

	public int getNowPosy() {
		return y;
	}

	public void setNowPosy(int nowPosy) {
		this.y = nowPosy;
	}

	public int getNextPosx() {
		return nextPosx;
	}

	public void setNextPosx(int nextPosx) {
		this.nextPosx = nextPosx;
	}

	public int getNextPosy() {
		return nextPosy;
	}

	public void setNextPosy(int nextPosy) {
		this.nextPosy = nextPosy;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	

}
