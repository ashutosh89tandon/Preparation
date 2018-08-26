package designpattern.decorator;

public class Test {
	
	public static void main(String[] args) {
		
		Car car=new SportsCar(new LuxuryCar(new BasicCar()));
		car.assemble();
		
		car=new SportsCar(new BasicCar());
		car.assemble();
	}

}
