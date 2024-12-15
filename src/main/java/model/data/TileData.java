package model.data;

public class TileData {
	int id;
	String type;
	String plName;
	int x;
	int y;

	String info;
	String infoColor = "";

	public TileData(String plName, int x, int y) {
		this.plName = plName;
		this.x = x;
		this.y = y;
	}

	public TileData(int id, String type, String plName, int x, int y) {
		this.id = id;
		this.type = type;
		this.plName = plName;
		this.x = x;
		this.y = y;

	}

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getPlName() {
		return plName;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getInfo() {
		return info;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getInfoColor() {
		return infoColor;
	}

	public void setInfoColor(String infoColor) {
		this.infoColor = infoColor;
	}

}
