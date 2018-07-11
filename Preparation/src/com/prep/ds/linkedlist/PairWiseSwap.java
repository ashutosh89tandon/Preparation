package com.prep.ds.linkedlist;

import com.prep.ds.LinkedList;

public class PairWiseSwap
{
	public static void main(String[] args) {
		LinkedList head=new LinkedList(10);
		head.setNext(new LinkedList(15));
		//head.getNext().setNext(new LinkedList(12));
		//head.getNext().getNext().setNext(new LinkedList(13));
		//head.getNext().getNext().getNext().setNext(new LinkedList(20));
		//head.getNext().getNext().getNext().getNext().setNext(new LinkedList(14));
		
		SwapNodesWithoutSwappingData.printList(head);
		System.out.println();
		head = pairWiseSwap(head);
		SwapNodesWithoutSwappingData.printList(head);
	}
	
	private static LinkedList pairWiseSwap(LinkedList head) 
	{
		LinkedList newHead=head;
		LinkedList temp=head;
		LinkedList prev=null;
		int i=0;
		while(temp!=null && temp.getNext()!=null)
		{
			if(i==0)
			{
				newHead=temp.getNext();
			}
			i++;
			
			LinkedList next=temp.getNext().getNext();
			if(prev!=null)
				prev.setNext(temp.getNext());
			
			prev=temp;
			temp.getNext().setNext(temp);
			temp.setNext(next);
			temp=next;
		}
		
		return newHead;
	}
}
