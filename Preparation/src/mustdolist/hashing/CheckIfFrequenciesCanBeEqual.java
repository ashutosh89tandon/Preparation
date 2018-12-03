package mustdolist.hashing;

import java.util.HashMap;
import java.util.Map;

public class CheckIfFrequenciesCanBeEqual
{
	public static void main(String[] args) {
		String str="xxxxxyyyyzzzz";
		System.out.println(findIfFrequencyCanBeMatched(str));
	}

	private static String findIfFrequencyCanBeMatched(String str) {
		Map<Character,Integer> map=new HashMap<>();
		int maxOccurence=0;
		int minOccurence=0;
		int maxCount=0;
		int minCount=0;
		for(int i=0;i<str.length();i++)
		{
			if(map.get(str.charAt(i))==null)
			{
				map.put(str.charAt(i), 1);
			}
			else
			{
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}
			if(maxOccurence<map.get(str.charAt(i)))
				maxOccurence=map.get(str.charAt(i));
		}
		
		Character prevChar=null;
		for(int i=0;i<str.length();i++)
		{
			if(prevChar!=null && prevChar==str.charAt(i))
				continue;
			if(map.get(str.charAt(i))==maxOccurence)
				maxCount++;
			else
			{
				if(minOccurence!=0 && minOccurence!=map.get(str.charAt(i)))
					return "No";
				minOccurence=map.get(str.charAt(i));
				minCount++;
			}
			
			prevChar=str.charAt(i);
		}
		
		if(maxCount>1 && minCount>1)
			return "No";
		
		if(maxCount>1 && minOccurence>1)
			return "No";
		if(maxCount==1 && maxOccurence-minOccurence>1)
			return "No";
	
		return "Yes";
	}
}
