package mustdolist.stacks;

import java.util.Stack;

public class NextLargerElement {
	
	public static void main(String[] args) {
		int arr[] = {11, 13, 21, 3  }; 
		printNextGE(arr);
	}

	private static void printNextGE(int[] arr) {
		Stack<Integer> stack=new Stack<>();
		stack.push(arr[0]);
		
		for(int i=1;i<arr.length;i++)
		{
			int next=arr[i];
			while(!stack.isEmpty() && stack.peek()<next)
			{
				System.out.println(stack.pop()+"-->"+next);
			}
			
			stack.push(arr[i]);
		}
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop()+"-->"+-1);
		}
	}
}
