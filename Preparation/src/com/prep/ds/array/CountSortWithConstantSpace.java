package com.prep.ds.array;

public class CountSortWithConstantSpace 
{
	public static void main(String[] args) {
		int arr[]={1,2,2,0,1,1,2,1,1};
		sortArray(arr,3);
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"->");
	}

	private static void sortArray(int[] arr, int range)
	{
		int n=arr.length;
		for(int i=0;i<n;i++)
		{
			arr[arr[i]%n]+=n;
		}
		
		for(int i=0;i<range;i++)
		{
			arr[i]=arr[i]/n;
			System.out.println(arr[i]);
		}
		
		int i=n-1;
		int j=range-1;
		while(i>=0)
		{
			int counter=arr[j];
			while(counter>0)
			{
				arr[i]=j;
				counter--;
				i--;
			}
			System.out.println("i="+i+" j="+j);
			j--;
		}
		
	}
}
