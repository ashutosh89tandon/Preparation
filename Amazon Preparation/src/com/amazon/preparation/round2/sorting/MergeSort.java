package com.amazon.preparation.round2.sorting;

public class MergeSort 
{
	public static void main(String[] args)
	{

		int a[]= {4,6,1,3,9,1};
		sort(a,0,a.length-1);
	}

	private static void printArray(int[] a) {
		int i=0;
		while(i<a.length)
		{
			System.out.print(a[i]+",");
			i++;
		}
	}
	
	private static void sort(int a[],int start,int end)
	{
		int m = (end+start)/2;
		if(start<end) 
		{
			sort(a,start, m);
			sort(a,m+1,end);
			merge(a,start,m,end);
			System.out.println();
		}
		
		
	}

	private static void merge(int[] a, int start, int m, int end) 
	{
		int n1=m-start+1;
		int n2=end-m;
		int left[]=new int[n1];
		int right[]=new int[n2];
		for(int i=0;i<n1;i++)
		{
			left[i]=a[start+i];
		}
		for(int i=0;i<n2;i++)
		{
			right[i]=a[m+1+i];
		}
		
		int k=start,i=0,j=0;
		while(i<n1 && j<n2)
		{
			if(left[i]<=right[j])
			{
				a[k++]=left[i++];
			}
			else
			{
				a[k++]=right[j++];
			}
		}
		
		while(i<n1)
			a[k++]=left[i++];
		
		while(j<n2)
			a[k++]=right[j++];
		
		printArray(a);
	}
}
