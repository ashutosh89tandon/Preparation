package com.prep.ds.array;

import sorting.MergeSort;

public class AlternateSorting 
{
	public static void main(String[] args) {
		int[] a={1, 6, 9, 4, 3, 7, 8, 2};
		MergeSort.mergeSort(a,0,a.length-1);
		printArray(a);
		System.out.println();
		alternateSort(a);
	}
	
	private static void alternateSort(int[] a) {
		int temp[]=new int[a.length];
		int j=0;
		for(int i=0;i<a.length;i++)
		{
			if(i%2==0)
			{
				temp[i]=a[a.length-1-j];
				j++;
			}
			else
			{
				temp[i]=a[j-1];
			}
		}
		
		printArray(temp);
	}

	public static void printArray(int a[])
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"->");
	}
}
