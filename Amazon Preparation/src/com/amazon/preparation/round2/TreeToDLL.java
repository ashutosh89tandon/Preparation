package com.amazon.preparation.round2;

public class TreeToDLL {

	static DoublyLinkedList dll=null;
	static DoublyLinkedList firstdll=null;
	public static void main(String[] args) {
		
		Node root=new Node(10);
		root.left=new Node(12);
		root.right=new Node(15);
		root.left.left=new Node(25);
		root.left.right=new Node(30);
		root.right.left=new Node(36);
		convertTreeToDLL(root);
		printNodes(firstdll);
	}
	
	private static void printNodes(DoublyLinkedList dll) {
		DoublyLinkedList node=dll;
		 
		 while(node!=null)
		 {
			 System.out.print(node.data+"->");
			 node=node.next;
		 }
		
	}

	public static void convertTreeToDLL(Node current)
	{
		if(current==null)
			return;
		
		convertTreeToDLL(current.left);
		
		DoublyLinkedList newNode=new DoublyLinkedList(current.data);
		
		if(dll==null)
		{
			dll=newNode;
			firstdll=newNode;
		}
		else
		{
			dll.next=newNode;
			newNode.prev=dll;
			dll=dll.next;
		}
		
		convertTreeToDLL(current.right);
	}
}
