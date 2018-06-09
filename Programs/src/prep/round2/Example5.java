package prep.round2;
import java.util.HashSet;
import java.util.Set;

public class Example5
{
	static String str="geeks";
	static Set<String> permutationList=new HashSet<String>();
	public static void main(String[] args) 
	{
		
		for(int i=1;i<= str.length();i++)
		{
			getPalindromePartition(i,0,"");
		}
		
		for(String str: permutationList)
		{
			System.out.println(str);
		}
	}
	
	private static void getPalindromePartition(int length,int index,String currentStr) 
	{
		System.out.println(length +","+index);
		if(index>=str.length() || index+length>str.length())
		{
			String lastOne=currentStr;
			for(int i=index;i<str.length();i++)
			{
				lastOne+=","+str.charAt(Math.abs(i));
			}
			permutationList.add(lastOne);
			return;
		}
		
		String newStr="";
		if(!currentStr.isEmpty())
		{
			newStr+=currentStr+",";
		}
		
		if(isPalindrome(str.substring(index, index+length)))
		{
			newStr+=str.substring(index, index+length);
			getPalindromePartition(length, index+length, newStr);
		}
		else
		{
			newStr+=str.substring(index, index+1);
			getPalindromePartition(length, index+1, newStr);
			
		}
	}

	public static boolean isPalindrome(String str)
	{
		for(int i=0,j=str.length()-1;i<str.length()/2;i++,j--)
		{
			if(str.charAt(i)!=str.charAt(j))
				return false;
		}
		return true;
	}
}
