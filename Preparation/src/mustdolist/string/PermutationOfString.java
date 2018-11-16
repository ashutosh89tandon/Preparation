package mustdolist.string;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfString 
{
	static List<String> list=new ArrayList<>();
	public static void main(String[] args) 
	{
		String str="aabcd";
		for(int i=0;i<str.length();i++)
		{
			List<Integer>  indexList=new ArrayList<>();
			indexList.add(i);
			findPermutations(str,str.charAt(i)+"",indexList);
			
		}
		
		for(String s: list)
		{
			System.out.print(s+" ");
		}
	}
	private static void findPermutations(String str, String newStr, List<Integer> indexList) {
		if(newStr.length()==str.length())
		{
			list.add(newStr);
			return;
		}
		
		for(int i=0;i<str.length();i++)
		{
			if(indexList.contains(i))
				continue;
			String temp=newStr+str.charAt(i);
			List<Integer> tempIndexList=new ArrayList<>(indexList);
			tempIndexList.add(i);
			findPermutations(str,temp,tempIndexList);
		}
	}
}
