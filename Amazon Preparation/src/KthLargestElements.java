


public class KthLargestElements {

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
			for(int j=0; j<arr.length-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			
			ar[i]=arr[arr.length-1-i];
		}
		
		return ar;
	}
}
