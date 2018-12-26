package mustdolist.dp;

public class MinimumNumberOfJumps 
{
	public static void main(String[] args) 
	{
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int length=findMinJumps(arr);
		System.out.println(length);
	}

	private static int findMinJumps(int[] arr)
	{
		int jumps=0;
		int step=arr[0];
		int maxReach=arr[0];
		for(int i=0;i<arr.length;)
		{
			if(maxReach>=arr.length)
				return jumps+1;
			maxReach=Math.max(maxReach,arr[i]+i);
			step--;
			i++;
			if(step==0)
			{
				jumps++;
				i=maxReach;
				if(maxReach>=arr.length)
					return jumps+1;
				step=arr[maxReach];
			}

		}
		
		return 0;
	}
}
