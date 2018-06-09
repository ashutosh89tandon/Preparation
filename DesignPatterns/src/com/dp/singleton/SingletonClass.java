package com.dp.singleton;

public class SingletonClass
{
	static SingletonClass obj=new SingletonClass();
	private SingletonClass() {
		
	}
	
	public static SingletonClass  getObject()
	{
		return obj;
	}
	
	public void display()
	{
		System.out.println("Hello World");
	}
}
