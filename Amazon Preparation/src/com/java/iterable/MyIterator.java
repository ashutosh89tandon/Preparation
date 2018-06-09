package com.java.iterable;

public class MyIterator implements Iterator {

	private int[] collection;
	private int counter=0;
	
	public int[] getCollection() {
		return collection;
	}

	public void setCollection(int[] collection) {
		this.collection = collection;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public MyIterator(int[] collection) {
		super();
		this.collection = collection;
	}

	@Override
	public boolean hasNext() {
		return counter<collection.length;
	}

	@Override
	public Object next() 
	{
		return collection[counter++];
	}
}
