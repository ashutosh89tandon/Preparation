package com.prep;

public class FindNumberInArrayWithDiff1 
{
	public static void main(String[] args) {
		
		int key=6;
		int a[]={3,4,5,6,7,8,9,10};
		boolean found=findNumber(a,key);
		System.out.println(found);
	}

	private static boolean findNumber(int[] a,int key) {
		
		if(key<a[0] || key>a[a.length-1])
			return false;
		
		if(key!=a[key-a[0]])
			return false;
		
		return true;
	}
}
