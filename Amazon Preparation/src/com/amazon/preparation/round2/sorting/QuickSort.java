package com.amazon.preparation.round2.sorting;

public class QuickSort 
{
	public static void main(String[] args) 
	{
		int a[]= {10,80,30,90,40,50,70};
		quickSort(a,0,a.length-1);
		printArray(a);
		
	}
	
	private static void quickSort(int[] a, int low, int high) 
	{
		if(low<high)
		{
			int p=partition(a, low, high);
			System.out.println();
			quickSort(a, low, p-1);
			quickSort(a,p+1,high);
		}
	}

	private static int partition(int[] a, int low, int high)
	{
		int i=low-1;
		int pivot=a[high];
		
		for(int j=low;j<high;j++)
		{
			if(a[j]<=pivot)
			{
				i++;
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}

		int temp=a[i+1];
		a[i+1]=a[high];
		a[high]=temp;

		printArray(a);
		return i+1;
	}

	private static void printArray(int[] a) {
		int i=0;
		while(i<a.length)
		{
			System.out.print(a[i]+",");
			i++;
		}
	}
	
}
