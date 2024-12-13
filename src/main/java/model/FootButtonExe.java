package model;

import dao.AccountDAO;
import dao.PlanetDAO;
import jakarta.servlet.http.HttpServletRequest;
import model.data.AccountData;

public class FootButtonExe {
	String acName;
	String plName;
	int x;
	int y;
	int direction;
	String footButton;

	public FootButtonExe(HttpServletRequest request) {
		AccountData acd = (AccountData) request.getSession().getAttribute("acd");
		this.acName = acd.getName();
		this.plName = acd.getPlanet();
		this.x = acd.getX();
		this.y = acd.getY();
		this.direction = acd.getDirection();
		this.footButton = request.getParameter("footButton");
	}

	public void exe() {
		switch (footButton) {
		case "左を向く":
			dcLeft();
			break;
		case "前に進む":
			moveForward();
			break;
		case "右を向く":
			dcRight();
			break;
		}
	}

	void dcLeft() {
		if (direction == 0) {
			direction = 3;
		} else {
			direction--;
		}
		AccountDAO.updateInt("direction", direction, acName);
	}

	void dcRight() {
		if (direction == 3) {
			direction = 0;
		} else {
			direction++;
		}
		AccountDAO.updateInt("direction", direction, acName);
	}

	void moveForward() {
		Pos pos = PlanetDAO.getSize(plName);
		int plxsize = pos.getx();
		int plysize = pos.gety();

		switch (direction) {
		case 0:
			y--;
			y = AroundInfoManager.edgeOverInt(y, plysize);
			AccountDAO.updateInt("y", y, acName);
			break;
		case 1:
			x--;
			x = AroundInfoManager.edgeOverInt(x, plxsize);
			AccountDAO.updateInt("x", x, acName);
			break;
		case 2:
			y++;
			y = AroundInfoManager.edgeOverInt(y, plysize);
			AccountDAO.updateInt("y", y, acName);
			break;
		case 3:
			x++;
			x = AroundInfoManager.edgeOverInt(x, plxsize);
			AccountDAO.updateInt("x", x, acName);
			break;
		default:
			System.out.println("moveForward Erroe :Switch(direction)");
			break;
		}
	}
}
