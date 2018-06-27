package com.prep.ds.array;

public class FindMinElementInSortedRotatedArray
{
	public static void main(String[] args) {
		int a[]={5, 6, 1, 2, 3, 4};
		
		System.out.println("Min element index : "+findMinimumElement(a,0,a.length-1));
	}

	private static int findMinimumElement(int[] a,int l, int h) 
	{
		if(l<=h)
		{
			
			int mid=(l+h)/2;
			
			if(a[mid]>=a[l] && a[mid]>a[mid+1])
				return mid+1;
			
			else if(a[mid]<=a[l] && (mid==l || a[mid]<a[mid-1]))
				return mid;
			
			else if(a[mid]<a[h])
			{
				return findMinimumElement(a, l, mid-1);
			}
			
		}
		return -1;
	}
	
	
}
