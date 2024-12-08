package walk.obj;

public class Dog extends Obj{
	
	public Dog() {
		this.name = " 犬 ";
		this.nam = '犬';
		this.index = 310;

		this.hereMesse = "";
		this.nextMesse = "犬だ！逃げろ！";
	}
	
	public void effectHere() {
		night.p.dcLeft();
		night.p.dcLeft();
		night.p.moveForward();
		night.p.moveForward();

		
	}
}
