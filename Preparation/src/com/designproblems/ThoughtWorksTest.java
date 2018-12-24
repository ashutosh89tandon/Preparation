package com.designproblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
				if(numberOfBoxes<=0)
					System.out.println("NO");
				
				if(isSumAvailable(array, numberOfChildren))
					System.out.println("YES");
				else
					System.out.println("NO");
				
			}
			br.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	
	/*static boolean isSumAvailable(String boxArray[], int sum) 
	{ 
		int n=boxArray.length;
		boolean subset[][] =  new boolean[sum+1][n+1]; 
		for (int i = 0; i <= n; i++) 
			subset[0][i] = true; 
		for (int i = 1; i <= sum; i++) 
			subset[i][0] = false; 
		for (int i = 1; i <= sum; i++) 
		{ 
			for (int j = 2; j <= n; j++) 
			{ 
				subset[i][j] = subset[i][j-1]; 
				if (i >= Integer.parseInt(boxArray[j-1])) 
					subset[i][j] = subset[i][j] ||  
					subset[i - Integer.parseInt(boxArray[j-1])][j-1]; 
			} 
		} 
		return subset[sum][n]; 
	}*/
	
	static boolean isSumAvailable(String boxArray[], int sum) 
	{ 
		int bit=1;
		for(int i=1;i<boxArray.length;i++)
		{
			int arrValue=Integer.parseInt(boxArray[i]);
			bit=bit|(bit<<arrValue);
		}
		
		int bitArray[]=getBitArrayFromDecimal(bit);
		
		if(bitArray[sum]==1)
			return true;
		
		return false;
	}

	private static int[] getBitArrayFromDecimal(int bit) {
		int bitArray[]=new int[10000];
		int bitOutput[]=new int[10000];
		int length=0;
		while(bit>0)
		{
			int rem=bit%2;
			bitOutput[length++]=rem;
			bit/=2;
		}
		
		for(int i=length-1,j=0;i>=0;i--,j++)
		{
			bitArray[j]=bitOutput[i];
		}
		
		return bitArray;
	}
}
