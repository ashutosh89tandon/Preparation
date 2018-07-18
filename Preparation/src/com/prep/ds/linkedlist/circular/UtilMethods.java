package com.prep.ds.linkedlist.circular;

import com.prep.ds.LinkedList;

public class UtilMethods {

	public static  void printList(LinkedList head)
	{
		LinkedList temp=head;
		do
		{
			System.out.print(temp+"->");
			temp=temp.getNext();
		}while(temp!=head);
		System.out.println();
	}
	
	public static LinkedList getInitializedCircularList()
	{
		LinkedList head=new LinkedList(10);
		head.setNext(new LinkedList(15));
		head.getNext().setNext(new LinkedList(12));
		head.getNext().getNext().setNext(new LinkedList(13));
		head.getNext().getNext().getNext().setNext(new LinkedList(20));
		head.getNext().getNext().getNext().getNext().setNext(new LinkedList(14));
		head.getNext().getNext().getNext().getNext().getNext().setNext(head);
		
		return head;
	}
}
