package com.prep.ds.linkedlist.circular;

import com.prep.ds.LinkedList;

public class DivideCircularListInTwoHalves 
{
	public static void main(String[] args)
	{
		LinkedList head=UtilMethods.getInitializedCircularList();
		UtilMethods.printCircularList(head);
		System.out.println();
		LinkedList nextHead=divideListInHalf(head);
		UtilMethods.printCircularList(head);
		UtilMethods.printCircularList(nextHead);
	}
	
	private static LinkedList divideListInHalf(LinkedList head) 
	{
		LinkedList fastPointer=head;
		LinkedList slowPointer=head;
		LinkedList prev=null;
		LinkedList fastPrev=null;
		do
		{
			prev=slowPointer;
			slowPointer=slowPointer.getNext();
			fastPrev=fastPointer.getNext();
			fastPointer=fastPointer.getNext().getNext();
		}while((fastPointer!=head));
		
		prev.setNext(head);
		fastPrev.setNext(slowPointer);
		return slowPointer;
	}
}
