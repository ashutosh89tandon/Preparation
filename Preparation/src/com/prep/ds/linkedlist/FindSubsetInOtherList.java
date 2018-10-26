package com.prep.ds.linkedlist;

import com.prep.ds.LinkedList;

public class FindSubsetInOtherList 
{
	public static void main(String[] args) {
		LinkedList head1=new LinkedList(1);
		head1.setNext(new LinkedList(2));
		head1.getNext().setNext(new LinkedList(3));
		head1.getNext().getNext().setNext(new LinkedList(4));
		LinkedList head2=new LinkedList(1);
		head2.setNext(new LinkedList(2));
		head2.getNext().setNext(new LinkedList(1));
		head2.getNext().getNext().setNext(new LinkedList(2));
		head2.getNext().getNext().getNext().setNext(new LinkedList(3));
		head2.getNext().getNext().getNext().getNext().setNext(new LinkedList(3));
		System.out.println("Is subset : "+isSubset(head1,head2));
	}

	private static boolean isSubset(LinkedList head1, LinkedList head2) {
		
		if(head1==null || head2 ==null)
			return false;
		
		LinkedList temp2=head2;
		while(temp2!=null)
		{
			boolean found=false;
			LinkedList temp1=head1;
			if(temp1.getData()==temp2.getData())
			{
				while(temp1!=null && temp2!=null)
				{
					found=true;
					if(temp1.getData()!=temp2.getData())
					{
						found=false;
						break;
					}
					temp1=temp1.getNext();
					temp2=temp2.getNext();
				}
			}
			else
			{
				temp2=temp2.getNext();
			}
			if(found)
				return true;
		}
		
		return false;
	}
}
