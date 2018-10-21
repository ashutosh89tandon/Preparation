package com.prep.ds.heap;

public class BinaryHeap 
{
	int MAX_CAPACITY=100;
	int[] array=new int[MAX_CAPACITY];
	int heapSize=0;
	public static void main(String[] args) {
		
		BinaryHeap h=new  BinaryHeap(11); 
	    h.insertKey(3); 
	    h.insertKey(2); 
	    h.deleteKey(1); 
	    h.insertKey(15); 
	    h.insertKey(5); 
	    h.insertKey(4); 
	    h.insertKey(45);
	    System.out.println(h.extractMin()); 
	    System.out.println(h.getMin()); 
	    h.decreaseKey(2, 1); 
	    System.out.println(h.getMin()); 
	}
	public BinaryHeap(int mAX_CAPACITY) {
		super();
		MAX_CAPACITY = mAX_CAPACITY;
		this.array = new int[MAX_CAPACITY];
	}
	
	 int parent(int i) { return (i-1)/2; } 
	  
	 int left(int i) { return (2*i + 1); } 
	 
	 int right(int i) { return (2*i + 2); } 
	
	 int getMin() { return array[0]; } 
	 
	 void MinHeapify(int i)
	 {
		int smallest=i;
		int left=2*i+1;
		int right=2*i+2;
		if(left<heapSize && array[left]<array[smallest])
			smallest=left;
		if(right<heapSize && array[right]<array[smallest])
			smallest=right;
		if(smallest!=i)
		{
			swap(smallest,i);
			MinHeapify(smallest);
		}
	 }
	 
	private void swap(int i, int j) {
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
	 int extractMin()
	 {
		 if(heapSize==0)
			 return -1;
		 else if(heapSize==1)
		 {
			 return array[--heapSize];
		 }
		 
		 int root=array[0];
		 array[0]=array[--heapSize];
		 MinHeapify(0);
		 return root;
		 
	 }
	 
	 void decreaseKey(int i, int new_val)
	 {
		 array[i]=new_val;
		 
		 while(parent(i)>=0 && array[i]<array[parent(i)])
		 {
			 swap(i, parent(i));
			 i=parent(i);
		 }
	 }
	 
	 void insertKey(int new_val)
	 {
		 if(heapSize==MAX_CAPACITY)
			 return;
		 heapSize++;
		 int i =heapSize-1;
		 array[i]=new_val;
		 
		 while(parent(i)>=0 && array[i]<array[parent(i)])
		 {
			 swap(i, parent(i));
			 i=parent(i);
		 }
	 }
	 
	 void deleteKey(int i)
	 {
		decreaseKey(i, -99999);
		extractMin();
	 }
	
}
