package com.amazon.preparation;

public class Example6 
{
	public static void main(String args[])
	{
		System.out.println(getNonAdjacentString("heena"));
	}
	
	public static String getNonAdjacentString(String str)
	{
		StringBuilder newStr=new StringBuilder();
		newStr.append(str.charAt(0)+"");
		char[] charArray=str.toCharArray();
		for(int k=1;k<str.length();k++)
		{
			if(charArray[k-1]!=charArray[k])
				newStr.append(charArray[k]+"");
			else
			{   char uniqueChar=charArray[k];
				for(int i=k+1;i<str.length();i++)
				{
					if(charArray[i]!=charArray[k])
					{
						char temp=charArray[i];
						charArray[i]=charArray[k];
						charArray[k]=temp;
						break;
					}
					
				}
				
				if(uniqueChar==charArray[k])
					return "Not Possible";
				
				else
					newStr.append(charArray[k]+"");
			}
		}
		
		return newStr.toString();
	}
}
