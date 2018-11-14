package mustdolist.arrays;

public class MinimumPlatforms
{
	public static void main(String[] args) {
		int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
	    findMinimumPlatformRequired(arr,dep);
	}

	private static void findMinimumPlatformRequired(int[] arr, int[] dep) {
		int maxCount=1;
		for(int i=1;i<arr.length;i++)
		{
			int count=1;
			int j=i-1;
			while(j>=0 && dep[j]>arr[i])
			{
				if(dep[j]>arr[i])
					count++;
				j--;
			}
			if(count>maxCount)
				maxCount=count;
		}
		System.out.println(maxCount);
	}
}
