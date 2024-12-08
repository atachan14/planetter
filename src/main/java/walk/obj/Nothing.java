package walk.obj;

import walk.maps.Pos;

public class Nothing extends Obj {

	public Nothing(Pos pos) {
		super(pos);
	}
	
	public Nothing() {
		this.name = " 無 ";
		this.nam = '　';
		this.index = 101;

		this.hereMesse = "なにもない";
		this.nextMesse = "なにもない";
	}

	public Nothing(int y, int x) {
		super(y, x);

		this.name = " 無 ";
		this.nam = '　';
		this.index = 101;

		this.hereMesse = "なにもない";
		this.nextMesse = "なにもない";
	}

}
