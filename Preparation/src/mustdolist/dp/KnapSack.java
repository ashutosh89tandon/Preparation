package mustdolist.dp;

public class KnapSack
{
	public static void main(String[] args) {
		int val[] = {60, 100, 120}; 
		int wt[] = {10, 20, 30}; 
		int  W = 50; 
		int n=val.length;
		int length=findMaxvalRecursive(val,wt,W,n);
		System.out.println("length :"+length);
		
		length=findMaxvalDP(val,wt,W,n);
		System.out.println("length :"+length);
	}

	private static int findMaxvalDP(int[] val, int[] wt, int W, int n) { 
		   int i, w; 
		   int K[][]=new int[n+1][W+1]; 
		  
		   // Build table K[][] in bottom up manner 
		   for (i = 0; i <= n; i++) 
		   { 
		       for (w = 0; w <= W; w++) 
		       { 
		           if (i==0 || w==0) 
		               K[i][w] = 0; 
		           else if (wt[i-1] <= w) 
		                 K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]); 
		           else
		                 K[i][w] = K[i-1][w]; 
		       } 
		   } 
		  
		   return K[n][W]; 
}

	private static int findMaxvalRecursive(int[] val, int[] wt, int w, int n) {
		if(w<=0 || n==0)
			return 0;
		
		if(wt[n-1]>w)
			return findMaxvalRecursive(val, wt, w, n-1);
		else
			return Math.max(findMaxvalRecursive(val, wt, w, n-1), val[n-1]+findMaxvalRecursive(val, wt, w-wt[n-1], n-1));
	}
}
