package model.tool;

import dao.PlanetDAO;
import model.Pos;
import model.data.PlanetData;

public class AroundPlanetsCriater {
	public static PlanetData[][] Exe(String plName) {
		
		PlanetData[][] aroundPlanets = new PlanetData[11][11];
		Pos here = PlanetDAO.plNameToPos(plName);
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				int x = (here.getx() - 5) + i;
				int y = (here.gety() - 5) + j;
				aroundPlanets[i][j] = PlanetDAO.posToAll(new Pos(x,y));
			}
		}
		return aroundPlanets;
	}
}
