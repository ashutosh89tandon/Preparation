package com.amazon.preparation;

import java.util.HashSet;
import java.util.Set;

public class Example7 
{
	public static void main(String args[])
	{
		Set<String> list=new HashSet<String>();
		
		createSequence(list,12,10);
	}
	
	public static void createSequence(Set<String> sequenceList,int sum, int upperLimit)
	{
		for(int i=upperLimit;i>=1;i--)
		{
			String str=i+"";
			getString(i,sum,upperLimit,sequenceList,str);
		}
		
		System.out.println(sequenceList);
	}

	private static void getString(int currentSum, int expectedSum, int upperLimit,Set<String> sequenceList,String currentString) 
	{
		
		for(int i=1;i<=upperLimit;i++)
		{
			String str=new String(currentString);
			int sum=currentSum;
			if(sum+i==expectedSum)
			{
				str+=","+i;
				sequenceList.add(str);
				continue;
			}
			
			else if(sum+i<expectedSum)
			{
				sum+=i;
				str+=","+i;
				getString(sum, expectedSum, upperLimit, sequenceList, str);
				
			}
			
			else
			{
				continue;
			}
		}
	}
	
	
}
