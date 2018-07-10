package com.prep.ds.linkedlist;

import com.prep.ds.LinkedList;

public class LoopDetection 
{
	public static void main(String[] args)
	{
		LinkedList head=new LinkedList(1);
		LinkedList second=new LinkedList(2);
		head.setNext(second);
		second.setNext(new LinkedList(3));
		second.getNext().setNext(new LinkedList(4));
		second.getNext().getNext().setNext(new LinkedList(5));
		second.getNext().getNext().getNext().setNext(second);
		System.out.println("If loop exists "+loopExists(head));
		
		
	}

	private static boolean loopExists(LinkedList head) {
		
		LinkedList pointer=head;
		LinkedList fast_pointer=head;
		
		while(pointer!=null && fast_pointer!=null && fast_pointer.getNext()!=null)
		{
			pointer=pointer.getNext();
			fast_pointer=fast_pointer.getNext().getNext();
			System.out.println(pointer);
			System.out.println(fast_pointer);
			
			if(pointer.equals(fast_pointer))
				return true;
		}
		return false;
	}
}
