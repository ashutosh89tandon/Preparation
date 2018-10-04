package com.designproblems;

import java.util.HashMap;
import java.util.Map;

import com.prep.ds.DoublyLinkedList;

class Employee
{	
	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
}

public class LRUCache {

	private static Map<Integer,Employee> empCache=new HashMap<Integer,Employee>();
	private static DoublyLinkedList<Integer> head=null;
	private static final int SIZE=10;
	private static int currentSize=0;
	
	public static void main(String[] args) {
		
		getEmployeeFromCache(1);
		printList();
		System.out.println();
		getEmployeeFromCache(2);
		printList();
		System.out.println();
		getEmployeeFromCache(3);
		printList();
		System.out.println();
		getEmployeeFromCache(4);
		printList();
		System.out.println();
		getEmployeeFromCache(5);
		printList();
		System.out.println();
		getEmployeeFromCache(6);
		printList();
		System.out.println();
		getEmployeeFromCache(7);
		printList();
		System.out.println();
		getEmployeeFromCache(8);
		printList();
		System.out.println();
		getEmployeeFromCache(9);
		printList();
		System.out.println();
		getEmployeeFromCache(10);
		printList();
		System.out.println();
		getEmployeeFromCache(3);
		printList();
		System.out.println();
		getEmployeeFromCache(11);
		printList();
	}
	
	public static void printList()
	{
		DoublyLinkedList<Integer> temp=head;
		while(temp!=null)
		{
			System.out.print(temp.getData()+"->");
			temp=temp.getNext();
		}
	}
	
	public static Employee getEmployeeFromCache(int empId)
	{
		Employee emp=null;
		if(empCache.get(empId)!=null)
		{
			emp=empCache.get(empId);
			updateLRUWithExistingEntry(empId);
		}
		else
		{
			emp=getEmployeeFromDB(empId);
			updateLRUWithNewEntry(empId,emp);
		}
		
		return emp;
	}
	
	private static void updateLRUWithExistingEntry(int empId) 
	{
		DoublyLinkedList<Integer> temp=head;
		DoublyLinkedList<Integer> prev=null;
		while(temp!=null)
		{
			if(temp.getData().equals(empId))
				break;
			prev=temp;
			temp=temp.getNext();
		}
		if(prev!=null)
		{
			prev.setNext(temp.getNext());
			temp.setNext(head);
			head=temp;
		}
	}

	private static void updateLRUWithNewEntry(int empId, Employee emp) 
	{
		if(currentSize==SIZE)
		{
			DoublyLinkedList<Integer> temp=head;
			DoublyLinkedList<Integer> prev=null;
			while(temp.getNext()!=null)
			{
				prev=temp;
				temp=temp.getNext();
			}
			prev.setNext(null);
			DoublyLinkedList<Integer> currNode=new DoublyLinkedList<>(empId);
			currNode.setNext(head);
			head=currNode;
		}
		else
		{
			currentSize++;
			empCache.put(empId, emp);
			DoublyLinkedList<Integer> currNode=new DoublyLinkedList<>(empId);
			if(head==null)
				head=currNode;
			else
			{
				currNode.setNext(head);
				head=currNode;
			}
		}
	}

	public static Employee getEmployeeFromDB(int empId)
	{
		return new Employee("DB Employee "+empId,empId);
	}
	
}
