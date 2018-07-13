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
		head=quickSort(head,last);
		
		printList(head);
		
	}

	private static LinkedList quickSort(LinkedList head, LinkedList end)
	{
		// base condition
	    if (head==null || head == end)
	        return head;
	 
	    LinkedList newHead = null, newEnd = null,pivot=null;
	 
	    // Partition the list, newHead and newEnd will be updated
	    // by the partition function
	    List<LinkedList> partition = getPartition(head, end);
	 
	    newHead=partition.get(0);
	    newEnd=partition.get(1);
	    pivot=partition.get(2);
	    // If pivot is the smallest element - no need to recur for
	    // the left part.
	    if (newHead != pivot)
	    {
	        // Set the node before the pivot node as NULL
	    	LinkedList tmp = newHead;
	        while (!tmp.getNext().equals(pivot))
	            tmp = tmp.getNext();
	        tmp.setNext(null);
	 
	        // Recur for the list before pivot
	        newHead = quickSort(newHead, tmp);
	 
	        // Change next of last node of the left half to pivot
	        LinkedList node=newHead;
	        while(node!=null && node.getNext()!=null)
	        	node=node.getNext();
	  
	        node.setNext(pivot);
	    }
	 
	    // Recur for the list after the pivot element
	    pivot.setNext(quickSort(pivot.getNext(), newEnd));
	 
	    return newHead;
	}

	public static List<LinkedList> getPartition(LinkedList first, LinkedList last) 
	{
		LinkedList pivot = last;
		LinkedList prev = null, cur = first, tail = pivot;
		LinkedList newHead = null,  newEnd = null;
		List<LinkedList> result=new ArrayList<LinkedList>();
	 
	    // During partition, both the head and end of the list might change
	    // which is updated in the newHead and newEnd variables
	    while (!cur.equals(pivot))
	    {
	        if (cur.getData() < pivot.getData())
	        {
	            // First node that has a value less than the pivot - becomes
	            // the new head
	            if ((newHead) == null)
	                (newHead) = cur;
	 
	            prev = cur;  
	            cur = cur.getNext();
	        }
	        else // If cur node is greater than pivot
	        {
	            // Move cur node to next of tail, and change tail
	            if (prev!=null)
	                prev.setNext(cur.getNext());
	            LinkedList next = cur.getNext();
	            cur.setNext(null);
	            tail.setNext(cur);;
	            tail = cur;
	            cur = next;
	        }
	    }
	 
	    // If the pivot data is the smallest element in the current list,
	    // pivot becomes the head
	    if ((newHead) == null)
	        (newHead) = pivot;
	 
	    // Update newEnd to the current last node
	    (newEnd) = tail;
	 
	    result.add(newHead);
	    result.add(newEnd);
	    result.add(pivot);
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
