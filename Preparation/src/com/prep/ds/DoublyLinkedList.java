package com.prep.ds;

public class DoublyLinkedList 
{
	private int data;
	private DoublyLinkedList next;
	private DoublyLinkedList prev;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DoublyLinkedList getNext() {
		return next;
	}
	public void setNext(DoublyLinkedList next) {
		this.next = next;
	}
	public DoublyLinkedList getPrev() {
		return prev;
	}
	public void setPrev(DoublyLinkedList prev) {
		this.prev = prev;
	}
	@Override
	public String toString() {
		return "DoublyLinkedList [data=" + data + "]";
	}
	public DoublyLinkedList(int data) {
		super();
		this.data = data;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoublyLinkedList other = (DoublyLinkedList) obj;
		if (data != other.data)
			return false;
		return true;
	}
	
	
}
