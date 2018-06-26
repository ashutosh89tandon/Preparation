package com.prep.ds.array;

public class ArrayRotation 
{
	public static void main(String[] args) {
		
		int a[]={1,2,3,4,5,6,7,8};
		int pos=2;
		//method1(a,pos);
		//method2(a,pos);
		method3(a,pos);
		
		printArray(a);
	}

	private static void printArray(int[] a) {
		
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+",");
		}
	}

	/**Using reversal method
	 * @param a
	 * @param pos
	 */
	private static void method3(int[] a, int pos)
	{
		/*
		 * reverse a(0->pos-1)
		 * reverse a(pos->n-1)
		 * reverse a(0->n-1)
		 * */
		
		for(int i=0,j=pos-1;i<=(pos-1)/2;i++,j--)
		{
			int temp=a[j];
			a[j]=a[i];
			a[i]=temp;
		}
		//printArray(a);
		System.out.println();
		
		for(int i=pos,j=a.length-1;i<=(a.length-pos)/2;i++,j--)
		{
			int temp=a[j];
			a[j]=a[i];
			a[i]=temp;
		}
		//printArray(a);
		System.out.println();
		
		for(int i=0,j=a.length-1;i<=(a.length-1)/2;i++,j--)
		{
			int temp=a[j];
			a[j]=a[i];
			a[i]=temp;
		}
		//printArray(a);
		System.out.println();
	}

	/**By rotating one by one
	 * @param a
	 * @param pos
	 */
	private static void method2(int[] a, int pos) 
	{
		
		for(int i=1;i<=pos;i++)
		{
			int temp=a[0];
			for(int j=0;j<a.length-1;j++)
			{
				a[j]=a[j+1];
			}
			a[a.length-1]=temp;
		}
	}

	/**Method using temp Array
	 * @param a
	 * @param pos
	 */
	private static void method1(int[] a, int pos) {
		
		int temp[]=new int[pos];
		for(int i=0;i<pos;i++)
			temp[i]=a[i];
		
		for(int i=pos;i<a.length;i++)
			a[i-pos]=a[i];
		
		for(int i=a.length-pos, j=0;i<a.length;i++,j++)
		{
			a[i]=temp[j];
		}
		
	}
	
	
	
	
}
