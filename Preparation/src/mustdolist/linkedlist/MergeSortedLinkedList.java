package mustdolist.linkedlist;

import com.prep.ds.DoublyLinkedList;

public class MergeSortedLinkedList {

	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> dl1=new DoublyLinkedList<>(10);
		dl1.setNext(new DoublyLinkedList<>(12));
		dl1.getNext().setNext(new DoublyLinkedList<>(14));
		DoublyLinkedList<Integer> dl2=new DoublyLinkedList<>(7);
		dl2.setNext(new DoublyLinkedList<>(13));
		dl2.getNext().setNext(new DoublyLinkedList<>(15));
		mergeList(dl1,dl2);
		
		DoublyLinkedList<Integer> temp=dl2;
		while(temp!=null)
		{
			System.out.print(temp.getData()+" ");
			temp=temp.getNext();
		}
	}

	private static void mergeList(DoublyLinkedList<Integer> dl1, DoublyLinkedList<Integer> dl2) 
	{
		DoublyLinkedList<Integer> ptr1=dl1;
		DoublyLinkedList<Integer> ptr2=dl2;
		DoublyLinkedList<Integer>  prev=null;
		while(ptr1!=null && ptr2!=null)
		{
			while(ptr1!=null && ptr1.getData()<ptr2.getData())
			{
				prev=ptr1;
				ptr1=ptr1.getNext();
			}
			
			if(ptr1==null)
			{
				while(ptr2!=null)
				{
					DoublyLinkedList<Integer> next=ptr2.getNext();
					ptr2.setNext(prev.getNext());
					prev.setNext(ptr2);
					prev=ptr2;
					ptr2=next;
				}
			}
			else
			{
				while(ptr2!=null && ptr2.getData()<ptr1.getData())
				{
					DoublyLinkedList<Integer> next=ptr2.getNext();
					ptr2.setNext(prev==null?ptr1:prev.getNext());
					if(prev!=null)prev.setNext(ptr2);
					prev=ptr2;
					ptr2=next;
				}
			}
			
		}
		while(ptr1!=null)
		{
			prev.setNext(ptr1);
			prev=ptr1;
			ptr1=ptr1.getNext();
		}
		while(ptr2!=null)
		{
			prev.setNext(ptr2);
			prev=ptr2;
			ptr2=ptr2.getNext();
		}
	}
}
