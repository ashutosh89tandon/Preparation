package com.dp.factory;

public class Factory 
{
	public Color getColor(String input)
	{
		Color obj=null;
		
		if(input.equals("BLUE"))
			obj=new Blue();
		
		else if(input.equals("GREEN"))
			obj=new Green();
		
		else
			obj=new Color();
		
		return obj;
	}
}
