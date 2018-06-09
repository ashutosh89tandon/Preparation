package com.dp.factory;


public class Test {

	public static void main(String[] ar)
	{
		Color color= new Factory().getColor("GREEN");
		color.display();
	}
}
