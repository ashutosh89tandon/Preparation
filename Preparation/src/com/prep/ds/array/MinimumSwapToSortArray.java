package com.prep.ds.array;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import sorting.QuickSortMyVersion;

public class MinimumSwapToSortArray 
{
	public static void main(String[] args) {
		int a[]={4, 5, 2, 1, 3};
		int k=numberOfSwaps(a);
		System.out.println("number of swaps : "+k);
	}

	private static int numberOfSwaps(int[] a) {
		Map<Integer,Integer> posMap=new LinkedHashMap<>();
		populateMap(posMap,a);
		QuickSortMyVersion.quickSort(a, 0, a.length-1);
		Map<Integer,Integer> sortedPosMap=new LinkedHashMap<>();
		populateMap(sortedPosMap, a);
		
		int k=getSwaps(posMap,sortedPosMap,a);
			
		return k;
	}

	private static int getSwaps(Map<Integer, Integer> posMap, Map<Integer, Integer> sortedPosMap,int a[]) {
		int k =0;
		int i=0;
		for(Entry<Integer, Integer> entry : posMap.entrySet())
		{
			if(entry.getValue()!=sortedPosMap.get(entry.getKey()))
			{
				k++;
				int oldElement=entry.getKey();
				int oldIndex=posMap.get(a[i]);
				posMap.put(a[i],i);
				posMap.put(oldElement, oldIndex);
			}
			i++;
		}
		
		return k;
	}

	private static void populateMap(Map<Integer, Integer> posMap, int[] a) 
	{
		for(int i=0;i<a.length;i++)
			posMap.put(a[i], i);
	}
}
