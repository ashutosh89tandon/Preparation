package mustdolist.arrays;

public class MaxSumInMatrix 
{
	public static void main(String[] args) {
		
		int a[][]= {{1, 2 ,3},{ 9, 8, 7},{4, 5, 6}};
		int maxSum=findMaxSum(a);
		System.out.println("Sum : "+maxSum);
		
		int b[][]= {{10 ,10 , 2,  0, 20 , 4},{ 1 , 0  ,0, 30 , 2 , 5},{0 ,10,  4,  0 , 2 , 0},{ 1 , 0 , 2 ,20,  0 , 4}};
		maxSum=findMaxSum(b);
		System.out.println("Sum : "+maxSum);
	}

	private static int findMaxSum(int[][] a)
	{
		int maxSum=0;
		int m=a.length;
		int n=a[0].length;
		for(int i=0;i<n;i++)
		{
			int j=i;
			int k=0;
			int sum=a[k][j];
			while(k+1<m)
			{
				if(j>0 && j<n-1)
				{
					if(a[k+1][j+1]> a[k+1][j] && a[k+1][j+1]>a[k+1][j-1])
						j=j+1;
					else if(a[k+1][j-1]> a[k+1][j] && a[k+1][j-1]>a[k+1][j+1])
						j=j-1;
				}
				else if(j>0)
				{ 
					
					if(a[k+1][j-1]> a[k+1][j])
						j=j-1;
				}
				else if(j<n-1)
				{
					if(a[k+1][j+1]> a[k+1][j])
						j=j+1;
				}
				k++;
				sum+=a[k][j];
			}
			
			if(sum>maxSum)
				maxSum=sum;
		}
		return maxSum;
	}
}
