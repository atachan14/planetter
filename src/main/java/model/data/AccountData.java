package model.data;

import java.io.Serializable;
import java.sql.Timestamp;

import model.tool.dayCount;

public class AccountData implements Serializable {
	private String name;
	private String planet;
	private int stardust;
	private int stomach;
	private int x;
	private int y;
	private int direction;
	private Timestamp date;
	private String keepDays;
	
	private int walkCount;
	private int eatCount;
	private int tweetCount;
	private int pageCount;
	private int dsasseCount;
	private int planetCount;
	private int killCount;
	
	
	
	public AccountData() {
		
	}

	public AccountData(String name, String planet, int stardust, int stomach, int x, int y, int direction,
			Timestamp date,int walkCount,int eatCount,int tweetCount,int pageCount,int dsasseCount,int planetCount,int killCount) {
		this.name = name;
		this.planet = planet;
		this.stardust = stardust;
		this.stomach = stomach;
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.date = date;
		this.keepDays = dayCount.getKeepDay(date);
		
		this.walkCount=walkCount;
		this.eatCount=eatCount;
		this.tweetCount=tweetCount;
		this.pageCount=pageCount;
		this.dsasseCount=dsasseCount;
		this.planetCount=planetCount;
		this.killCount=killCount;
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

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getKeepDays() {
		return keepDays;
	}

	public int getWalkCount() {
		return walkCount;
	}

	public int getEatCount() {
		return eatCount;
	}

	public int getTweetCount() {
		return tweetCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getDsasseCount() {
		return dsasseCount;
	}

	public int getPlanetCount() {
		return planetCount;
	}

	public int getKillCount() {
		return killCount;
	}
	
	

}
