package com.dp.abstractfactory;

class ShapeFactory extends AbstractFactory {
	public Shape getShape(String input)
	{
		Shape obj=null;
		
		if(input.equals("Square"))
			obj=new Square();
		else
			obj=new Shape();
		
		return obj;
	}
}
