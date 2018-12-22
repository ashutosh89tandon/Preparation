package com.designproblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThoughtWorksTest 
{
	public static void main(String[] args) 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			int t=Integer.parseInt(br.readLine());
			for(int i=0;i<t;i++)
			{
				String boxes=br.readLine();
				int numberOfChildren=Integer.parseInt(br.readLine());
				String[] array=boxes.split(" ");
				int numberOfBoxes=Integer.parseInt(array[0]);
				String boxArray[]=Arrays.copyOfRange(array, 1, array.length);
				
				if(numberOfBoxes<=0)
					System.out.println("NO");
				
				if(isSubsetSum(boxArray, boxArray.length, numberOfChildren))
					System.out.println("YES");
				else
					System.out.println("NO");
				
			}
			br.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	/*static boolean isSubsetSum(String set[], int n, int sum) 
	{ 
		if (sum == 0) 
			return true; 
		if (n == 0 && sum != 0) 
			return false; 
		
		if (Integer.parseInt(set[n-1]) > sum) 
			return isSubsetSum(set, n-1, sum); 
		return isSubsetSum(set, n-1, sum) ||  
				isSubsetSum(set, n-1, sum-Integer.parseInt(set[n-1])); 
	} */
	
	
	static boolean isSubsetSum(String set[],  
			int n, int sum) 
	{ 
		 
		boolean subset[][] =  
				new boolean[sum+1][n+1]; 

		
		for (int i = 0; i <= n; i++) 
			subset[0][i] = true; 

		
		for (int i = 1; i <= sum; i++) 
			subset[i][0] = false; 

		
		for (int i = 1; i <= sum; i++) 
		{ 
			for (int j = 1; j <= n; j++) 
			{ 
				subset[i][j] = subset[i][j-1]; 
				if (i >= Integer.parseInt(set[j-1])) 
					subset[i][j] = subset[i][j] ||  
					subset[i - Integer.parseInt(set[j-1])][j-1]; 
			} 
		} 

		return subset[sum][n]; 
	} 
	
	

}
