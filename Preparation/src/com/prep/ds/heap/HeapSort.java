package com.prep.ds.heap;

public class HeapSort 
{
	public static void main(String[] args) {
		BinaryHeap heap=new BinaryHeap(6);
		heap.insertKey(12);
		heap.insertKey(11);
		heap.insertKey(13);
		heap.insertKey(5);
		heap.insertKey(6);
		heap.insertKey(7);
		
		for(int i=0;i<heap.array.length;i++)
			System.out.println(heap.extractMin());
	}
}
