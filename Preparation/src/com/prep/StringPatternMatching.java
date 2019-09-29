package com.prep;

public class StringPatternMatching {

	public static void main(String[] args) {
		String str1="AM?Z*";
		String str2="AMAZON";
		System.out.println("Is matched : " +isMatching(str1,str2));
	}

	private static boolean isMatching(String str1, String str2) {
		
		int m=str1.length();
		int n =str2.length();
		int i=0; 
		int j=0;
		while(i<m  && j<n)
		{
			char c1 =str1.charAt(i);
			char c2 = str2.charAt(j);
			if(c1=='*' )
			{
				i++;
				if(i==m)
					while(j<n)
						j++;
				else
					while(j<n && str1.charAt(i) != str2.charAt(j))
						j++;
			}
			else if(c1=='?')
			{
				i++;j++;
			}
			else if(c1 !=c2)
			{
				return false;
			}
			else
			{
				j++;
				i++;
			}
		}
		
		if((i<m && j==n) || (i==m  && j<n))
			return false;
			
		
		return true;
	}
}
