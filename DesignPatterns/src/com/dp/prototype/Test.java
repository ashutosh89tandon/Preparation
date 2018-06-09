package com.dp.prototype;


public class Test 
{
	public static void main(String[] ar)
	{
		Prototype obj=new Prototype("Haris");
		obj.display();
		
		try {
			Prototype obj2=(Prototype) obj.clone();
			obj2.setName("Mayank");
			obj2.display();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
