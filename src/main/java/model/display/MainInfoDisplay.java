package model.display;

import java.util.Map;

import jakarta.servlet.http.HttpSession;

import dao.AccountDAO;
import model.AroundInfoManager;
import model.data.AccountData;
import model.data.TileData;
import model.tool.dayCount;

public class MainInfoDisplay {
	AccountDAO acdao;
	private String acName;
	private String acKeepDay;
	private String plName;
	private String plKeepDay;

	private int stardust;
	private int stomach;

	private int x;
	private int y;
	private int direction;

	private String v7Info;
	private String v8Info;
	private String v9Info;

	private String v4Info;
	private TileData v5Tile;
	private String v6Info;

	public MainInfoDisplay(HttpSession session) {
		AccountData acd = (AccountData) session.getAttribute("acd");
		System.out.println(acd.getName());

		setupProperties((AccountData) session.getAttribute("acd"));
		setupAroundInfo();
		setupV5JSP();
	}

	void setupProperties(AccountData acd) {
		this.acName = acd.getName();
		this.plName = acd.getPlanet();
		this.stardust = acd.getStardust();
		this.stomach = acd.getStomach();
		this.x = acd.getX();
		this.y = acd.getY();
		this.direction = acd.getDirection();
		this.acKeepDay = dayCount.getKeepDay(acd.getDate());
	}

	void setupAroundInfo() {
		AroundInfoManager aim = new AroundInfoManager(x, y, direction, plName);
		Map<Integer, TileData> aroundTile = aim.getAroundTileMap();

		v7Info = aroundTile.get(7).getInfo();
		v8Info = aroundTile.get(8).getInfo();
		v9Info = aroundTile.get(9).getInfo();

		v4Info = aroundTile.get(4).getInfo();
		v5Tile = aroundTile.get(5);
		v6Info = aroundTile.get(6).getInfo();
	}

	void setupV5JSP() {
	
	}

	public String getAcName() {
		return acName;
	}

	public String getPlanet() {
		return plName;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDirection() {
		return direction;
	}

	public int getStardust() {
		return stardust;
	}

	public int getStomach() {
		return stomach;
	}

	public String getPlName() {
		return plName;
	}

	public String getV7Info() {
		return v7Info;
	}

	public String getV8Info() {
		return v8Info;
	}

	public String getV9Info() {
		return v9Info;
	}

	public String getV4Info() {
		return v4Info;
	}

	public TileData getV5Tile() {
		return v5Tile;
	}

	public String getV6Info() {
		return v6Info;
	}

	public String getAcKeepDay() {
		return acKeepDay;
	}

	public String getPlKeepDay() {
		return plKeepDay;
	}

	

}
