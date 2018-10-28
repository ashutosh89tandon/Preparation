package sorting;

public class QuickSortMyVersion {
	
	public static void main(String[] args) {
		int a[]= {2,5,1,7,5};
		quickSort(a,0,a.length-1);
		
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"->");
	}

	private static void quickSort(int[] a, int start, int end) {
		
		if(start<end)
		{
			int partition=partition(a, start, end);
			quickSort(a, start, partition-1);
			quickSort(a, partition+1, end);
		}
		
	}

	private static int partition(int[] a, int start, int end) {
		
		int pivot=a[end];
		int left=0;
		int index=-1;
		while(left<end)
		{
			if(a[left]<=pivot)
				left++;
			else
			{
				int temp =a[left];
				a[left]=pivot;
				pivot=temp;
				index=left;
			}
		}
		if(index==-1)
			index=end;
		a[end]=pivot;
		return index;
	}
}
