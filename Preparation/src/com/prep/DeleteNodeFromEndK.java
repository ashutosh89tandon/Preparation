package com.prep;

import com.prep.ds.DoublyLinkedList;

public class DeleteNodeFromEndK 
{
	public static void main(String[] args) {
		
		DoublyLinkedList node=new DoublyLinkedList(10);
		node.setNext(new DoublyLinkedList(12));
		node.getNext().setNext(new DoublyLinkedList(8));
		node.getNext().getNext().setNext(new DoublyLinkedList(19));
		node.getNext().getNext().getNext().setNext(new DoublyLinkedList(18));
		
		node=deleteNodeFromBack(node,6);
		printList(node);
	}
	
	private static DoublyLinkedList deleteNodeFromBack(DoublyLinkedList node,int k)
	{
		DoublyLinkedList endPointer=node;
		DoublyLinkedList kPointer=node;
		DoublyLinkedList prevNode=null;
		boolean notPossible=false;
		while(k>0)
		{
			if(endPointer==null)
			{
				notPossible=true;
				break;
			}
			endPointer=endPointer.getNext();
			k--;
		}
		
		if(notPossible)
			return node;
		
		while(endPointer!=null)
		{
			if(endPointer.getNext()==null)
			{
				break;
			}
			prevNode=kPointer;
			kPointer=kPointer.getNext();
			endPointer=endPointer.getNext();
		}
		
		if(prevNode==null)
			node=node.getNext();
		else
		{
			prevNode.setNext(kPointer.getNext());
		}
		
		return node;
	}
	
	private static void printList(DoublyLinkedList node)
	{
		DoublyLinkedList temp=node;
		
		while(temp!=null)
		{
			System.out.println(temp);
			temp=temp.getNext();
		}
	}
}
