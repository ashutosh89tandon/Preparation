package com.prep.ds.linkedlist;

import com.prep.ds.LinkedList;

public class SegregateOddEven
{
	public static void main(String[] args) 
	{
		LinkedList head=new LinkedList(13);
		head.setNext(new LinkedList(15));
		head.getNext().setNext(new LinkedList(12));
		head.getNext().getNext().setNext(new LinkedList(10));
		head.getNext().getNext().getNext().setNext(new LinkedList(20));
		head.getNext().getNext().getNext().getNext().setNext(new LinkedList(14));
		head=segregate(head);
		printList(head);
	}
	
	private static LinkedList segregate(LinkedList head) 
	{
		LinkedList node=null;
		LinkedList tail=getTail(head);
		int n = getLength(head);
		LinkedList temp=head;
		LinkedList prev=null;
		int i=0;
		boolean evenFound=false;
		while(temp!=null && i<=n)
		{
			LinkedList next=temp.getNext();
			if(temp.getData()%2!=0)
			{
				if(prev!=null)
					prev.setNext(next);
				tail.setNext(temp);
				tail=temp;
			}
			else if(!evenFound)
			{
				node=temp;
				evenFound=true;
			}
			i++;
			prev=temp;
			temp=next;
		}
		
		prev.setNext(null);
		
		return node;
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
