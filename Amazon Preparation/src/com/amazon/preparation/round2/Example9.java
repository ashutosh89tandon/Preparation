package com.amazon.preparation.round2;

public class Example9 
{
	public static void main(String[] args) 
	{
		int arr[]= {2,3,4,1,4,5};
		for(int i=1;i<arr.length;i++)
		{
			int lSum=getSum(arr,0,i-1);
			int RSum=getSum(arr,i+1,arr.length-1);
			
			if(lSum-RSum==0)
			{
				System.out.println(arr[i]);
				return;
			}
		}
	}

	private static int getSum(int arr[], int i, int j)
	{
		int sum=0;
		for(;i<=j;i++)
		{
			sum+=arr[i];
		}
		
		return sum;
	}
}
