package model.data;

public class CraftData {
	int id;
	int destiny;
	String crName;
	int sd;
	int rimitDay;

	public CraftData(int id, int destiny, String ugName, int sd) {
		this.id = id;
		this.destiny = destiny;
		this.crName = ugName;
		this.sd = sd;

	}

	public CraftData(int id, int destiny, String ugName, int sd, int rimitDay) {
		this.id = id;
		this.destiny = destiny;
		this.crName = ugName;
		this.sd = sd;
		this.rimitDay = rimitDay;
	}

	public int getId() {
		return id;
	}

	public int getDestiny() {
		return destiny;
	}

	public String getCrName() {
		return crName;
	}

	public int getSd() {
		return sd;
	}

}
