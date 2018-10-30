package com.prep.ds.array;

public class SortArrayWith012 
{
	public static void main(String[] args) {
		int a[]={0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		sortArrayWith012(a);
		printArray(a);
	}

	private static void sortArrayWith012(int[] a) 
	{
		int lo=0;
		int mid=0;
		int hi=a.length-1;
		while(mid<=hi)
		{
			switch(a[mid])
			{
			case 0:
				int temp=a[lo];
				a[lo]=a[mid];
				a[mid]=temp;
				mid++;
				lo++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				int temp1=a[hi];
				a[hi]=a[mid];
				a[mid]=temp1;
				hi--;
			}
		}
	}
	
	public static void printArray(int a[])
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"->");
	}
}
