package com.amazon.preparation.round2.sorting;

public class InsertionSort 
{
	public static void main(String[] args) {
		int a[]= {4,6,1,3,9,1};
		sort(a);
		int i=0;
		while(i<a.length)
		{
			System.out.println(a[i]);
			i++;
		}
		
	}
	public static  void sort(int a[])
	{
		for(int i=1;i<a.length;i++)
		{
			int temp=a[i];
			int j=i-1;
			
			while(j>=0 && a[j]>temp)
			{
				a[j+1]=a[j];
				j--;
			}
			
			a[j+1]=temp;
			
		}
		
		
		
	}
}
