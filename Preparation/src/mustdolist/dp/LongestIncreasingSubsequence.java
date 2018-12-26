package mustdolist.dp;

public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		int arr[]={10, 22, 9, 33, 21, 50, 41, 60};
		int length=longestIncreasingSubsequence(arr);
		System.out.println("length :"+length);
	}

	public static int longestIncreasingSubsequence(int[] arr) 
	{
		int length=1;
		int l[]=new int[arr.length];
		l[0]=1;
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j]<arr[i] && l[i]<l[j]+1)
					l[i]=l[j]+1;
			}
			if(l[i]==0)
				l[i]=1;
			
			if(length<l[i])
				length=l[i];
		}
		
		return length;
	}

}
