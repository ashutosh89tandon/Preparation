package com.dp.prototype;

public class Prototype 
{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Prototype(String name) {
		super();
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return new Prototype(name);
	}
	
	public void display()
	{
		System.out.println("Hi "+name);
	}
}
