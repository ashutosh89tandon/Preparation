package com.amazon.preparation;

public class Example2 
{
	public static void main(String ar[])
	{
		String str1="amazon";
		String str2="amzano";
		String str3="zao";
		boolean isAnagram=isAnagram( str1,  str2);
		
		boolean isSubstringAnagram=isSubstringAnagram(str1, str3);
		
		System.out.println("Is anagram : "+isAnagram);
		
		System.out.println("Is substring anagram : "+isSubstringAnagram);
	}
	
	private static boolean isSubstringAnagram(String str1, String str3)
	{
		
		for(int i=0;i<str1.length()-str3.length()+1;i++)
		{
			boolean isAnagram=isAnagram(str1.substring(i,i+str3.length()),str3);
			
			if(isAnagram)
				return true;
		}
		
		return false;
	}

	public static boolean isAnagram(String str1, String str2)
	{
		str1=str1.replaceAll(" ", "");
		str2=str2.replaceAll(" ", "");
		StringBuilder str2B=new StringBuilder(str2);
		
		for(int i=0;i<str1.length();i++)
		{
			if(str2B.indexOf(str1.charAt(i)+"")!=-1)
			{
				str2B.deleteCharAt(str2B.indexOf(str1.charAt(i)+""));
			}
		}
		
		if(str2B.length()==0)
			return true;
		else
			return false;
	}
	
	
}
