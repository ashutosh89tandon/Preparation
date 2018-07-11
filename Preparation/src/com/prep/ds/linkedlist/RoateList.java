package com.prep.ds.linkedlist;

import com.prep.ds.LinkedList;

public class RoateList
{
	public static void main(String[] args)
	{
		LinkedList head=new LinkedList(10);
		head.setNext(new LinkedList(15));
		head.getNext().setNext(new LinkedList(12));
		head.getNext().getNext().setNext(new LinkedList(13));
		head.getNext().getNext().getNext().setNext(new LinkedList(20));
		head.getNext().getNext().getNext().getNext().setNext(new LinkedList(14));
		
		SwapNodesWithoutSwappingData.printList(head);
		System.out.println();
		head =rotate(head,1);
		SwapNodesWithoutSwappingData.printList(head);
	}

	private static LinkedList rotate(LinkedList head,int round) 
	{
		while(round>0)
		{
			LinkedList temp=head;
			LinkedList prev=null;
			while(temp.getNext()!=null)
			{
				prev=temp;
				temp=temp.getNext();
			}

			LinkedList next=prev.getNext();
			prev.setNext(null);
			next.setNext(head);
			head=next;
			round--;
		}
		
		return head;
		
	}
	
	
}
