package com.prep;

public class NthStairTotalWays
{
	public static void main(String[] args) 
	{
		int n=1;
		int totalNumberOfWays=findTotalWays(n+1);
		System.out.println(totalNumberOfWays);
	}

	private static int findTotalWays(int n) 
	{
		if(n<=1)
			return n;
		
		int steps=findTotalWays(n-1)+findTotalWays(n-2);
		
		return steps;
	}
}
