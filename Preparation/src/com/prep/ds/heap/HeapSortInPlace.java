package com.prep.ds.heap;

public class HeapSortInPlace {
	
	public HeapSortInPlace()
	{
	}
	public static void main(String[] args) {
		int arr[] = {10, 9, 8, 7, 4, 70, 60, 50};
		new HeapSortInPlace().heapSort(arr,arr.length);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");	
	}
	
	public void heapSort(int arr[],int n)
	{
		//make heap
		for(int i=n/2-1;i>=0;i--)
			MinHeapify(arr, n, i);

		//make heap
		for(int i=n-1;i>=0;i--)
		{
			swap(arr, 0, i);
			MinHeapify(arr,i, 0);
		}
		
	}
	
	public void MinHeapify(int[]arr,int heapSize, int i)
	 {
		int max=i;
		int left=2*i+1;
		int right=2*i+2;
		if(left<heapSize && arr[left]>arr[max])
			max=left;
		if(right<heapSize && arr[right]>arr[max])
			max=right;
		if(max!=i)
		{
			swap(arr,max,i);
			MinHeapify(arr, heapSize, max);
		}
	 }

	public  void swap(int[] arr, int max, int i) {
		int temp=arr[max];
		arr[max]=arr[i];
		arr[i]=temp;
		
	}
}
