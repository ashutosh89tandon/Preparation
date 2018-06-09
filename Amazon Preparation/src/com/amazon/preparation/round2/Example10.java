package com.amazon.preparation.round2;

public class Example10
{
	public static void main(String[] args) {
		
		int arr[]=  {2, 7, 6, 1, 4, 5};
		int k=4;
		int maxValue=getMaxDistribution(arr,k);
		System.out.println(maxValue);
	}

	private static int getMaxDistribution(int[] arr, int k) {
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			
			int localSum=arr[i];
			int localValue=0;
			if(arr[i]%k==0)
			{
				localValue=arr[i]/k;
			}
			for(int j=i+1;j<arr.length;j++)
			{
				if((localSum+arr[j])%k==0 && ((localSum+arr[j])/k)>localValue)
				{
					localValue=(localSum+arr[j])/k;
				}
				
				localSum+=arr[j];
			}
			
			if(sum<localValue)
				sum=localValue;
		}
		
		return sum;
	}
}
