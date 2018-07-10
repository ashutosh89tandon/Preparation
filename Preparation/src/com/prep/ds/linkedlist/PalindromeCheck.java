package com.prep.ds.linkedlist;

import java.util.Stack;

import com.prep.ds.CharLinkedList;

public class PalindromeCheck 
{
	public static void main(String[] args) {
		
		CharLinkedList head=new CharLinkedList('R');
		head.setNext(new CharLinkedList('A'));
		head.getNext().setNext(new CharLinkedList('D'));
		head.getNext().getNext().setNext(new CharLinkedList('A'));
		head.getNext().getNext().getNext().setNext(new CharLinkedList('R'));
		//head.getNext().getNext().getNext().getNext().setNext(new CharLinkedList('A'));
		System.out.println("Method 1 :"+isPalindrome(head));
		System.out.println("Method 2 :"+isPalindrome1(head));
	}

	private static boolean isPalindrome(CharLinkedList head) 
	{
		CharLinkedList temp = head;
		Stack<CharLinkedList> stack=new Stack<CharLinkedList>();
		while(temp!=null)
		{
			stack.push(temp);
			temp=temp.getNext();
		}
		
		CharLinkedList node=head;
		temp=stack.pop();
		while(!stack.isEmpty())
		{
			if(!node.equals(temp))
				return false;
			
			node=node.getNext();
			temp=stack.pop();
		}
		
		return true;
	}
	
	private static boolean isPalindrome1(CharLinkedList head)
	{
		CharLinkedList pointer=head;
		CharLinkedList fast_pointer=head;
		
		while(fast_pointer!=null && fast_pointer.getNext()!=null)
		{
			pointer=pointer.getNext();
			fast_pointer=fast_pointer.getNext().getNext();
		}
		
		CharLinkedList temp=pointer.getNext();
		CharLinkedList prev=null;
		while(temp!=null)
		{
			CharLinkedList next=temp.getNext();
			temp.setNext(prev);
			prev=temp;
			temp=next;
		}
		
		temp=prev;
		CharLinkedList node=head;
		while(temp!=null)
		{
			if(!temp.equals(node))
				return false;
			
			node=node.getNext();
			temp=temp.getNext();
		}
		
		return true;
	}
	
	public static  void printList(CharLinkedList head)
	{
		CharLinkedList temp=head;
		
		while(temp!=null)
		{
			System.out.print(temp+"->");
			temp=temp.getNext();
		}
		System.out.println();
	}
}
