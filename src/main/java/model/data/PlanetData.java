package model.data;

import java.sql.Timestamp;

import model.tool.dayCount;

public class PlanetData {
	String name;
	int xsize;
	int ysize;
	String criater;
	int x;
	int y;
	Timestamp date;
	String keepDays;
	int nameDisplay;
	int stealth;
	String backGroundColor;

	public PlanetData(String name) {
		this.name = name;
	}

	public PlanetData(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public PlanetData(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public PlanetData(String name, int xsize, int ysize, String criater, int x, int y, Timestamp date, int nameDisplay,
			int stealth, String backGroundColor) {
		this.name = name;
		this.xsize = xsize;
		this.ysize = ysize;
		this.criater = criater;
		this.x = x;
		this.y = y;
		this.date = date;
		this.keepDays = dayCount.getKeepDay(date);
		this.nameDisplay = nameDisplay;
		this.stealth = stealth;
		this.backGroundColor = backGroundColor;
	}

	public String getName() {
		return name;
	}

	public int getXsize() {
		return xsize;
	}

	public int getYsize() {
		return ysize;
	}

	public String getCriater() {
		return criater;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Timestamp getDate() {
		return date;
	}

	public String getKeepDays() {
		return keepDays;
	}

	public int getNameDisplay() {
		return nameDisplay;
	}

	public int getStealth() {
		return stealth;
	}

	public String getBackGroundColor() {
		return backGroundColor;
	}
	
	

}
