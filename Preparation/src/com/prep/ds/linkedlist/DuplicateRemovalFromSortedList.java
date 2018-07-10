package com.prep.ds.linkedlist;

import com.prep.ds.CharLinkedList;

public class DuplicateRemovalFromSortedList 
{
	public static void main(String[] args) {
		
		CharLinkedList head=new CharLinkedList('R');
		head.setNext(new CharLinkedList('R'));
		head.getNext().setNext(new CharLinkedList('D'));
		head.getNext().getNext().setNext(new CharLinkedList('B'));
		head.getNext().getNext().getNext().setNext(new CharLinkedList('A'));
		head.getNext().getNext().getNext().getNext().setNext(new CharLinkedList('A'));
		
		printList(head);
		removeDuplicates(head);
		printList(head);
	}

	private static void removeDuplicates(CharLinkedList head) {
		
		CharLinkedList temp=head;
		CharLinkedList prev=null;
		while(temp!=null)
		{
			if(!temp.equals(prev))
			{
				prev=temp;
				temp=temp.getNext();
			}
			else
			{
				prev.setNext(temp.getNext());
				temp=temp.getNext();
			}
		}
	}
	
	public static  void printList(CharLinkedList head)
	{
		CharLinkedList temp=head;
		
		while(temp!=null)
		{
			System.out.print(temp+"->");
			temp=temp.getNext();
		}
		System.out.println();
	}
}
