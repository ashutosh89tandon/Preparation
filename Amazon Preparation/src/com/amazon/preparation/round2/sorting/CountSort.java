package com.amazon.preparation.round2.sorting;

public class CountSort 
{
	public static void main(String[] args) 
	{
		int a[]= {1, 4, 1, 2, 7, 5, 2,11,14,12,17,19,18};
		int range=20;
		countSort(a,range);
		//printArray(a);
	}
	
	private static void countSort(int[] a,int range)
	{
		int n=a.length;
		int count[]=new int[range];
		for(int i=0;i<n;i++)
		{
			count[a[i]]++;
		}
		
		printArray(count);
		for(int i=1;i<range;i++)
		{
			count[i]=count[i]+count[i-1];
		}
		printArray(count);
		
		int output[]=new int[n];
		int i=n-1;
		int j=range-1;
		while(i>=0)
		{
			while(count[j]-count[j-1]>0)
			{
				output[i]=j;
				count[j]--;
				i--;
			}
			j--;
		}
		
		printArray(output);
		
	}

	private static void printArray(int[] a) {
		int i=0;
		while(i<a.length)
		{
			System.out.print(a[i]+",");
			i++;
		}
		System.out.println();
	}
}
