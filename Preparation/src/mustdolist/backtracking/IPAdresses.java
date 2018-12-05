package mustdolist.backtracking;

import java.util.ArrayList;
import java.util.List;

public class IPAdresses {

	public static void main(String[] args) {
		String str="25525511135";
		List<String> output=findAvailableIPAddress(str);
		System.out.println(output);
		
		str="25505011535";
		output=findAvailableIPAddress(str);
		System.out.println(output);
	}

	private static List<String> findAvailableIPAddress(String str) {
		List<String> output=new ArrayList<>();
		
		solve(output,0,str,1,"");
		return output;
	}

	private static boolean solve(List<String> output, int baseIndex,String str, int octet,String newStr)
	{
		if(octet<4)
		{
			for(int i=1;i<=3;i++)
			{
				if(isSafe(str,baseIndex,i))
				{
					String temp="";
					if(newStr.isEmpty())
						temp=str.substring(baseIndex,baseIndex+i);
					else
						temp=newStr+"."+str.substring(baseIndex,baseIndex+i);
					solve(output,baseIndex+i,str,octet+1,temp);
				}
			}
		}
		else
		{
			if(isSafeForLastOctet(str,baseIndex))
			{
				String temp=newStr+"."+str.substring(baseIndex,str.length());
				output.add(temp);
				return true;
			}
		}
		return false;
	}

	private static boolean isSafe(String str, int baseIndex, int length) {
		String subStr=str.substring(baseIndex,baseIndex+length);
		if(subStr.startsWith("0") && subStr.length()>1)
			return false;
		if(Long.valueOf(subStr)>255)
			return false;
		return true;
	}

	private static boolean isSafeForLastOctet(String str, int baseIndex)
	{
		String subStr=str.substring(baseIndex,str.length());
		if(subStr.charAt(0)=='0' && subStr.length()>1)
			return false;
		if(Long.valueOf(subStr)>255)
			return false;
			
		return true;
	}
}
