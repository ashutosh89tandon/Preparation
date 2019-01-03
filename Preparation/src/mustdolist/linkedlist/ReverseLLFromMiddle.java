package mustdolist.linkedlist;

import com.prep.ds.LinkedList;

public class ReverseLLFromMiddle {
	public static void main(String[] args)
	{
		LinkedList head=new LinkedList(10);
		head.setNext(new LinkedList(15));
		head.getNext().setNext(new LinkedList(12));
		head.getNext().getNext().setNext(new LinkedList(13));
		head.getNext().getNext().getNext().setNext(new LinkedList(20));
		head.getNext().getNext().getNext().getNext().setNext(new LinkedList(14));
		reverseFromMiddle(head);
		printList(head);
	}
	
	private static void reverseFromMiddle(LinkedList head) {
		LinkedList slowPtr=head;
		LinkedList fastPtr=head;
		LinkedList ptr=null;
		LinkedList prev=null;
		while(slowPtr.getNext()!=null && fastPtr.getNext()!=null && fastPtr.getNext().getNext()!=null)
		{
			slowPtr=slowPtr.getNext();
			fastPtr=fastPtr.getNext().getNext();
		}
		ptr=slowPtr.getNext();
		while(ptr!=null)
		{
			LinkedList next=ptr.getNext();
			ptr.setNext(prev);
			prev=ptr;
			ptr=next;
			
			if(ptr==null)
				slowPtr.setNext(prev);
		}
		
		
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
