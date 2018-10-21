package com.prep.ds.heap;

public class KSmallElements {

	public static void main(String[] args) {
		int array[]= {1, 23, 12, 9, 30, 2, 50};
		int k=4;
		sort(array,k);
	}

	private static void sort(int[] array, int k) {
		int temp[]=new int[k];
		for(int i=0;i<k;i++)
			temp[i]=array[i];
		
		for(int i=0;i<k;i++)
		{
			int min=temp[i];
			int index=i;
			for(int j=k;j<array.length-1;j++)
				if(min>array[j])
				{
					min=array[j];
					index=j;
				}
			
			swap(array,temp,index,i);
		}
		
		for(int i=0;i<k;i++)
			System.out.print(temp[i]+" ");
	}

	private static void swap(int[] array,int[] temp,int index, int i)
	{
		int temp1=array[index];
		array[index]=temp[i];
		temp[i]=temp1;
		
	}
}
