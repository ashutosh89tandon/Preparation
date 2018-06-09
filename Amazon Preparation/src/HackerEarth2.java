import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HackerEarth2 
{
	public static Map<String,Integer> list=new HashMap<String,Integer>();
	public static void main(String[] args) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=br.readLine();
		
		if(line==null || line.isEmpty())
			System.out.println(0);
		else
		{
			System.out.println(getSubStringCount(line));
		}
		
		br.close();
		
	}

	private static int getSubStringCount(String line)
	{
		String str=new String(line);
		int count=0;
		Arrays.sort(str.toCharArray());
		str=String.valueOf(str.toCharArray());
		Map<Character, Integer> map=str.chars().mapToObj(c->c).collect(Collectors.toMap(c->new Character((char)(((Integer)c).intValue())), c->1,Integer::sum));
		
		int index1=-1;
		for(int i=1;i<=map.get('a');i++)
		{
			index1=line.indexOf('a', index1+1);
			if(index1==-1)
				break;
			int index2=-1;
			for(int j=1;j<=map.get('b');j++)
			{
				index2=line.indexOf('b', index2+1);
				if(index2<index1)
					continue;
				int index3=-1;
				for(int k=1;k<=map.get('c');k++)
				{
					index3=line.indexOf('c', index3+1);
					if(index3<index2)
						continue;
					count++;
					
					if(i>1 || j>1 || k>1)
						count++;
				}
			}
		}
		
		return count;
	}
	
	
}
