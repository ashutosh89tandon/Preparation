package mustdolist.string;

import java.util.ArrayList;
import java.util.List;

public class CamelCaseMatching
{
	public static void main(String[] args) {
		String dict[] = {"Hi", "Hello", "HelloWorld",  "HiTech", "HiGeek", 
		                 "HiTechWorld", "HiTechCity", "HiTechLab"};
		String pattern="HTC";
		System.out.println(findAllStringsWithGivenPattern(dict,pattern));
		
		String dict1[] = {"WelcomeGeek","WelcomeToGeeksForGeeks", "GeeksForGeeks"};
		String pattern1="GG";
		System.out.println(findAllStringsWithGivenPattern(dict1,pattern1));
		
	}

	private static List<String> findAllStringsWithGivenPattern(String[] dict, String pattern) {
		List<String> output=new ArrayList<>();
		for(String str :  dict)
		{
			int patternIndex=0;
			for(int i=0;i<str.length();i++)
			{
				if(str.charAt(i)>=65 && str.charAt(i)<=90)
				{
					if(str.charAt(i)==pattern.charAt(patternIndex))
						patternIndex++;
					else
						break;
				}
				
				if(patternIndex==pattern.length())
					break;
			}
			
			if(patternIndex==pattern.length())
				output.add(str);
		}
		
		return output;
	}
}
