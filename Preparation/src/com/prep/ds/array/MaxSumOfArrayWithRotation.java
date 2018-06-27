package com.prep.ds.array;

public class MaxSumOfArrayWithRotation
{
	public static void main(String[] args) {
		
		int a[]={8, 3, 1, 2};
		System.out.println("Max Sum is: "+maxSum(a));
	}
	
	public static int maxSum(int[] a)
	{
		int maxSum=0;
		int currentSum=0;
		
		for(int i=0;i<a.length;i++)
		{
			currentSum+=a[i]*i;
		}
		maxSum=currentSum;
		
		for(int j=1;j<a.length;j++)
		{
			currentSum=0;
			int temp=a[0];
			for(int i=1;i<a.length;i++)
			{
				currentSum+=(a[i]*(i-1));
				a[i-1]=a[i];
			}
			a[a.length-1]=temp;
			currentSum+=(temp*(a.length-1));
			
			if(currentSum>maxSum)
				maxSum=currentSum;
		}
		
		return maxSum;
	}
}
