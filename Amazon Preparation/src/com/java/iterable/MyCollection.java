package com.java.iterable;

import java.util.Arrays;

public class MyCollection implements Collection {

	private static final int size=10;
	private int pos=0;
	private int[] collection=new int[size];
	
	public boolean add(int object)
	{
		if(pos==size)
		{
			return false;
		}
		else
		{
			collection[pos++]=object;
			return true;
		}
	}
	
	
	public Iterator getIterator() 
	{
		return new MyIterator(Arrays.copyOf(collection, pos));
	}

}
