package sorting;

public class QuickSort {
	public static int A[]={1,6,3,9,4,7};
	public static void quicksort(int right, int left)
	{
		if(right<=left)
			return;
		
		else
		{
			int pivot=A[right];
			int partition=getPartition(left, right, pivot);
			quicksort(left, partition-1);
			quicksort(partition+1, right);
			
		}
	}
	private static int getPartition(int left, int right, int pivot) {
		int leftPointer=left-1;
		int rightPointer=right;
		
		while(true)
		{
			while(A[++leftPointer]<pivot)
			{
				
			}
			
			while(rightPointer>0 && A[--rightPointer]>pivot )
			{
				
			}
			
			if(leftPointer>=rightPointer)
				break;
			else
			{
				int temp=leftPointer;
				leftPointer=rightPointer;
				rightPointer=temp;
				
			}
		}
		int temp=leftPointer;
		leftPointer=right;
		right=temp;
		
		
		return leftPointer;
	}
	
	public static void main(String a[])
	{
		quicksort(0, A.length-1);
		 for(int i=0;i<A.length;i++)
		 {
			 System.out.println("A["+i+"] : "+A[i]);
		 }
	}

}
