package mustdolist.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSwapPairsForDivisibility {
	public static void main(String[] args) {
		List<List<Integer>> pairs=null;
		int a[]={9, 7, 5, 3};
		pairs=findPairs(a,6);
		for(List<Integer> pair : pairs)
		{
			System.out.println(pair.get(0)+","+pair.get(1));
		}
		
		int b[]={92, 75, 65, 48, 45, 35};
		pairs=findPairs(b,10);
		for(List<Integer> pair : pairs)
		{
			System.out.println(pair.get(0)+","+pair.get(1));
		}
		
		int c[]={91, 74, 66, 48};
		pairs=findPairs(c,10);
		if(pairs.size()<a.length || a.length%2==1)
		{
			System.out.println(false);
		}
		else
		{
			for(List<Integer> pair : pairs)
			{
				System.out.println(pair.get(0)+","+pair.get(1));
			}
		}
	}

	private static List<List<Integer>> findPairs(int[] a,int k) {
		List<List<Integer>> pairs=new ArrayList<>();
		Map<Integer,List<Integer>> map=new HashMap<>();
		for(int i=0;i<a.length;i++)
		{
			if(map.containsKey(a[i]%k))
			{
				List<Integer> list=map.get(a[i]%k);
				list.add(a[i]);
				map.put(a[i]%k,list );
			}
			else
			{
				List<Integer> list=new ArrayList<>();
				list.add(a[i]);
				map.put(a[i]%k,list);
			}
		}
		
		for(int i=0;i<a.length/2;i++)
		{
			if(map.containsKey(k-(a[i]%k)))
			{
				List<Integer> list=new ArrayList<>();
				list.add(a[i]);
				list.add(map.get(k-(a[i]%k)).get(map.get(k-(a[i]%k)).size()-1));
				map.get(k-(a[i]%k)).remove(map.get(k-(a[i]%k)).size()-1);
				pairs.add(list);
			}
		}
		
		return pairs;
	}
}
