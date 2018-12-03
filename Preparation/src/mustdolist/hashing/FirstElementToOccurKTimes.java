package mustdolist.hashing;

import java.util.HashMap;
import java.util.Map;

public class FirstElementToOccurKTimes 
{
	public static void main(String[] args) {
		int a[]={1, 4, 7, 3, 4, 8, 7};
		findFirstElementToOccurKTimes(a,2);
		
		int b[]={4, 1, 6, 1, 6, 4};
		findFirstElementToOccurKTimes(b,1);
	}

	private static void findFirstElementToOccurKTimes(int[] a, int k)
	{
		Map<Integer,Integer> map=new HashMap<>();
		int result=-1;
		for(int i=0;i<a.length;i++)
		{
			if(map.get(a[i])==null)
				map.put(a[i], 1);
			else
				map.put(a[i], map.get(a[i])+1);
		}
		
		for(int i=0;i<a.length;i++)
		{
			if(map.get(a[i])==k)
			{
				result=a[i];
				break;
			}
		}
		
		System.out.println(result);
	}
}
