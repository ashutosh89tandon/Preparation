package com.amazon.preparation.round2;

public class Example11 
{
	
	public static void main(String[] args) 
	{
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		root.right.left.right=new Node(8);
		
		System.out.println(getPath(root, 4, 5));
		System.out.println(getPath(root, 3, 4));
		System.out.println(getPath(root, 4, 6));
		System.out.println(getPath(root, 5, 8));
		
	}
	public static int getPath(Node root ,int n1, int n2)
	{
		int count=0;
		String str=getLength(root,n1,"");
		String str1=getLength(root,n2,"");
		
		System.out.println(str);
		System.out.println(str1);
		
		if(str.equals(""))
			return 0;
		if(str1.equals(""))
			return 0;
		
		str=str.substring(1, str.length());
		str1=str1.substring(1, str1.length());
		
		count=str.split("->").length-1+str1.split("->").length-1 - (2*commonPath(str,str1));
		
		return count;
		
	}
	
	private static int commonPath(String str, String str1) 
	{
		if(str1.length()<str.length())
		{
			String temp=str;
			str=str1;
			str1=temp;
		}
		int count=-1;
		String[] arr1=str.split("->");
		String[] arr2=str1.split("->");
		
		for(int i=0;i<arr1.length;i++)
		{
			if(arr1[i].equals(arr2[i]))
				count++;
		}
		
		return count;
	}
	private static String getLength(Node root, int n, String str) 
	{
		if(root==null)
			return "";
		if(root.data==n)
		{
			str=str+"->"+root.data;
			return str;
		}
		
		String newStr=getLength(root.left, n, str+"->"+root.data);
		if(newStr.equals("")) 
			newStr=getLength(root.right, n, str+"->"+root.data);
		
		return newStr;
	}
}
