package com.prep.ds.array;

public class FindSumInRotatedSortedArray 
{
	public static void main(String[] args) 
	{
		int a[]={4,5,1,2,3};
		int sum=10;
		System.out.println("Found : "+findSum(a,sum));
	}

	private static boolean findSum(int[] a, int sum) 
	{
		int l=-1,r=-1;
		for(int i=0;i<a.length-1;i++)
		{
			if(a[i]>a[i+1])
			{
				r=i;
				l=i+1;
				break;
			}
		}
		
		while(l!=r)
		{
			if(a[l]+a[r]==sum)
				return true;
			
			else if(a[l]+a[r]<sum)
			{
				if(l+1==a.length)
					l=0;
				else
					l++;
			}
			else
			{
				if(r-1<0)
					r=a.length-1;
				else
					r--;
			}
		}
		
		return false;
	}
}
