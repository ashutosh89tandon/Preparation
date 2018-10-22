package com.prep.ds.array;

public class SmallestAndSecondSmallest {
	
	public static void main(String[] args)
	{
		int a[]= {1,6,2,7,4,9};
		findSmallestAndSecondSmallest(a);
	}

	private static void findSmallestAndSecondSmallest(int[] a) {
		
		int smallest=999, second=999;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<smallest)
			{
				second=smallest;
				smallest=a[i];
			}
			else if(a[i]<second)
			{
				second=a[i];
			}
		}
		
		System.out.println("Smallest : "+smallest+" Second : "+second);
	}
}
