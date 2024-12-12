package model.display;

import jakarta.servlet.http.HttpSession;

public class MainCenterDisplay {
		String type;
	public MainCenterDisplay(HttpSession session) {
		MainInfoDisplay mainInfo = (MainInfoDisplay) session.getAttribute("mainInfo");
		type = mainInfo.getV5Info();
	}

	
}
