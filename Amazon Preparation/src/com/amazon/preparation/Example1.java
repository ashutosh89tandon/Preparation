package com.amazon.preparation;

import java.util.LinkedHashMap;

public class Example1
{

	public static void main(String a[])
	{
		Character c=findFirstNonRepeatable("amazom");
		System.out.println("Character :"+c);
	}
	
	public static Character findFirstNonRepeatable(String str)
	{
		LinkedHashMap<Character,Integer> map=new LinkedHashMap<Character,Integer>();
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' ')
			{
				continue;
			}
			
			if(map.get(str.charAt(i))==null)
			{
				map.put(str.charAt(i), 1);
			}
			else
			{
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}
		}
		
		for(Character c: map.keySet())
		{
			if(map.get(c)==1)
			{
				return c;
			}
		}
		
		return null;
	}
}
