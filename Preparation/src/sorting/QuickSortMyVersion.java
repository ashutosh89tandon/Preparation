package sorting;

public class QuickSortMyVersion {
	
	public static void main(String[] args) {
		int a[]= {6,4,2,8,7,8,9,1,23,7,6};
		quickSort(a,0,a.length-1);
		
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"->");
	}

	private static void quickSort(int[] a, int start, int end) {
		
		if(start<end)
		{
			int partition=partition(a, start, end);
			quickSort(a, start, partition);
			quickSort(a, partition+1, end);
		}
		
	}

	private static int partition(int[] a, int start, int end) {
		
		int pivot=a[end];
		int left=start;
		int index=-1;
		while(left<end)
		{
			if(a[left]>pivot)
			{
				swap(a, left, end);
				pivot=a[end];
				index=left;
			}
			left++;
		}
		
		
		if(index==-1)
			index=end-1;
		else {
			for(int i=index;i<end-1;i++)
				if(a[i]>a[i+1])
				{
					index=i+1;
					swap(a,i+1,i);
				}
		}
		a[end]=pivot;
		return index;
	}
	
	private static void swap(int a[],int i, int j)
	{
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
