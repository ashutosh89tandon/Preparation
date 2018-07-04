package com.prep.ds.array;

public class MinimumSwapsToBringKElements 
{
	public static void main(String[] args) {
		int a[]= {2, 1, 5, 6, 3};
		int key=3;
		int num=findMinSwaps(a,key,0);
		System.out.println("Swaps :"+num);
	}

	private static int findMinSwaps(int[] a, int key,int index) 
	{
		int n=a.length;
		for(int i=index;i<n;i++)
		{
		  if(a[i]>key)
		  {
			  int ind=i;
			  for(int j=i+1;j<n;j++)
			  {
				  if(a[j]<=key)
				  {
					  ind=j;
					  break;
				  }
			  }
			  swap(a,i,ind);
			  return 1+findMinSwaps(a, key, ind+1);
		  }
		}
		
		return 0;
	}
	
	private static void swap(int[] a, int i, int j) 
	{
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	private static void printArray(int[] a) {
		
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+",");
	}
}
