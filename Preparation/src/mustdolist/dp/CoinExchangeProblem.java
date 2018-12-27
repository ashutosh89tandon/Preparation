package mustdolist.dp;

public class CoinExchangeProblem 
{
	public static void main(String[] args) {
		
		 int arr[] = {1, 2, 3};
		 int sum=4;
		 int findWays=findWaysRec(arr,sum,arr.length);
		 System.out.println(findWays);
		 
		 findWays=findWaysDP(arr,sum,arr.length);
		 System.out.println(findWays);
	}

	private static int findWaysDP(int[] arr, int sum, int n) 
	{
		int L[][]=new int[n][sum+1];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<=sum;j++)
			{
				if(j==0)
				{
					L[i][j]=1;
					continue;
				}
				if(j-arr[i]>=0)
					L[i][j]+=L[i][j-arr[i]];
				if(i>0)
					L[i][j]+=L[i-1][j];
			}
		
		return L[n-1][sum];
	}

	private static int findWaysRec(int[] arr, int sum, int n) 
	{
		if(n>0 && sum==0)
			return 1;
		if(n==0 && sum>0)
			return 0;
		
		if(sum<0)
			return 0;
		
		return findWaysRec(arr, sum, n-1)+findWaysRec(arr, sum-arr[n-1], n);
	}
}
