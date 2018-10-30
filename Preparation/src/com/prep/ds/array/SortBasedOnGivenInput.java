package com.prep.ds.array;

public class SortBasedOnGivenInput 
{
	static int  index=0;
	public static void main(String[] args) {
		int a[]={10, 5, 3, 9, 2};
		int k=7;
		quickSort(a,0,a.length-1,k);
		printArray(a);
	}
	private static void quickSort(int[] a, int start, int end,int k) {

		if(start<end)
		{
			int partition=partition(a, start, end,k);
			quickSort(a, start, partition,k);
			quickSort(a, partition+1, end,k);
		}

	}

	private static int partition(int[] a, int start, int end,int k) {

		int pivot=Math.abs(a[end]-k);
		int left=start;
		int index=-1;
		while(left<end)
		{
			if(Math.abs(a[left]-k)>pivot)
			{
				swap(a, left, end);
				pivot=Math.abs(a[end]-k);
				index=left;
			}
			left++;
		}


		if(index==-1)
			index=end-1;
		else {
			for(int i=index;i<end-1;i++)
				if(Math.abs(a[i]-k)>Math.abs(a[i+1]-k))
				{
					index=i+1;
					swap(a,i+1,i);
				}
		}
		return index;
	}

	private static void swap(int a[],int i, int j)
	{
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	public static void printArray(int a[])
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"->");
	}
}
