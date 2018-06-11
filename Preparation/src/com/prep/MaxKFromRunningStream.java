package com.prep;

public class MaxKFromRunningStream 
{
	private static int length=0;
	private static int max=100;
	public static void main(String[] args) {
		int a[]=new int[max];
		addElement(a, 10);
		addElement(a, 20);
		addElement(a, 15);
		addElement(a, 30);
		
		for(int i=0;i<length;i++)
		{
			System.out.println(a[i]+",");
		}
		
	}

	private static void buildMaxHeap(int[] a) 
	{
		for(int i=length-1;i>=0;i--)
		{
			heapify(a,i);
		}
		
	}

	private static void heapify(int[] a, int i) 
	{
		int left= (2*i)+1;
		int right= (2*i)+2;
		int large=i;
		if(left<length && a[large]<a[left])
			large=left;
		 if(right<length && a[large]<a[right])
		{
			large=right;
		}
		
		if(large!=i)
		{
			int temp=a[i];
			a[i]=a[large];
			a[large]=temp;
			heapify(a,large);
		}
	}
	
	private static void addElement(int[] a, int value)
	{
		if(length+1>max)
		{
			System.out.println("Cannot add");
			return;
		}
		
		length++;
		a[length-1]=value;
		buildMaxHeap(a);
	}
	
	
	
}
