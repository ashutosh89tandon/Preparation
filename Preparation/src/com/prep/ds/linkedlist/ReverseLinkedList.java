package com.prep.ds.linkedlist;

import com.prep.ds.LinkedList;

public class ReverseLinkedList
{
	public static void main(String[] args) 
	{
		LinkedList head=new LinkedList(10);
		head.setNext(new LinkedList(15));
		head.getNext().setNext(new LinkedList(12));
		head.getNext().getNext().setNext(new LinkedList(13));
		head.getNext().getNext().getNext().setNext(new LinkedList(20));
		head.getNext().getNext().getNext().getNext().setNext(new LinkedList(14));
		head=reverse(head);
		printList(head);
	}

	private static LinkedList reverse(LinkedList head) {
		
		LinkedList temp=head,prev=null;
		
		while(temp!=null)
		{
			LinkedList next=temp.getNext();
			temp.setNext(prev);
			prev=temp;
			temp=next;
		}
		
		return prev;
	}
	
	public static  void printList(LinkedList head)
	{
		LinkedList temp=head;
		
		while(temp!=null)
		{
			System.out.print(temp+"->");
			temp=temp.getNext();
		}
		System.out.println();
	}
}
