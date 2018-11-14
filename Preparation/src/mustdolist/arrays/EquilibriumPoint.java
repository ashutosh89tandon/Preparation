package mustdolist.arrays;

public class EquilibriumPoint {
	public static void main(String[] args)
	{
		  int arr[] = { -7, 1, 5, 2, -4, 3, 0 }; 
		  System.out.println(findEqilibriumPoint(arr));
	}

	private static int findEqilibriumPoint(int[] arr) {
		
		int sum=0;
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		int left=0;
		int leftSum=0;
		while(left<arr.length)
		{
			sum-=arr[left];
			if(sum==leftSum)
				return left;
			leftSum+=arr[left];
			left++;
		}
		return -1;
		
	}
}
