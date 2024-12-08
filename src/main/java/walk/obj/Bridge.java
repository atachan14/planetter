package walk.obj;

public class Bridge extends Obj {

	public Bridge() {
		super();

		this.name = " 橋 ";
		this.nam = '橋';
		this.index = 220;
		
		this.hereMesse = "橋の上にいる";
		this.nextMesse = "橋だ";
	}

//	public static Obj generate() {
//		int x = new java.util.Random().nextInt(wpm.getMap().length);
//
//		Pos pos = new Pos(wpm.getMap().length / 2, x);
//		Bridge bridge = new Bridge(pos);
//		return bridge;
//	}

}
