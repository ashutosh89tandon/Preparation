package mustdolist.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestWindowOfString {
	
	public static void main(String[] args) {
		String str = "this is a test string";
		String pattern = "tist";
		System.out.println(findMinWindow(str, pattern));
		
		String str1 = "geeksforgeeks";
		String pattern1 = "ork";
		System.out.println(findMinWindow(str1, pattern1));
	}

	private static String findMinWindow(String str, String pattern)
	{
		Map<Character,List<Integer>> charMap=new HashMap<>();
		int maxLength=str.length();
		String result="";
		for(int i=0;i<str.length();i++)
		{
			if(pattern.indexOf(str.charAt(i))!=-1)
			{
				if(!charMap.containsKey(str.charAt(i)))
					charMap.put(str.charAt(i), new ArrayList<>());
				charMap.get(str.charAt(i)).add(i);
			}
		}
		
		for(int i=0;i<str.length();i++)
		{
			List<Integer> indexList=new ArrayList<>();
			if(pattern.indexOf(str.charAt(i))!=-1)
			{	List<Character> stack=new ArrayList<>();
				indexList.add(i);
				populateStack(stack,pattern);
				int count=1;
				int start=i;
				int end =i;
				stack.remove((Character)str.charAt(i));
				while(!stack.isEmpty())
				{
					char character=stack.get(0);
					List<Integer> list=charMap.get(character);
					
					boolean found=false;
					for(int index : list)
					{
						if(index>start && !indexList.contains(index))
						{
							found =true;
							if(index>end)
								end=index;
							indexList.add(index);
							break;
						}
					}
					if(!found)
						break;
					count++;
					stack.remove((Character)character);
				}
				
				if(count==pattern.length() && end-start+1<maxLength)
				{
					result=str.substring(start, end+1);
					System.out.println("Result : "+result);
					maxLength=end-start+1;
				}
				stack.clear();
			}
		}
		
		return result;
	}

	private static void populateStack(List<Character> stack, String pattern) {
		for(int i=0;i<pattern.length();i++)
			stack.add(pattern.charAt(i));
	}
}
