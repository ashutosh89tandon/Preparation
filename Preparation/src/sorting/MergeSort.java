package sorting;

public class MergeSort {
	public static void main(String[] args) {
		int[] a={11,6,10,3,2};
		mergeSort(a,0,a.length-1);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"->");
	}

	private static void mergeSort(int[] a,int start,int end)
	{
		if(start<end)
		{
			int mid=(start+end)/2;
			mergeSort(a, start, mid);
			mergeSort(a,mid+1,end);
			merge(a,start,mid,end);
		}
	}

	private static void merge(int[] a, int start, int mid, int end) 
	{
		int n1=mid-start+1;
		int n2=end-mid;
		int[] left=new int[n1];
		int[] right=new int[n2];
		for(int i=0;i<n1;i++)
		{
			left[i]=a[start+i];
		}
		for(int i=0;i<n2;i++)
		{
			right[i]=a[mid+1+i];
		}
		
		int i=0, j=0,k=start;
		while(i<n1 && j<n2)
		{
			if(left[i]<=right[j])
				a[k++]=left[i++];
			else
				a[k++]=right[j++];
		}
		
		while(i<n1)
			a[k++]=left[i++];
		while(j<n2)
			a[k++]=right[j++];
		
	}
}
