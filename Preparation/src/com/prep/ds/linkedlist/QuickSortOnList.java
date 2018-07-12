package com.prep.ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

import com.prep.ds.LinkedList;

public class QuickSortOnList 
{
	public static void main(String[] args) 
	{
		LinkedList head=new LinkedList(10);
		head.setNext(new LinkedList(15));
		head.getNext().setNext(new LinkedList(12));
		head.getNext().getNext().setNext(new LinkedList(13));
		head.getNext().getNext().getNext().setNext(new LinkedList(20));
		head.getNext().getNext().getNext().getNext().setNext(new LinkedList(14));
		LinkedList last=head;
		while(last.getNext()!=null)
		{
			last=last.getNext();
		}
		quickSort(head,last);
		
		printList(head);
		
	}

	private static void quickSort(LinkedList first, LinkedList last)
	{
		if(!first.equals(last))
		{
			System.out.println("QuickSort : "+ first+" : "+last);
			//LinkedList partition=getPartition(first,last,prev);
			List<LinkedList> partition=getPartitionData(first,last);
			System.out.println("partition : "+ partition);
			printList(partition.get(1).getNext(),last);
			printList(first,partition.get(0));
			
			quickSort(partition.get(1).getNext(),last);
			quickSort(first,partition.get(0));
		}
	}

	/*public static LinkedList getPartition(LinkedList first, LinkedList last, LinkedList prev) 
	{
		LinkedList node=null;
		LinkedList temp=first;
		LinkedList prevOuter=null;
		LinkedList prevInner=null;
		while(temp.getNext()!=null)
		{
			LinkedList next=temp.getNext();
			if(temp.getData()<temp.getNext().getData())
			{
				prevInner=node;
				if(node==null)
					node=first;
				else
					node=node.getNext();
				swap(node,temp,prevInner,prevOuter);
				prevOuter=node;
			}
			else
			{
				prevOuter=temp;
			}
			
			temp=next;
		}
		prev=node;
		System.out.println("prev : "+prev);
		System.out.println("node.getNext :"+node.getNext());
		return node.getNext();
	}*/
	
	
	private static List<LinkedList> getPartitionData(LinkedList first, LinkedList last) 
	{
		LinkedList node=null;
		LinkedList temp=first;
		List<LinkedList> result=new ArrayList<LinkedList>();
		while(temp.getNext()!=null)
		{
			LinkedList next=temp.getNext();
			if(temp.getData()<temp.getNext().getData())
			{
				if(node==null)
					node=first;
				else
					node=node.getNext();
				int data = node.getData();
				node.setData(temp.getData());
				temp.setData(data);
			}
			temp=next;
		}
		
		LinkedList prev=null;
		if(node==null)
		{
			node=first;
		}
		else
		{
			node=node.getNext();
		}
		int data=node.getData();
		node.setData(last.getData());
		last.setData(data);
		
		result.add(prev==null?node:prev);
		result.add(node);
		return result;
	}

	/*private static void swap(LinkedList inner, LinkedList outer, LinkedList prevInner, LinkedList prevOuter) 
	{
		System.out.println("Inside swap");
		LinkedList outerNext=outer.getNext();
		LinkedList innerNext=inner.getNext();
		inner.setNext(outerNext);
		outer.setNext(innerNext);
		
		if(prevInner!=null)
			prevInner.setNext(outer);
		
		if(prevOuter!=null)
			prevOuter.setNext(inner);
		
		System.out.println("outside swap");
	}*/
	
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
	
	public static  void printList(LinkedList head,LinkedList end)
	{
		LinkedList temp=head;
		while(temp!=null && !temp.equals(end))
		{
			System.out.print(temp+"->");
			temp=temp.getNext();
		}
		if(temp!=null)
			System.out.print(temp);
		System.out.println();
	}
}
