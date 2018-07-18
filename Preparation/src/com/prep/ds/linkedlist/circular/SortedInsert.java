package com.prep.ds.linkedlist.circular;

import com.prep.ds.LinkedList;

public class SortedInsert
{
	public static void main(String[] args)
	{
		LinkedList head=null;
		head=sortedInsert(4,head);
		head=sortedInsert(8,head);
		head=sortedInsert(3,head);
		head=sortedInsert(9,head);
		head=sortedInsert(1,head);
		UtilMethods.printList(head);
		
	}

	private static LinkedList sortedInsert(int i, LinkedList head) {
		
		if(head==null)
		{
			head=new LinkedList(i);
			head.setNext(head);
		}
		else
		{
			LinkedList temp=head;
			LinkedList prev=null;
			do
			{
				LinkedList node=new LinkedList(i);
				if(i<temp.getData())
				{
					if(temp.equals(head))
					{
						if(temp.getNext().equals(head))
							head.setNext(node);
						else
						{
							LinkedList innerTemp=head;
							do{
								innerTemp=innerTemp.getNext();
							}while(innerTemp.getNext()!=head);
							
							innerTemp.setNext(node);
						}
						node.setNext(head);
						head=node;
						temp=head;
					}
					else
					{
						node.setNext(temp);
						prev.setNext(node);
						temp=node;
					}
					break;
				}
				else if(temp.getNext().equals(head))
				{
					temp.setNext(node);
					node.setNext(head);
					temp=node;
				}
				prev=temp;
				temp=temp.getNext();
			}while(!temp.equals(head));
		}
		return head;
	}
}
