package com.prep.ds.array;

public class MaximumDifference 
{
	public static void main(String args[])
	{
		int[] array= {1,3,8,2,4,6};
		printMaxDiff(array);
	}

	private static void printMaxDiff(int[] array) 
	{
		int n=array.length;
		int maxRight=array[n-1];
		Integer maxDiff=null;

		for(int i=n-2;i>=0;i--)
		{
			if(array[i]>maxRight)
				maxRight=array[i];
			else
			{
				if(maxDiff==null)
					maxDiff=maxRight-array[i];
				else
				{
					int diff=maxRight-array[i];
					if(diff>maxDiff)
						maxDiff=diff;
				}
			}
		}
		
		System.out.println("Difference : "+maxDiff);
	}
}
