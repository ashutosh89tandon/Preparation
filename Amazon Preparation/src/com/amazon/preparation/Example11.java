package com.amazon.preparation;

public class Example11 
{
	public static void main(String[] args) {
		
		int n=3;
		char[][] array= {{'j','e','e'},{'k','e','e'},{'o','j','e'}};
		int count=0; 
		String searchString="jee";
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n ;j++)
			{
				System.out.println("Start Point: "+array[i][j]);
				count+=searchVerticalUp(array,i,j,n-1,"",searchString,searchString.length());
				count+=searchVerticalDown(array,i,j,n-1,"",searchString,searchString.length());
				count+=searchHorizontalLeft(array,i,j,n-1,"",searchString,searchString.length());
				count+=searchHorizontalRight(array,i,j,n-1,"",searchString,searchString.length());
				count+=D1Down(array,i,j,n-1,"",searchString,searchString.length());
				count+=D2Up(array,i,j,n-1,"",searchString,searchString.length());
				count+=D1Up(array,i,j,n-1,"",searchString,searchString.length());
				count+=D2Down(array,i,j,n-1,"",searchString,searchString.length());
			}
		}
		
		System.out.println("Count : "+count);
		
	}
	
	public static int searchVerticalUp(char[][] array,int i, int j,int n,String str,String searchString, int searchLeft)
	{
		int count=0;
		
		String newstr=str;
		for(int counter=searchLeft;counter>0;counter--)
		{
			if(i>n ||i<0 || j>n || j<0)
				return count;
			
			newstr+=array[i][j];
			i--;
			
		}
		
		if(newstr.equals(searchString))
		{
			System.out.println("Matched : "+newstr);
			return 1;
		}
		
		return count;
		
	}
	
	public static int searchVerticalDown(char[][] array,int i, int j,int n,String str,String searchString, int searchLeft)
	{
		int count=0;
		
		String newstr=str;
		for(int counter=searchLeft;counter>0;counter--)
		{
			if(i>n ||i<0 || j>n || j<0)
				return count;
			
			newstr+=array[i][j];
			i++;
			
		}
		
		if(newstr.equals(searchString))
		{
			System.out.println("Matched : "+newstr);
			return 1;
		}
		
		return count;
		
	}
	
	public static int searchHorizontalRight(char[][] array,int i, int j,int n,String str,String searchString, int searchLeft)
	{
		int count=0;
		
		String newstr=str;
		for(int counter=searchLeft;counter>0;counter--)
		{
			if(i>n ||i<0 || j>n || j<0)
				return count;
			
			newstr+=array[i][j];
			j++;
			
		}
		
		if(newstr.equals(searchString))
		{
			System.out.println("Matched : "+newstr);
			return 1;
		}
		
		
		return count;
		
	}
	
	public static int searchHorizontalLeft(char[][] array,int i, int j,int n,String str,String searchString, int searchLeft)
	{
		int count=0;
		
		String newstr=str;
		for(int counter=searchLeft;counter>0;counter--)
		{
			if(i>n ||i<0 || j>n || j<0)
				return count;
			
			newstr+=array[i][j];
			j--;
			
		}
		
		if(newstr.equals(searchString))
			{

			System.out.println("Matched : "+newstr);
			return 1;
		
			}
		
		return count;
		
	}
	
	public static int D1Up(char[][] array,int i, int j,int n,String str,String searchString, int searchLeft)
	{
		int count=0;
		
		String newstr=str;
		for(int counter=searchLeft;counter>0;counter--)
		{
			if(i>n ||i<0 || j>n || j<0)
				return count;
			
			newstr+=array[i][j];
			i--;
			j--;
			
		}
		
		if(newstr.equals(searchString))
			{

			System.out.println("Matched : "+newstr);
			return 1;
		
			}
		
		return count;
		
	}
	
	public static int D1Down(char[][] array,int i, int j,int n,String str,String searchString, int searchLeft)
	{
		int count=0;
		
		String newstr=str;
		for(int counter=searchLeft;counter>0;counter--)
		{
			if(i>n ||i<0 || j>n || j<0)
				return count;
			
			newstr+=array[i][j];
			i++;
			j++;
		}
		
		if(newstr.equals(searchString))
			{

			System.out.println("Matched : "+newstr);
			return 1;
		
			}
		
		return count;
		
	}
	
	public static int D2Up(char[][] array,int i, int j,int n,String str,String searchString, int searchLeft)
	{
		int count=0;
		
		String newstr=str;
		for(int counter=searchLeft;counter>0;counter--)
		{
			if(i>n ||i<0 || j>n || j<0)
				return count;
			
			newstr+=array[i][j];
			i=i-1;
			j=j+1;
			
		}
		
		if(newstr.equals(searchString))
			{

			System.out.println("Matched : "+newstr);
			return 1;
		
			}
		
		return count;
		
	}
	
	public static int D2Down(char[][] array,int i, int j,int n,String str,String searchString, int searchLeft)
	{
		int count=0;
		
		String newstr=str;
		for(int counter=searchLeft;counter>0;counter--)
		{
			if(i>n ||i<0 || j>n || j<0)
				return count;
			
			newstr+=array[i][j];
			j=j-1;
			i=i+1;
			
		}
		
		if(newstr.equals(searchString))
			{

			System.out.println("Matched : "+newstr);
			return 1;
		
			}
		
		return count;
		
	}
	}
