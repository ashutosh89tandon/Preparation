package mustdolist.arrays;

import java.util.LinkedHashMap;

public class MaxSumCountSubArray 
{
	static LinkedHashMap<Integer, Integer> map=new LinkedHashMap<>();
	public static void main(String[] args) {
		 int arr[] = {9, 4, 20, 3, 10, 5}; 
		 int k=33;
		 findMaxCount(arr,k);
	}

	private static void findMaxCount(int[] arr, int k) {
		int result=0;
		
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
			
			if(sum==k)
				result++;
			
			if(map.containsKey(sum-k))
				result+=map.get(sum-k);
			
			if(map.get(sum)==null)
				map.put(sum, 1);
			else
				map.put(sum,(map.get(sum)+1));
		}
		System.out.println(result);
	}
}
