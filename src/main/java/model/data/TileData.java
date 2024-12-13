package model.data;

public class TileData {
	int id;
	String type;
	int objectId;
	String plName;
	int x;
	int y;

	String info;

	public TileData(String plName, int x, int y) {
		this.plName = plName;
		this.x = x;
		this.y = y;
	}
	
	public TileData(int id, String type, int objectId, String plName, int x, int y) {
		this.id = id;
		this.type = type;
		this.objectId = objectId;
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

	public int getObjectId() {
		return objectId;
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

	public void setObjectId(int objectId) {
		this.objectId = objectId;
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

}
