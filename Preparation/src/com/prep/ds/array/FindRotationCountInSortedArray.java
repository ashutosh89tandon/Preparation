package com.prep.ds.array;

public class FindRotationCountInSortedArray 
{
	public static void main(String[] args) {
		int a[]={15, 18, 2, 3, 6, 12};
		System.out.println("Rotation count is :"+findRotationCount(a));
	}

	private static int findRotationCount(int[] a) 
	{
		int min=a[0];
		int index=0;
		for(int i=1;i<a.length;i++)
		{
			if(a[i]<min)
			{
				min=a[i];
				index=i;
			}
		}
		
		return index;
	}
}
