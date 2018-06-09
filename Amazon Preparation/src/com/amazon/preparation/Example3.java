package com.amazon.preparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example3 
{
	public static void main(String args[])
	{
		int max=findLargestInKSwap(997689, 3);
		System.out.println("max : "+max);
	}
	
	public static  int findLargestInKSwap(int n, int k)
	{
		if(k==0)
			return n;
		
		Integer[] array=convertNumberToArray(n);
		int maximum=-1;
		for(int i=0;i<array.length-1;i++)
		{
			boolean swapped=false;
			int max=array[i];
			int index=-1;
			for(int j=i+1;j<array.length;j++)
			{
				if(max<array[j])
				{
					max=array[j];
					index=j;
					swapped=true;
				}
			}
			if(swapped)
			{
				int temp=array[i];
				array[i]=array[index];
				array[index]=temp;
				maximum=findLargestInKSwap(convertArraytoNumber(array), k-1);
				break;
			}
		}
		
		return maximum;
		
	}
	
	public static Integer[] convertNumberToArray(int n)
	{
		int number=n;
		List<Integer> list=new ArrayList<Integer>();
		for(;number>0;)
		{
			list.add(number%10);
			number=number/10;
		}
		Collections.reverse(list);
		System.out.println("Array : "+list);
		return list.toArray(new Integer[list.size()]);
	}
	
	public static int convertArraytoNumber(Integer[] array)
	{
		int n=array[0];
		
		for(int i=1;i<array.length;i++)
		{
			n=n*10+array[i];
		}
		
		System.out.println("NUMBER :"+n);
		return n;
	}
}
