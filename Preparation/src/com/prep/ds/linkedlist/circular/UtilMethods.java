package com.prep.ds.linkedlist.circular;

import com.prep.ds.DoublyLinkedList;
import com.prep.ds.LinkedList;

public class UtilMethods {

	public static  void printCircularList(LinkedList head)
	{
		LinkedList temp=head;
		do
		{
			System.out.print(temp+"->");
			temp=temp.getNext();
		}while(temp!=head);
		System.out.println();
	}
	
	public static  void printDoublyList(DoublyLinkedList head)
	{
		DoublyLinkedList temp=head;
		while(temp!=null)
		{
			System.out.println(temp+" Prev : "+temp.getPrev()+" Next: "+temp.getNext());
			temp=temp.getNext();
		}
		System.out.println();
	}
	
	public static  void printDoublyListFromEnd(DoublyLinkedList end)
	{
		DoublyLinkedList temp=end;
		while(temp!=null)
		{
			System.out.println(temp+" Prev : "+temp.getPrev()+" Next: "+temp.getNext());
			temp=temp.getPrev();
		}
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
