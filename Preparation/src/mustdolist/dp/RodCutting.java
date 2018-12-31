package mustdolist.dp;

public class RodCutting
{
	public static void main(String[] args) {
		int arr[] = {3, 5, 8, 9, 10, 17, 17, 20}; 
		int n=arr.length;
		int value=findMaxValue(arr,n);
		System.out.println(value);
		
		value=findMaxValueDP(arr,n);
		System.out.println(value);
	}

	private static int findMaxValueDP(int[] arr, int n) {
		int val[]=new int [n+1];
		for(int i=1;i<=n;i++)
		{
			int max=0;
			for(int j=0;j<i;j++)
			{
				max=Math.max(max, arr[j]+val[i-1-j]);
			}
			val[i]=max;
		}
		
		return val[n];
		
	}

	private static int findMaxValue(int[] arr, int n) {
		if(n<=0)
			return 0;
		int max=0;
		for(int i=0;i<n;i++)
		{
			max=Math.max(max, arr[i]+findMaxValue(arr, n-1-i));
		}
		
		return max;
	}
}
