package mustdolist.dp;

public class EditDistanceForStrings 
{
	public static void main(String[] args) {
		String str1="sunday";
		String str2="saturday";
		int length=findMinimumEditDistance(str1,str2,str1.length(),str2.length());
		System.out.println(length);
		
		length=findMinimumEditDistanceDP(str1,str2,str1.length(),str2.length());
		System.out.println(length);
	}

	private static int findMinimumEditDistanceDP(String str1, String str2, int m, int n) {
		
		int L[][]=new int[m+1][n+1];
		 for (int i=0; i<=m; i++) 
		    { 
		        for (int j=0; j<=n; j++) 
		        { 
		           
		            if (i==0) 
		                L[i][j] = j; 
		            else if (j==0) 
		                L[i][j] = i;
		            else if (str1.charAt(i-1) == str2.charAt(j-1)) 
		                L[i][j] = L[i-1][j-1]; 
		            else
		                L[i][j] = 1 + findMin(L[i][j-1],
		                                   L[i-1][j], 
		                                   L[i-1][j-1]);
		        } 
		    } 
		return L[m][n];
	}

	private static int findMinimumEditDistance(String str1, String str2, int m, int n) {
		if(m==0)
			return n;
		
		if(n==0)
			return m;
		
		if(str1.charAt(m-1)==str2.charAt(n-1))
			return findMinimumEditDistance(str1, str2, m-1, n-1);
		
		return 1+findMin(findMinimumEditDistance(str1, str2, m-1, n-1),
				findMinimumEditDistance(str1, str2, m-1, n),
				findMinimumEditDistance(str1, str2, m, n-1));
		
	}

	private static int findMin(int a, int b,int c) {
		// TODO Auto-generated method stub
		return Math.min(Math.min(a, b), c);
	}
}
