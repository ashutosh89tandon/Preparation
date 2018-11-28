package mustdolist.hashing;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayWithSumZero {
	
	public static void main(String[] args) {
		int a[]= {15, -2, 2, -8, 1, 7, 10, 23};
		int count = findMaxSubArrayWithCountZero(a);
		System.out.println("Count "+count);
		
		int b[]= {1,2,3};
		count = findMaxSubArrayWithCountZero(b);
		System.out.println("Count "+count);
		
		int c[]= {1, 0, 3};
		count = findMaxSubArrayWithCountZero(c);
		System.out.println("Count "+count);
	
	}

	private static int findMaxSubArrayWithCountZero(int[] a)
	{
		int count=0;
		int sum=0;
		Map<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==0 && count<1)
				count=1;
			sum+=a[i];
			if(map.containsKey(sum) && count<i-map.get(sum))
			{
				count=i-map.get(sum);
			}
			else
				map.put(sum, i);
		}
		return count;
	}
	
}
