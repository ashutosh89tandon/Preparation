package com.prep.ds.heap;

public class NearlySortedArray 
{
	public static void main(String[] args) {
		int arr[] = {10, 9, 8, 7, 4, 70, 60, 50};
		int k=4;
		makeHeap(arr,k);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}

	private static void makeHeap(int[] arr, int k)
	{
		new HeapSortInPlace().heapSort(arr,k+1);
		BinaryHeap heap=new BinaryHeap(arr.length-k);
		for(int i=k+1;i<arr.length;i++)
			heap.insertKey(arr[i]);
		for(int i=k+1;i<arr.length;i++)
			arr[i]=heap.extractMin();
		
	}
}
