package com.prep.ds.linkedlist;

import com.prep.ds.LinkedList;

public class SwapNodesWithoutSwappingData 
{
	public static void main(String[] args) 
	{
		LinkedList head=new LinkedList(10);
		head.setNext(new LinkedList(15));
		head.getNext().setNext(new LinkedList(12));
		head.getNext().getNext().setNext(new LinkedList(13));
		head.getNext().getNext().getNext().setNext(new LinkedList(20));
		head.getNext().getNext().getNext().getNext().setNext(new LinkedList(14));
		
		printList(head);
		System.out.println();
		head = swapNodesWithoutSwappingData(head, 12,20);
		printList(head);
	}

	private static LinkedList swapNodesWithoutSwappingData(LinkedList head,int first,int second) 
	{
		LinkedList tempHead=head;
		LinkedList node=head;
		int tempSecond=second;
		LinkedList prev=null;
		while(node!=null)
		{
			if(node.getData()==first)
			{
				tempHead=node;
				break;
			}
			
			else if(node.getData()==second)
			{
				tempHead=node;
				tempSecond=first;
				break;
			}
			prev=node;
			node=node.getNext();
		}
		
		node=tempHead;
		LinkedList prevSecond=null;
		while(node!=null)
		{
			if(node.getData()==tempSecond)
			{
				if(prevSecond.equals(tempHead))
				{
					LinkedList next=node.getNext();
					if(prev!=null)
						prev.setNext(node);
					node.setNext(tempHead);
					tempHead.setNext(next);
				}
				else
				{
					LinkedList next=tempHead.getNext();
					tempHead.setNext(node.getNext());
					node.setNext(next);
					if(prev!=null)
						prev.setNext(node);
					if(prevSecond!=null)
						prevSecond.setNext(tempHead);
					break;
				}
			}
			prevSecond=node;
			node=node.getNext();
		}
		if(tempHead.equals(head))
			return node;
		return head;
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
