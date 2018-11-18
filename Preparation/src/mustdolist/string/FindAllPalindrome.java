package mustdolist.string;

import java.util.ArrayList;
import java.util.List;

public class FindAllPalindrome {

	static List<String> list=new ArrayList<>();
	public static void main(String[] args) {
		String str="abbaeae";
		fetchAllStrings(str);
		for(String s : list)
			System.out.println(s);
	}
	private static void fetchAllStrings(String str) {
		for(int i=1;i<str.length();i++)
		{
			String temp=str.charAt(i)+"";
			int j=i-1;
			
			while(j>=0)
			{
				temp=str.charAt(j)+temp;
				if(isPalindrome(temp))
				{
					list.add(temp);
				}
				j--;
			}
		}
	}
	private static boolean isPalindrome(String str) {
		
		for(int i=0,j=str.length()-1;i<str.length()/2;i++,j--)
		{
			if(str.charAt(i)!=str.charAt(j))
				return false;
		}
		return true;
	}
}
