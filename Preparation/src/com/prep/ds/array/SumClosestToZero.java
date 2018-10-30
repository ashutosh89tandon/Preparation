package com.prep.ds.array;

import sorting.QuickSortMyVersion;

public class SumClosestToZero 
{
	public static void main(String[] args) {
		int arr[] = {1, 60, -10, 70, -80, 85}; 
		findNumbers(arr);
	}

	private static void findNumbers(int[] arr) 
	{
		QuickSortMyVersion.quickSort(arr, 0, arr.length-1);
		printArray(arr);
		int minSum=99999;
		int n1=0,n2=0;
		for(int l=0,r=arr.length-1;l<r;)
		{
			int sum=arr[l]+arr[r];
			if(Math.abs(minSum)>Math.abs(sum))
			{
				minSum=Math.abs(sum);
				n1=arr[l];
				n2=arr[r];
			}
			if(sum<0)
				l++;
			else
				r--;
			
		}
		System.out.println("Min Sum : "+minSum+ " for "+ n1+" "+n2);
	}
	
	public static void printArray(int a[])
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"->");
		System.out.println();
	}
}
