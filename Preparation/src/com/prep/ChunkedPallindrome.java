package com.prep;

import java.util.LinkedHashSet;
import java.util.Set;

public class ChunkedPallindrome 
{

	public static void main(String[] args) {
		String str="geeksforgeeks";
		
		for(String s: findChunkedPallindrome(str))
		{
			System.out.println(s);
		}
	}
	
	private static Set<String> findChunkedPallindrome(String str)
	{
		Set<String> set=new LinkedHashSet<String>();
		int setCount=0;
		for(int i=0,j=str.length()-1;i<str.length() && i<j;)
		{
			int count=1;
			while( i+count<=str.length() && !str.substring(i, i+count).equals(str.substring(j+1-count,j+1)))
			{
				//System.out.println("Inside while: "+str.substring(i, i+count)+"->"+str.substring(j+1-count));
				count++;
			}
			i+=count;
			j-=count;
			if(i>j)
				setCount++;
			else
				setCount+=2;
		}
		System.out.println(setCount);
		
		return set;
	}
}
