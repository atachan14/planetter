package walk.main;

public class Menu {

	public void flow() {
		title();
		start();
	}

	public void title() {
		System.out.println();
		System.out.println("　　　walk");
		System.out.println();
	}

	public void start() {
		System.out.print("   　　	　1.new play 2.continue ＞");
		Night night;
		int input = new java.util.Scanner(System.in).nextInt();
		switch (input) {
		case 1:
			night = new Night();
			night.setUp(0);
			night.game();
			break;
		case 2:
			night = new Night();
			night.setUp(1);
			night.game();
			break;
		}

	}
}
