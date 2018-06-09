package com.java.iterable;

public class Client 
{
	public static void main(String[] args) {
		MyCollection collection=new MyCollection();
		collection.add(1);
		collection.add(2);
		collection.add(3);
		collection.add(4);
		collection.add(5);
		collection.add(6);
		collection.add(7);
		collection.add(8);
		collection.add(9);
		System.out.println(collection.add(10));
		System.out.println(collection.add(11));
		Iterator iter=collection.getIterator();
		
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}
}
