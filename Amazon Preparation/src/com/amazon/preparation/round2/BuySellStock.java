package com.amazon.preparation.round2;

import java.util.ArrayList;
import java.util.List;

public class BuySellStock 
{
	public static void main(String[] args)
	{
		int price[] = {100, 180, 260, 310, 40, 535, 695};
		List<Interval> intervals=getBuySellStocks(price);
		for(Interval interval: intervals)
		{
			System.out.println(interval);
		}
	}

	private static List<Interval> getBuySellStocks(int[] price) {
		List<Interval> stocks=new ArrayList<Interval>();
		for(int i=1;i<price.length;i++)
		{
			int sum=0;
			int start=0;
			while( i<price.length && price[i]<price[i-1] )
				i++;
			
			if(i>=price.length)
				break;
			
			while(i<price.length && price[i]>=price[i-1])
			{
				if(sum==0)
				{
					start=i-1;
				}
				sum+=price[i]-price[i-1];
				i++;
			}
			
			if(sum>0)
			 stocks.add(new Interval(start,i-1,sum));
		}
		
		return stocks;
	}
	
	
}

class Interval
{
	int start;
	int end;
	int sum;
	public Interval(int start, int end, int sum) {
		super();
		this.start = start;
		this.end = end;
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + ", sum=" + sum + "]";
	}
	
}
