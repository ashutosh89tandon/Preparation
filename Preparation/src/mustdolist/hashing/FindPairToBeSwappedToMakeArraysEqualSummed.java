package mustdolist.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPairToBeSwappedToMakeArraysEqualSummed 
{
	public static void main(String[] args) {
		int a[]={5, 7, 4, 6};
		int b[]= {1, 2, 3, 8};
		List<Integer> pair=findPair(a,b);
		System.out.println(pair);
	}

	private static List<Integer> findPair(int[] a, int[] b) {
		Map<Integer,Integer> map=new HashMap<>();
		List<Integer> pair=new ArrayList<>();
		int sumA=0;
		int sumB=0;
		for(int i=0;i<a.length;i++)
		{
			map.put(a[i], a[i]);
			sumA+=a[i];
		}
		for(int i=0;i<b.length;i++)
		{
			sumB+=b[i];
		}
		
		for(int i=0;i<b.length;i++)
		{
			int value=(sumA-sumB+(2*b[i]))/2;
			if(map.containsKey(value))
			{
				pair.add(value);
				pair.add(b[i]);
				break;
			}
		}
		
		return pair;
	}
}
