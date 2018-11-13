package com.prep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class MaxSubseequence {
	private static int maxSum=-1;
	public static void main (String[] args) {
		try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in)))
		{
			int testcases=Integer.parseInt(reader.readLine());
			
			for(int t=1;t<=testcases;t++)
			{
				String firstLine=reader.readLine();
				String[] inputs=firstLine.split(" ");
				int arraySize=Integer.parseInt(inputs[0]);
				int k=Integer.parseInt(inputs[1]);
				String secondLine=reader.readLine();
				String stringArray[]=secondLine.split(" ");
				int array[]=new int[arraySize];
				for(int i=0;i<arraySize;i++)
					array[i]=Integer.parseInt(stringArray[i]);
				
				List<List<Integer>> lists=new ArrayList<>();
				for(int i=0;i<arraySize;i++)
				{
					lists.add(new ArrayList<>());
					lists.get(i).add(array[i]);
					getMaxSumRecursive(array,k-1,i,lists,k, array[i]);
				}
				System.out.println(maxSum);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void getMaxSumRecursive(int[] array, int currentK, int currentIndex, List<List<Integer>> lists, int k, int currentSum) 
	{
		
		if(currentIndex+1==array.length)
			return;
		int lastListIndex=lists.size()-1;
		ArrayList<Integer> list=new ArrayList<>(lists.get(lastListIndex));
		if(currentK==0)
		{
			
			if(currentSum>maxSum)
				maxSum=currentSum;
			return;
		}
		
		for(int i=currentIndex+1;i<array.length;i++)
		{
			
			if(list.size()==k)
			{
				if(currentSum>maxSum)
					maxSum=currentSum;
				continue;
			}
			if(list.get(list.size()-1)<=array[i]){
				ArrayList<Integer> templist=new ArrayList<>(lists.get(lastListIndex));
				templist.add(array[i]);
				List<List<Integer>> tempLists=new ArrayList<>(lists);
				tempLists.remove(lastListIndex);
				tempLists.add(templist);
				getMaxSumRecursive(array,currentK-1,i,tempLists, k,currentSum+array[i]);
			}
		}
		
		
	}

	
}