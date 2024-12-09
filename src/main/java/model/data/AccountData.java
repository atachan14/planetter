package model.data;

import java.io.Serializable;

public class AccountData implements Serializable{
	private String name;
	private String planet;
	private int stardust;
	private int stomach;
	private int x;
	private int y;
	private int direction;

	public AccountData(String name, String planet, int stardust, int stomach, int x, int y, int direction) {
		this.name = name;
		this.planet = planet;
		this.stardust = stardust;
		this.stomach = stomach;
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlanet() {
		return planet;
	}

	public void setPlanet(String planet) {
		this.planet = planet;
	}

	public int getStardust() {
		return stardust;
	}

	public void setStardust(int stardust) {
		this.stardust = stardust;
	}

	public int getStomach() {
		return stomach;
	}

	public void setStomach(int stomach) {
		this.stomach = stomach;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

}
