package com.prep.ds.array;

public class MaxNumberOf1InRow {
	
	public static void main(String[] args) {
		
		int arr[][]={{0,0,0,1},{0,0,0,0},{0,1,1,1},{1,1,1,1}};
		int index = findRowWithMax1s(arr);
		
		System.out.println(index);
	}

	private static int findRowWithMax1s(int[][] arr) {
		
		int row=-1;
		int maxIndex=arr[0].length;
		
		for(int i=arr[0].length-1;i>=0;i--)
		{
			if(arr[0][i]==1)
			{
				maxIndex--;
				continue;
			}
			else
				break;
		}
		
		if(maxIndex>-1)
		{
			row=0;
		}
		for(int i=1;i<arr.length;i++)
		{
			if(maxIndex==0) 
				break;
			if(arr[i][maxIndex]== 1)
			{
				int j=maxIndex-1 ;
				while(j>=0)
				{
					if(arr[i][j]==1)
					{
						j--;
					}
					else
					{
						j++;
						break;
					}
				}
				if(j==-1) j=0;
				if(j<maxIndex)
				{
					maxIndex=j;
					row=i;
				}
			}
		}
		
		return row;
	}
}
