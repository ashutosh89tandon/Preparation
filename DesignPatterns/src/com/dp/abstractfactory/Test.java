package com.dp.abstractfactory;


public class Test {

	public static void main(String[] ar)
	{
		AbstractFactory factory=AbstractFactory.getFactory("Shape");
		Shape shape=factory.getShape("Square");
		shape.display();
		
		factory=AbstractFactory.getFactory("Color");
		Color color=factory.getColor("GREEN");
		color.display();
	}
}
