package walk.maps;

import walk.main.Night;

public class MapTools {
	static Night night;

	public MapTools() {

	}

	public static void setNight(Night nightInst) {
		night = nightInst;
		System.out.println("setNight" + night.getMapSize());
	}

	public static void cheetMap() {
		int index = 0;
		int py = night.getPlayer().gety();
		int px = night.getPlayer().getx();
		int nexty = night.getPlayer().getNexty();
		int nextx = night.getPlayer().getNextx();

		for (int y = 0; y < night.getMap().length; y++) {
			for (int x = 0; x < night.getMap().length; x++) {

				index = night.getMap()[y][x].getTop().getIndex();

				if (py == y && px == x) {
					System.out.print("≪" + night.getMap()[y][x].getTop().getNam() + "≫");
					continue;
				}
				if (nexty == y && nextx == x) {
					System.out.print("＞" + night.getMap()[y][x].getTop().getNam() + "＜");
					continue;
				}

				if (index / 10 == 0) {
					System.out.print(" [00" + night.getMap()[y][x].getTop().getNam() + "] ");
				} else if (index / 100 == 0) {
					System.out.print(" [0" + night.getMap()[y][x].getTop().getNam() + "] ");
				} else {
					System.out.print(" [" + night.getMap()[y][x].getTop().getNam() + "] ");
				}
			}
			System.out.println();
		}
		System.out.println("-----------------------------");
	}

	public static int edgeOverExe(int check) {
		if (check > night.getMap().length - 1)
			check = 0;
		if (check < 0)
			check = night.getMap().length - 1;
		return check;
	}
}
