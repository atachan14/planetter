package model.display;

import java.util.Map;

import dao.AccountDAO;
import jakarta.servlet.http.HttpSession;
import model.PosInfoManager;
import model.data.AccountData;

public class MainInfoDisplay {
	AccountDAO acdao;
	private String acName;
	private String acKeepDate;
	private String plName;
	private String plKeepDate;

	private int stardust;
	private int stomach;

	private int x;
	private int y;
	private int direction;

	private String v7Info;
	private String v8Info;
	private String v9Info;

	private String v4Info;
	private String v5Info;
	private String v6Info;

	public MainInfoDisplay(HttpSession session) {
		AccountData acd = (AccountData) session.getAttribute("acd");
		System.out.println(acd.getName());

		setupProperties((AccountData) session.getAttribute("acd"));
		setupAroundInfo();

	}

	void setupProperties(AccountData acd) {
		this.acName = acd.getName();
		this.plName = acd.getPlanet();
		this.stardust = acd.getStardust();
		this.stomach = acd.getStomach();
		this.x = acd.getX();
		this.y = acd.getY();
		this.direction = acd.getDirection();
	}

	void setupAroundInfo() {

		PosInfoManager pm = new PosInfoManager(x, y, direction, plName);
		Map<Integer, String> aroundInfo = pm.getAroundInfoMap();

		v7Info = aroundInfo.get(7);
		v8Info = aroundInfo.get(8);
		v9Info = aroundInfo.get(9);

		v4Info = aroundInfo.get(4);
		v5Info = aroundInfo.get(5);
		v6Info = aroundInfo.get(6);
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

	public String getV5Info() {
		return v5Info;
	}

	public String getV6Info() {
		return v6Info;
	}

}
