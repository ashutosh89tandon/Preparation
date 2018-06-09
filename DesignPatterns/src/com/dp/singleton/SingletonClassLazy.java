package com.dp.singleton;

import java.io.Serializable;

public class SingletonClassLazy implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static SingletonClassLazy obj=null;
	private SingletonClassLazy() {
		
	}
	
	public static SingletonClassLazy  getObject()
	{
		if(obj==null)
		{
			obj=new SingletonClassLazy();
		}
		return obj;
	}
	
	public void display()
	{
		System.out.println("Hello World");
	}
	
	protected Object readResolve()
	{
		return getObject();
		
	}
	
	
}
