package com.prep.ds.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FrequencySorting 
{
	static class DataHolder
	{
		int count;
		int data;
		List<Integer> indexes= new ArrayList<>();
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + data;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DataHolder other = (DataHolder) obj;
			if (data != other.data)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "DataHolder [count=" + count + ", data=" + data + ", indexes=" + indexes + "]";
		}
		
		
		
	}
	public static void main(String[] args) {
		
		int a[] = {2,5, 2, 6, -1, 9999999, 5, 8, 8, 8}; 
		List<DataHolder> data=getSortedData(a); 
		int i=0;
		for(DataHolder dh :  data)
		{
			while(!dh.indexes.isEmpty())
			{
				a[i++]=dh.data;
				dh.indexes.remove(0);
			}
		}
		printArray(a);
	}
	
	private static List<DataHolder> getSortedData(int[] a)
	{
		Comparator<DataHolder> comp=(d1,d2)->{
			int data=0;
			if(d2.count<d1.count)
				return -1;
			if(d2.count>d1.count)
				return 1;
			return data;
		};
		
		List<DataHolder> data=new ArrayList<>();
		
		for(int i=0;i<a.length;i++)
		{
			DataHolder dh=new DataHolder();
			dh.data=a[i];
			dh=getKey(dh,data);
			if(data.contains(dh))
			{
				dh.indexes.add(i);
				dh.count++;
				data.remove(dh);
			}
			else
			{
				dh.count=1;
				dh.indexes.add(i);
			}
			data.add(dh);
		}
		
		List<DataHolder> list=new ArrayList<>(data);
		Collections.sort(list,comp);
		return list;
	}

	private static DataHolder getKey(DataHolder dh, List<DataHolder> data) {
		for(DataHolder dholder: data)
			if(dholder.equals(dh))
			{
				return dholder;
			}
		
		return dh;
	}
	
	public static void printArray(int a[])
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"->");
	}
}
