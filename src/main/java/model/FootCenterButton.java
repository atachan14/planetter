package model;

import jakarta.servlet.http.HttpServletRequest;

import dao.AccountDAO;
import dao.PlanetDAO;
import model.data.AccountData;
import model.display.MainCenterDisplay;
import model.display.MainInfoDisplay;

public class FootCenterButton {
	HttpServletRequest request;
	String acName;
	String plName;
	int x;
	int y;
	int direction;
	String footButton;
	String redirectUrl = "main";
	AccountData acd;

	public FootCenterButton(HttpServletRequest request) {
		this.request = request;

		acd = (AccountData) request.getSession().getAttribute("acd");
		this.acName = acd.getName();
		this.plName = acd.getPlanet();
		this.x = acd.getX();
		this.y = acd.getY();
		this.direction = acd.getDirection();
		this.footButton = request.getParameter("footButton");
	}

	public String exe() {
		switch (footButton) {
		case "左を向く":
			dcLeft();
			break;
		case "歩く":
			moveForward();
			break;
		case "右を向く":
			dcRight();
			break;

		case "コンタクト":
			contact();
			break;
		default:
			System.out.println("footCenter exe default");
			break;
		}
		return redirectUrl;
	}

	void dcLeft() {
		if (direction == 0) {
			direction = 3;
		} else {
			direction--;
		}
		AccountDAO.moveShaftIntAcd("direction", direction, acd);
	}

	void dcRight() {
		if (direction == 3) {
			direction = 0;
		} else {
			direction++;
		}
		AccountDAO.moveShaftIntAcd("direction", direction, acd);
	}

	void moveForward() {
		Pos pos = PlanetDAO.getSize(plName);
		int plxsize = pos.getx();
		int plysize = pos.gety();

		switch (direction) {
		case 0:
			y--;
			y = AroundInfoManager.edgeOverInt(y, plysize);
			AccountDAO.moveShaftIntAcd("y", y, acd);
			break;
		case 1:
			x--;
			x = AroundInfoManager.edgeOverInt(x, plxsize);
			AccountDAO.moveShaftIntAcd("x", x, acd);
			break;
		case 2:
			y++;
			y = AroundInfoManager.edgeOverInt(y, plysize);
			AccountDAO.moveShaftIntAcd("y", y, acd);
			break;
		case 3:
			x++;
			x = AroundInfoManager.edgeOverInt(x, plxsize);
			AccountDAO.moveShaftIntAcd("x", x, acd);
			break;
		default:
			System.out.println("moveForward Error :Switch(direction)");
			break;
		}
	}

	void contact() {
		MainInfoDisplay mainInfo = (MainInfoDisplay) request.getSession().getAttribute("mainInfo");
		AccountData v8acd = AccountDAO.getAll(mainInfo.getV8Info());

		MainCenterDisplay mainCenter = (MainCenterDisplay) request.getSession().getAttribute("mainCenter");
		mainCenter.setData(v8acd);
//		各criate数,kill数の取得 あとで実装
		redirectUrl = "contact";

	}
}
