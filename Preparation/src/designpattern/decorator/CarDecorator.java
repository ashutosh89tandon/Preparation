package designpattern.decorator;

public class CarDecorator implements Car{

	protected Car car;

	public CarDecorator(Car car) {
		super();
		this.car = car;
	}
	
	public void assemble()
	{
		car.assemble();
	}
}
