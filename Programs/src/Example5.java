import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example5 
{
	public static void main(String[] args)
	{
		System.out.println("String : "+getUniqueString("heena"));
		System.out.println("String :"+getDistinctString("heena"));
	}
	
	public static String getUniqueString(String str)
	{
		
		StringBuilder sb=new StringBuilder();
		Map<Integer,Integer> count=new LinkedHashMap<Integer,Integer>();
		count=str.chars().mapToObj(c->c).collect(Collectors.toMap(c->c, c->1,Integer::sum));
		
		for(int  c: count.keySet())
		{
			sb.append(((char)c)+"");
		}
		
		return sb.toString();
	}
	
	public static String getDistinctString(String str)
	{
		StringBuilder sb=new StringBuilder();
		List<Character> chars=new ArrayList<Character>();
		
		for(char s : str.toCharArray())
		{
			if(!chars.contains(s))
			{
				sb.append(s);
				chars.add(s);
			}
			
		}
		
		return sb.toString();
	}
}

