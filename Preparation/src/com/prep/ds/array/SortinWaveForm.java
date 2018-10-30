package com.prep.ds.array;

import sorting.QuickSortMyVersion;

public class SortinWaveForm 
{
	public static void main(String[] args) {
		int a[]={10, 5, 6, 3, 2, 20, 100, 80};
		sortInWaveForm(a);
	}

	private static void sortInWaveForm(int[] a) {
		QuickSortMyVersion.quickSort(a, 0, a.length-1);
		printArray(a);
		for(int i=0;i<a.length-1;i=i+2)
		{
			int temp=a[i];
			a[i]=a[i+1];
			a[i+1]=temp;
		}
		System.out.println();
		printArray(a);
	}
	
	public static void printArray(int a[])
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"->");
	}
}
