package com.dp.abstractfactory;

public class AbstractFactory 
{	
	public static AbstractFactory getFactory(String input)
	{
		AbstractFactory factory=null;
		
		if(input.equals("Shape"))
		{
			factory=new ShapeFactory();
		}
		else if(input.equals("Color"))
		{
			factory=new ColorFactory();
		}
		return factory;
	}
	
	public Color getColor(String input)
	{
		return null;
	}
	
	public Shape getShape(String input)
	{
		return null;
	}
}
