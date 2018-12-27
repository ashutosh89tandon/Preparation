package mustdolist.dp;

public class SubsetSumProblem {
	public static void main(String[] args) {
		int set[] = {3, 34, 4, 12, 5, 2};
		boolean exists=findSubset(set,set.length,14);
		System.out.println(exists);
		
		exists=findSubsetDP(set,set.length,14);
		System.out.println(exists);
	}

	private static boolean findSubset(int[] set, int n, int sum) {
		if(sum==0)
			return true;
		if(n==0 && sum>0)
			return false;
		
		if(set[n-1]>sum)
			return findSubset(set, n-1, sum);
		
		return findSubset(set, n-1, sum)|| findSubset(set, n-1, sum-set[n-1]);
	}
	
	private static boolean findSubsetDP(int[] set, int n, int sum) {
		boolean L[][]=new boolean[sum+1][n+1];
		
		for(int i=0;i<=sum;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0)
					L[i][j]=true;
				else if(j==0)
					L[i][j]=false;
				else
				{
					if(j-1>=0 && i-set[j-1]>=0)
						L[i][j]=L[i][j-1] || L[i-set[j-1]][j-1] ;
					else if(j-1>=0)
						L[i][j]= L[i][j-1];
				}
			}
		}
		
		return L[sum][n];
	}
}
