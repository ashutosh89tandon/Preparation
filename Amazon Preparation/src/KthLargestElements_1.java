


 class KthLargestElements_1 {

	public static void main(String args[])
	{
		int[] arr=getKElements(new int[]{4,1,7,4,2,9}, 2);
		
		for(int i : arr)
		{
			System.out.println(i);
		}
	}
	
	public static int[] getKElements(int[] arr, int k)
	{
		int ar[]=new int[k];
		for(int i=0;i<k;i++)
		{
			int max=arr[i];
			
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j]>max)
				{
					int temp=arr[j];
					arr[j]=max;
					max=temp;
				}
			}
			ar[i]=max;
		}
		
		return ar;
	}
}

