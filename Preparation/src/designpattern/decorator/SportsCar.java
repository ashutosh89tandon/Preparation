package designpattern.decorator;

public class SportsCar extends CarDecorator {

	public SportsCar(Car car) {
		super(car);
		// TODO Auto-generated constructor stub
	}	
	
	public void assemble()
	{
		super.assemble();
		System.out.println("Adding Sports car features.");
	}

}