package com.prep;

public class RainTrapWater 
{
	public static void main(String[] args) {
		
		int a[]= {2,0,2};
		int water=findTrappedWater(a);
		System.out.println(water);
		
	}

	private static int findTrappedWater(int[] a)
	{
		int result=0;
		int left_max=0, right_max=0;
		int lo=0, hi=a.length-1;
		while(lo<=hi)
		{
			if(a[lo]<a[hi]) 
			{
				if(a[lo]>left_max)
					left_max=a[lo];
				else
				{
					result+=left_max-a[lo];
					lo++;
				}
			}
			else
			{
				if(a[hi]>right_max)
					right_max=a[hi];
				else
				{
					result+=right_max-a[hi];
					hi--;
				}
			}
		}
		
		return result;
	}
	
}
