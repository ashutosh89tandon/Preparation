package com.prep.ds.array;

public class SearchInSortedRotatedArray 
{
	public static void main(String[] args) {
		
		int a[]={4,5,1,2,3};
		int key=2;
		boolean found = search(a,0,a.length-1,key);
		System.out.println("Found :"+found);
		
	}

	private static boolean search(int[] a, int l, int h,int key)
	{

		if(l<h)
		{
			int mid=(l+h)/2;
			if(a[mid]==key)
				return true;
			
			if(a[mid]>a[l])
			{
				if(key<a[mid])
					return search(a,l,mid-1,key);
				else
					return search(a,mid+1,h,key);
			}
			
			if(a[mid]<a[h] && key>=a[mid] && key<=a[h])
				return search(a,mid+1,h,key);
			
			return search(a,l,mid-1,key);
		}
		else 
			return false;
	}
	
	
}
