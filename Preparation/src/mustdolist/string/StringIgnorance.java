package mustdolist.string;

import java.util.HashMap;
import java.util.Map;

public class StringIgnorance
{
	public static void main(String[] args) {
		String str="It is a long day Dear.";
		printAlternate(str);
	}

	private static void printAlternate(String str)
	{
		Map<Character, Character> map=new HashMap<>();
		String newString="";
		for(int i=0;i<str.length();i++)
		{
			Character ch=str.charAt(i);
			if(ch>=65 && ch<=90 && (map.containsKey(ch) || map.containsKey((char)(ch+32))))
			{
				map.remove(ch);
				map.remove((char)(ch+32));
			}
			else if(ch>=97 && ch<=122 &&  (map.containsKey(ch) || map.containsKey((char)(ch-32))))
			{
				map.remove(ch);
				map.remove((char)(ch-32));
			}
			else if(map.containsKey(ch))
			{
				map.remove(ch);
			}
			else
			{
				map.put(ch, ch);
				newString+=ch;
			}
		}
		
		System.out.println(newString);
	}
}
