package com.amazon.preparation.round2;

import java.util.ArrayList;
import java.util.List;

public class Example12 
{
	static String str ="nitin";
	public static void main(String[] args) 
	{
		System.out.println(isPalindrome("nitin"));
	    
	    List<String> list=new ArrayList<String>();
	}
	
    public static boolean isPalindrome(String str)
	{
		for(int i=0, j=str.length()-1;i<str.length()/2;i++,j--)
		{
			if(str.charAt(i)!=str.charAt(j))
			return false;
		}
		return true;
	}
}	
