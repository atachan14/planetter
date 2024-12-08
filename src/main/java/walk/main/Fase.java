package walk.main;

public class Fase {
	Night night;

	public Fase(Night night) {
		this.night = night;
	}

	public void start() {
		System.out.println("--------------------");
		System.out.println();
		System.out.println();
		System.out.println("　目が覚めたら夜だった");
		System.out.println("　　おうちに帰らなきゃ");
		System.out.println();
		System.out.println();
		new java.util.Scanner(System.in).nextLine();
	}

	public static void walk() {
		System.out.println("--------------------");
		System.out.print("　now walking　　2.walk　＞");
		new java.util.Scanner(System.in).nextLine();
	}

	public void overDisplay() {
		System.out.println("---------------------");
		System.out.println(night.getTopByPos(night.p.getPos()).getHereMesse());
		System.out.println();
		System.out.println();
		System.out.println(night.getTopByPos(night.p.getNextPos()).getNextMesse());
		
		// searchOtherMesse();
		System.out.println();
		System.out.println();
	}

	public void underDisplay() {
		System.out.println("1.左を向く 2.前に進む 3.右を向く");
		int input = new java.util.Scanner(System.in).nextInt();
		switch (input) {
		case 1:
			night.p.dcLeft();
			break;
		case 2:
			night.p.moveForward();
			break;
		case 3:
			night.p.dcRight();
			break;
		}

	}
}