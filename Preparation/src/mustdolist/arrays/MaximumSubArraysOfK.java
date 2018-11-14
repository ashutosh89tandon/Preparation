package mustdolist.arrays;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaximumSubArraysOfK 
{
	public static void main(String[] args) 
	{
		 int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		 int k=3;
		 printMaxSubarrays(arr,k);
	}

	private static void printMaxSubarrays(int[] arr, int k) 
	{
		Deque<Integer> deQueue=new LinkedList<>();
		deQueue.offerFirst(arr[0]);
		for(int i=1;i<k;i++)
		{
			if(arr[i]<deQueue.peekLast())
			{
				Stack<Integer> stack=new Stack<>();
				while(!deQueue.isEmpty() && arr[i]<deQueue.peekLast())
				{
					stack.push(deQueue.pollLast());
				}
				deQueue.offerLast(arr[i]);
				while(!stack.isEmpty())
					deQueue.offerLast(stack.pop());
			}
			else
			{
				deQueue.offerLast(arr[i]);
			}
		}
		
		for(int i=k;i<arr.length;i++)
		{
			System.out.print(deQueue.peekLast()+" ");
			Stack<Integer> stack=new Stack<>();
			while(!deQueue.isEmpty() && arr[i-k]<deQueue.peekLast())
			{
				stack.push(deQueue.pollLast());
			}
			deQueue.pollLast();
			while(!stack.isEmpty())
				deQueue.offerLast(stack.pop());
			
			if(arr[i]<deQueue.peekLast())
			{
				while(!deQueue.isEmpty() && arr[i]<deQueue.peekLast())
				{
					stack.push(deQueue.pollLast());
				}
				deQueue.offerLast(arr[i]);
				while(!stack.isEmpty())
					deQueue.offerLast(stack.pop());
			}
			else
			{
				deQueue.offerLast(arr[i]);
			}
		}
		System.out.print(deQueue.peekLast()+" ");
	}
}
