package com.prep.ds.linkedlist;

import java.util.Stack;

import com.prep.ds.LinkedList;

public class ReverseStack {

	static LinkedList top=null;
	static Stack<LinkedList> stack=new Stack<>();
	public static void main(String[] args) {
		LinkedList node=new LinkedList(1);
		LinkedList node1=new LinkedList(2);
		LinkedList node2=new LinkedList(3);
		addToTack(node);
		addToTack(node1);
		addToTack(node2);
		display();
		reverseStack();
		display();
	}
	private static void reverseStack() {
		LinkedList curr=top;
		LinkedList prev=null;
		while(curr!=null)
		{
			LinkedList next=curr.getNext();
			curr.setNext(prev);
			prev=curr;
			curr=next;
		}
		top=prev;
	}
	
	private static void display()
	{
		LinkedList temp=top;
		while(temp!=null)
		{
			System.out.print(temp.getData()+"->");
			temp=temp.getNext();
		}
		System.out.println();
	}
	
	private static void addToTack(LinkedList node) {

		if(top==null)
		{
			top=node;
		}
		else
		{
			node.setNext(top);
			top=node;
		}
	}
}
