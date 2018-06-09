package com.amazon.preparation.round2;

public class Example8 
{
	public static void main(String[] args) 
	{
		String str="GeeksforGeeks";
		char[] array=str.toCharArray();
		
		for(int i=0;i<str.length()/2;i++)
		{
			char temp=array[i];
			array[i]=array[array.length-1-i];
			array[array.length-1-i]=temp;
		}
		str=new String(array);
		
		System.out.println(str);
	}
}
