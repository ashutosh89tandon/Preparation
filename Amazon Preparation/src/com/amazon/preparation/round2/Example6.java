package com.amazon.preparation.round2;

public class Example6 
{
	public static void main(String[] args) 
	{
		DoublyLinkedList node=new DoublyLinkedList(1);
		node.prev=null;
		node.next=new DoublyLinkedList(2);
		node.next.prev=node;
		node.next.next=new DoublyLinkedList(3);
		node.next.next.prev=node.next;
		node.next.next.next=new DoublyLinkedList(4);
		node.next.next.next.prev=node.next.next;
		
		DoublyLinkedList currentNode=rotateByNNodes(node, 4);
		System.out.println(currentNode.prev);
		traverse(currentNode);
	}
	
	public static DoublyLinkedList rotateByNNodes(DoublyLinkedList node,int n)
	{
		DoublyLinkedList lastNode=getlastNode(node);
		DoublyLinkedList startNode=node;
		
		while(n>0)
		{
			lastNode.next=startNode;
			startNode.prev=lastNode;
			lastNode=startNode;
			startNode=startNode.next;
			lastNode.next=null;
		    startNode.prev=null;
			n--;
			
		}
		
		return startNode;
	}

	private static DoublyLinkedList getlastNode(DoublyLinkedList node) 
	{
		DoublyLinkedList lastNode=null;
		DoublyLinkedList tempNode=node;
		
		while(tempNode!=null)
		{
			lastNode=tempNode;
			tempNode=tempNode.next;
		}
		
		return lastNode;
	}
	
	private static void traverse(DoublyLinkedList node) 
	{
		DoublyLinkedList tempNode=node;
		
		while(tempNode!=null)
		{
			System.out.println(tempNode+ " Prev : "+tempNode.prev+" Next: "+tempNode.next);
			tempNode=tempNode.next;
		}
		
	}
	
	
	
}
