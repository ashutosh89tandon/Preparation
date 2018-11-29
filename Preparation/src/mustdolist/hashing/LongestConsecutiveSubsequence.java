package mustdolist.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestConsecutiveSubsequence 
{
	public static void main(String[] args) {
		int a[]= {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
		List<Integer> list=findMaxSubsequence(a);
		System.out.println(list);
	}

	private static List<Integer> findMaxSubsequence(int[] a) {
		List<Integer> maxList=null;
		int maxCount=0;
		Map<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<a.length;i++)
		{
			map.put(a[i], i);
		}
		
		for(int i=0;i<a.length;i++)
		{
			List<Integer> list=new ArrayList<>();
			int count=1;
			list.add(a[i]);
			int j=1;
			while(map.containsKey(a[i]+j))
			{
				list.add(a[i]+j);
				count++;
				j++;
			}
			if(count>maxCount)
			{
				maxCount=count;
				maxList=list;
			}
		}
		
		return maxList;
			
	}
}
