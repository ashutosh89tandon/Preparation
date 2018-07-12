package com.prep.ds.linkedlist;

import com.prep.ds.LinkedList;

public class IntersectionOfTwoLists 
{
	public static void main(String[] args) {
		LinkedList first=new LinkedList(1);
		first.setNext(new LinkedList(2) );
		first.getNext().setNext(new LinkedList(3));
		first.getNext().getNext().setNext(new LinkedList(4));
		LinkedList second=new LinkedList(2);
		second.setNext(new LinkedList(3) );
		second.getNext().setNext(new LinkedList(4));
		LinkedList intersect=findIntersect(first,second);
		
		printList(intersect);
	}
	

	private static LinkedList findIntersect(LinkedList first, LinkedList second) 
	{
		if(first==null || second==null)
			return null;
		
		if(first.getData()>second.getData())
			return findIntersect(first, second.getNext());
		else if(first.getData()<second.getData())
			return findIntersect(first.getNext(), second);
		
		LinkedList result=new LinkedList(first.getData());
		System.out.println(result);
		result.setNext(findIntersect(first.getNext(), second.getNext()));
		
		return result;
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
