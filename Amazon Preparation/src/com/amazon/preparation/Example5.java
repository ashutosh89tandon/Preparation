package com.amazon.preparation;

import java.util.ArrayList;
import java.util.List;


public class Example5 
{
	public static void main(String args[])
	{
		System.out.println(findNonRepeatedString("you got beautiful eyes"));
	}
	
	public static String findNonRepeatedString(String str)
	{
		StringBuilder newStr=new StringBuilder(str);
		List<String> charList=new ArrayList<String>();
		charList.add(str.charAt(0)+"");
		int j=0;
		for(int i=1;i<str.length();i++)
		{
			j++;
			if(charList.contains(str.charAt(i)+""))
			{
				newStr.deleteCharAt(j);
				j--;
				charList.remove(str.charAt(i)+"");
			}
			else
			{
				charList.add(str.charAt(i)+"");
			}
			
			
		}
		
		return newStr.toString();
	}
}
