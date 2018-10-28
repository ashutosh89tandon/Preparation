package sorting;

public class QuickSortMyVersion {
	
	public static void main(String[] args) {
		int a[]= {6,3,9,1,6,7,3,4,9};
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
		int left=start;
		while(left<end)
		{
			if(a[left]>pivot)
			{
				int temp =a[left];
				a[left]=pivot;
				pivot=temp;
			}
			left++;
		}
		a[end]=pivot;
		return end;
	}
}
