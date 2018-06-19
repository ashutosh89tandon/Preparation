package com.prep;

public class NthStairMWays
{
	public static void main(String[] args) 
	{
		int n=4;
		int m=2;
		int totalNumberOfWays=findTotalWays(n+1,m);
		System.out.println(totalNumberOfWays);
	}

	private static int findTotalWays(int n,int m) 
	{
		if(n<=1)
			return n;
		
		int steps=0;
		for(int i=1;i<=m && i<=n;i++)
		{
			steps+=findTotalWays(n-i, m);
		}
		
		return steps;
	}
}
