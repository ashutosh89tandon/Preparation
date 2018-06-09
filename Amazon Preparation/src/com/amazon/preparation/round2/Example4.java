package com.amazon.preparation.round2;

import java.util.HashSet;
import java.util.Set;

public class Example4 
{
	public static Set<String> strList=new HashSet<String>();
	public static  String str="ABCD";
	public static void main(String[] args)
	{	
		for(int i=0;i<str.length();i++)
		{
			StringBuilder newStr=new StringBuilder(str);
			String startString=""+str.charAt(i);
			newStr.deleteCharAt(i);
			getPermutations(newStr,startString);
		}
		
		System.out.println(strList);
	}
	private static void getPermutations(StringBuilder newStr, String currentString)
	{
		if(currentString.length()==str.length())
		{
			strList.add(currentString);
			return;
		}
		
		
		for(int i=0;i<newStr.length();i++)
		{
			StringBuilder newStrCopy=new StringBuilder(newStr.toString());
			String currentStr=currentString+newStr.charAt(i);
			newStrCopy.deleteCharAt(i);
			getPermutations(newStrCopy,currentStr);
		}
	}
}
