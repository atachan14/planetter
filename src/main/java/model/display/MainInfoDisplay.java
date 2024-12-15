package model.display;

import java.util.Map;

import jakarta.servlet.http.HttpSession;

import dao.AccountDAO;
import model.AroundInfoManager;
import model.data.AccountData;
import model.data.TileData;
import model.tool.Color;
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

	private String v7InfoColor;
	private String v8InfoColor;
	private String v9InfoColor;

	private String v4InfoColor;
	private String v6InfoColor;

	private String centerButton;
	private String v8Name;

	public MainInfoDisplay(HttpSession session) {

		setupProperties((AccountData) session.getAttribute("acd"));
		setupAroundInfo();
		setupCenterButton();
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

		v7InfoColor = aroundTile.get(7).getInfoColor();
		v8InfoColor = aroundTile.get(8).getInfoColor();
		v9InfoColor = aroundTile.get(9).getInfoColor();
		v4InfoColor = aroundTile.get(4).getInfoColor();
		v6InfoColor = aroundTile.get(6).getInfoColor();
	}

	void setupCenterButton() {
		String contact = Color.getPlayer();
		if (v8InfoColor.equals(contact)) {
			centerButton = "コンタクト";
		} else {
			centerButton = "歩く";
		}
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

	public String getV7InfoColor() {
		return v7InfoColor;
	}

	public String getV8InfoColor() {
		return v8InfoColor;
	}

	public String getV9InfoColor() {
		return v9InfoColor;
	}

	public String getV4InfoColor() {
		return v4InfoColor;
	}

	public String getV6InfoColor() {
		return v6InfoColor;
	}

	public String getCenterButton() {
		return centerButton;
	}

	public String getV8Name() {
		return v8Name;
	}

}
