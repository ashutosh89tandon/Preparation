package com.amazon.preparation.round2.sorting;

public class HeapSort 
{
	public static void main(String[] args) {
	
		int a[]= {10,80,30,90,40,50,70};
		heapSort(a);
		printArray(a);
		
	}
	
	private static void heapSort(int[] a) 
	{
		int n=a.length;
		for(int i=0;i<n; i++)
		{
			heapify(a,n,i);
		}
		
		 for (int i=n-1; i>=0; i--)
		 {
			 // Move current root to end
			 int temp = a[0];
			 a[0] = a[i];
			 a[i] = temp;

			 // call max heapify on the reduced heap
			 heapify(a, i, 0);
		 }
	}

	private static void heapify(int[] a, int n, int i)
	{
		int max=i;
		int l=i*2+1;
		int r=i*2+2;
		
		if(l<n && a[l]>a[max])
			max=l;
		
		if(r<n && a[r]>a[max] )
			max=r;
		
		if(max!=i)
		{
			int swap = a[i];
            a[i] = a[max];
            a[max] = swap;
			heapify(a,n,max);
		}
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
