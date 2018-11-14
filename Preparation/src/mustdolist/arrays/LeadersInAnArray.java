package mustdolist.arrays;

import java.util.Stack;

public class LeadersInAnArray 
{
	public static void main(String[] args) {
		int arr[] = {16, 17, 4, 3, 5, 2}; 
		printLeaders(arr);
	}

	private static void printLeaders(int[] arr) {
		Stack<Integer> stack=new Stack<>();
		int max=arr[arr.length-1];
		stack.push(arr[arr.length-1]);
		for(int i=arr.length-2;i>=0;i--)
		{
			if(max<=arr[i])
				max=arr[i];
			else
			{
				stack.push(max);
				max=arr[i];
			}
		}
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop()+" ");
		}
	}
}
