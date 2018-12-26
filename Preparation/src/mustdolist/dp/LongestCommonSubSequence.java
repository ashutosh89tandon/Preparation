package mustdolist.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCommonSubSequence 
{
	public static void main(String[] args) {
		
		String str="ABCDGH";
		String str1="AEDFHR";
		int length=findLongestCommonSubSequence(str,str1);
		System.out.println("length : "+length);
		
		str="AGGTAB";
		str1="GXTXAYB";
		length=findLongestCommonSubSequence(str,str1);
		System.out.println("length : "+length);
		
		str="ABCDGH";
		str1="AEDFHR";
		length=findLongestCommonSubSequenceDP(str,str1);
		System.out.println("length : "+length);
		
		str="AGGTAB";
		str1="GXTXAYB";
		length=findLongestCommonSubSequenceDP(str,str1);
		System.out.println("length : "+length);
	}

	private static int findLongestCommonSubSequenceDP(String str, String str1) {
		int L[][]=new int[str.length()+1][str1.length()+1];
		for(int i=0;i<str.length()+1;i++)
			for(int j=0;j<str1.length()+1;j++ )
			{
				if(i==0 || j==0)
					L[i][j]=0;
				else if(str.charAt(i-1)==str1.charAt(j-1))
					L[i][j]=L[i-1][j-1]+1;
				else
					L[i][j]=Math.max(L[i-1][j], L[i][j-1]);
			}
		
		return L[str.length()][str1.length()];
	}

	private static int findLongestCommonSubSequence(String str, String str1)
	{
		int length=0;
		Map<Character,List<Integer>> map=new HashMap<Character, List<Integer>>();
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(map.get(ch)==null)
				map.put(ch, new ArrayList<>());
			map.get(ch).add(i);
		}
		int prev=-1;
		for(int i=0;i<str1.length();i++)
		{
			char ch=str1.charAt(i);
			List<Integer> indexes=map.get(ch);
			if(indexes!=null && findIndex(indexes,prev)!=-1)
			{
				length++;
				prev=findIndex(indexes,prev);
			}
		}
		
		return length;
	}

	private static int findIndex(List<Integer> indexes, int prev) 
	{
		for(int i : indexes)
			if(i>prev)
				return i;
		return -1;
	}
	
	
}
