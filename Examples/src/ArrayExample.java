
public class ArrayExample 
{
	public static void main(String[] args)
	{
		int arr[]={1,2,3,4,5};
		int[] arr1= arr;
		int[] arr2=new  int[1];
		arr2=arr1;
		
		for(int value: arr2)
		{
			System.out.println("Value "+value);
		}
	}

}
