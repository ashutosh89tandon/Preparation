package com.prep.ds.linkedlist;

import com.prep.ds.LinkedList;

public class SegregateOddEven
{
	public static void main(String[] args) 
	{
		LinkedList head=new LinkedList(10);
		head.setNext(new LinkedList(12));
		head.getNext().setNext(new LinkedList(15));
		head.getNext().getNext().setNext(new LinkedList(16));
		head.getNext().getNext().getNext().setNext(new LinkedList(18));
		head.getNext().getNext().getNext().getNext().setNext(new LinkedList(20));
		head=segregate(head);
		printList(head);
	}
	
	private static LinkedList segregate(LinkedList head) 
	{
		LinkedList node=null;
		LinkedList headNext=head.getNext();
		LinkedList tail=getTail(head);
		int n = getLength(head);
		LinkedList temp=head;
		LinkedList prev=null;
		LinkedList oldTail=null;
		int i=0;
		boolean evenFound=false;
		while(temp!=null && i<=n)
		{
			LinkedList next=temp.getNext();
			if(temp.getData()%2!=0 && (prev==null || prev.getData()%2==0))
			{
				System.out.println("prev"+prev);
				System.out.println("next"+next);
				if(prev!=null && next!=null)
					prev.setNext(next);
				tail.setNext(temp);
				oldTail=tail;
				tail=temp;
				tail.setNext(null);
				System.out.println("tail"+tail + " tail.getNext"+tail.getNext());
			}
			else if(!evenFound)
			{
				node=temp;
				evenFound=true;
				prev=temp;
			}
			else
			{
				prev=temp;
			}
			i++;
			temp=next;
		}
		
		if(!evenFound){
			tail.setNext(headNext);
			oldTail.setNext(null);
		}
		
		return node==null?head:node;
	}

	private static int getLength(LinkedList head) 
	{
		LinkedList temp=head;
		int n=0;
		while(temp!=null)
		{
			temp=temp.getNext();
			n++;
		}
		System.out.println("Length  "+ n);
		return n;
	}

	private static LinkedList getTail(LinkedList head) 
	{
		LinkedList temp=head;
		while(temp.getNext()!=null)
			temp=temp.getNext();
		
		return temp;
		
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
