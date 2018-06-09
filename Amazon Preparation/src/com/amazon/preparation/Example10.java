package com.amazon.preparation;

public class Example10 
{
	public static void main(String[] args) {
		LinkedNode node=new LinkedNode(1);
		node.next=new LinkedNode(2);
		node.next.next=new LinkedNode(3);
		node.next.next.next=new LinkedNode(4);
		node.next.next.next.next=new LinkedNode(5);
	
		traverse(node);
		System.out.println();
		LinkedNode newNode=reverseKNodes(node, 3);
		
		System.out.println();
		traverse(newNode);
	}
	
	public static void traverse(LinkedNode node)
	{
		while(node!=null)
		{
			System.out.print(node+"->");
			node=node.next;
		}
	}
	
	public static LinkedNode reverseKNodes(LinkedNode head, int k)
	{
		int i=k;
		LinkedNode temp=head;
		LinkedNode previousNode=null;
		LinkedNode next=null;
		while(i>0)
		{
			next=temp.next;
			temp.next=previousNode;
			previousNode=temp;
			temp=next;
			i--;
		}
		
		head.next=temp;
		System.out.println(previousNode.next.next.next.next.next);
		//traverse(previousNode);
		return previousNode;
		
	}
}

class LinkedNode
{
	public int data;
	public LinkedNode next=null;
	public LinkedNode(int data, LinkedNode left) {
		super();
		this.data = data;
		this.next = left;
	}
	public LinkedNode(int data) {
		super();
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkedNode getNext() {
		return next;
	}
	public void setNext(LinkedNode next) {
		this.next = next;
	}
	
	@Override
	public String toString()
	{
		return "Node : "+data;
	}
	
}