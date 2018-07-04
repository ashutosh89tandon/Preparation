package com.prep.ds.array;

public class MoveAllZeroesToEnd 
{
	public static void main(String[] args) {
		int a[]= {1, 2, 0, 0, 0, 3, 6};
		move(a);
		printArray(a);
	}

	private static void move(int[] a) 
	{
		int count=0;
		int n=a.length;
		for(int i=0;i<n;i++)
		{
			if(a[i]>0)
			{
				a[count++]=a[i];
			}
		}
		
		for(int i=count+1;i<n;i++)
			a[i]=0;
		
	}
	
	private static void printArray(int[] a) {
		
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+",");
	}
}
