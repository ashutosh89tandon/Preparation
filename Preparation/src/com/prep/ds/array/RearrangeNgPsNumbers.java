package com.prep.ds.array;

public class RearrangeNgPsNumbers
{
	public static void main(String[] args)
	{
		int a[]= {-1, 2, -3, 4, 5, 6, -7, 8, 9};
		rearrangeNumbers(a);
		printArray(a);
	}

	private static void printArray(int[] a) {
		
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+",");
	}

	private static void rearrangeNumbers(int a[])
	{
		int i=-1;
		int n=a.length;
		for(int j=0;j<n;j++)
		{
			if(a[j]<0)
			{
				i++;
				swap(a,i,j);
			}
		}
		
		printArray(a);
		System.out.println();
		int pos=i+1,j=0;
		while(pos<n && j<pos && a[j]<0)
		{
			swap(a,j,pos);
			j+=2;
			pos++;
		}
		
	}

	private static void swap(int[] a, int i, int j) 
	{
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
