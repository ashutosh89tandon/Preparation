package prep.round2;

import java.util.Arrays;
import java.util.List;

public class Example1
{
	public static void main(String[] args) 
	{
		Long a[]= {5L,1L,3L,2L,8L};
		
		DoublyLinkedList node=new DoublyLinkedList(3);
		node.next=new DoublyLinkedList(2);
		node.next.next=new DoublyLinkedList(5);
		node.next.next.next=new DoublyLinkedList(8);
		node.next.next.next.next=new DoublyLinkedList(5);
		node.next.next.next.next.next=new DoublyLinkedList(2);
		node.next.next.next.next.next.next=new DoublyLinkedList(1);
		
		getSortedListbasedOnArray(a,node);
		traverse(node);
		
	}

	private static void getSortedListbasedOnArray(Long[] a, DoublyLinkedList node) 
	{
		DoublyLinkedList temp=node;
		List<Long>  list=Arrays.asList(a);
		while(temp!=null)
		{
			swapAsPerArray(list,temp);
			
			temp=temp.next;
		}
		
	}
	
	private static void swapAsPerArray(List<Long> list, DoublyLinkedList node) 
	{
		int index=list.indexOf(node.data);
		
		DoublyLinkedList temp=node.next;
		while(temp!=null)
		{
			int i=list.indexOf(temp.data);
			if(i<index)
			{
				index=i;
				long data=temp.data;
				temp.data=node.data;
				node.data=data;
				
			}
			
			temp=temp.next;
		}
		
		
	}

	private static void traverse(DoublyLinkedList n)
	{
		DoublyLinkedList temp=n;
		while(temp!=null)
		{
			System.out.println(temp);
			temp=temp.next;
		}
	}
}
