package com.dp.singleton;

public class Test1 {

	public static void main(String[] ar)
	{
		SingletonClass obj=SingletonClass.getObject();
		obj.display();
		
		SingletonClassLazy obj1=SingletonClassLazy.getObject();
		obj1.display();
	}
}
