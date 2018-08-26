package designpattern.adapter;

public class BirdAdapter implements ToyDuck {

	Bird bird;
	public BirdAdapter(Bird bird) {
		super();
		this.bird = bird;
	}
	public void squeak() {
		bird.makeSound();
	}

}
