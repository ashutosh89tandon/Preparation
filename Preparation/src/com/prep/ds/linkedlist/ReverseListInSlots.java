package com.prep.ds.linkedlist;

import java.util.Stack;

import com.prep.ds.LinkedList;

public class ReverseListInSlots {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(1);
		list.next = new LinkedList(2);
		list.next.next = new LinkedList(3);
		list.next.next.next = new LinkedList(4);
		list.next.next.next.next = new LinkedList(5);
		list.next.next.next.next.next = new LinkedList(6);
		list.next.next.next.next.next.next = new LinkedList(7);
		list.next.next.next.next.next.next.next = new LinkedList(8);
		list.next.next.next.next.next.next.next.next = new LinkedList(9);

		printList(list);
		System.out.println();
		LinkedList head=swapInPair(list,3);
		printList(head);
	}

	private static void printList(LinkedList head) {
		
		LinkedList temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		
	}

	private static LinkedList swapInPair(LinkedList head, int k) {
		
		Stack<LinkedList> stack= new Stack<>();
		int cycle=0;
		LinkedList temp =head;
		LinkedList newHead =null;
		LinkedList prev=null;
		while(temp !=null)
		{
			int i=0;
			LinkedList local=null;
			while(i<k && temp!=null)
			{
				i++;
				stack.push(temp);
				local=temp;
				temp=temp.next;
			}
			if(cycle==0)
			{
				newHead=local;
			}
			
			while(!stack.isEmpty())
			{
				LinkedList node=stack.pop();
				if(prev!=null)
					prev.next=node;
				prev=node;
			}
			
			if(temp==null)
				prev.next=null;
			
			cycle++;
		}
		
		return newHead;
	}
}
