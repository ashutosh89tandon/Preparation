package designpattern.adapter;

public class Test {
	public static void main(String[] args) {
		ToyDuck plasticTuyDuck=new PlasticToyDuck();
		plasticTuyDuck.squeak();
		
		Bird bird=new Sparrow();
		ToyDuck realBird=new BirdAdapter(bird);
		realBird.squeak();
	}
}
