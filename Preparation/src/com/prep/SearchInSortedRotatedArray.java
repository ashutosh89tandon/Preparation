package com.prep;

public class SearchInSortedRotatedArray 
{
	public static void main(String[] args) {
		
		int[] a={3,4,5,1,2};
		searchInSortedRotatedArray(a,2);
	}
	
	private static void searchInSortedRotatedArray(int[] a,int key)
	{
		int index=search(a,0,a.length-1,key);
		
		if(index==-1)
			System.out.println("Not found");
		else
			System.out.println("Found");
	}

	private static int search(int[] a, int l, int h, int key) 
	{
		if(l>h)
			return -1;
		
		int mid=(l+h)/2;
		if(a[mid]==key)return mid;
		
		if(a[l]<=a[mid])
		{
			if(key>a[l] && key<a[mid])
				return search(a,l,mid-1,key);
			return search(a,mid+1,h,key);
		}
		
		if(key>a[mid] && key<=a[h])
			return search(a, mid+1, h, key);
		
		return search(a,l,mid-1,key);
		
	}
}
