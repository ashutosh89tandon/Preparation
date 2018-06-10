package com.prep;

public class MinimumStepsArrayZero 
{
	public static void main(String[] args) {
		
		int a[]= {7,3,5,2,6};
		System.out.println("Count : "+getNumberOfSteps(0,a));
	}
	
	public static int getNumberOfSteps(int index , int a[])
	{
		if(index>=a.length)
			return 0;
		
		int steps=Math.abs(a[index]);
		int value=-1;
		if(a[index]<0)
			value=1;
		
		for(int i=1;i<=steps;i++)
			foo(index,value,a);
		System.out.println("Steps: "+steps);
		return steps+getNumberOfSteps(index+1,a);
	}
	
	public static void foo(int index, int value, int[] a)
	{
		for(int i=index;i<a.length;i++)
		{
			a[i]+=value;
		}
	}
}
