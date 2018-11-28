package mustdolist.hashing;

import java.util.HashMap;
import java.util.Map;

public class FindKSumCountOfTwoArrays
{
	public static void main(String[] args)
	{
		int a[]= {9,4,5,1,7,2};
		int b[]= {1,6,9,8,3,0};
		int count=findSumCount(a,b, 10);
		System.out.println(count);
	}

	private static int findSumCount(int[] a, int[] b,int k) {
		int count=0;
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<a.length;i++)
			map.put(a[i], a[i]);
		
		for(int i=0;i<b.length;i++)
		{
			if(map.containsKey(k-b[i]))
			{
				count++;
				map.remove(k-b[i]);
				map.remove(b[i]);
			}
		}
		
		return count;
	}
}
