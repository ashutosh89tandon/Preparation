package com.prep.ds;

public class DoublyLinkedList<T>
{
	private T data;
	private DoublyLinkedList<T> next;
	private DoublyLinkedList<T> prev;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public DoublyLinkedList<T> getNext() {
		return next;
	}
	public void setNext(DoublyLinkedList<T> next) {
		this.next = next;
	}
	public DoublyLinkedList<T> getPrev() {
		return prev;
	}
	public void setPrev(DoublyLinkedList<T> prev) {
		this.prev = prev;
	}
	@Override
	public String toString() {
		return "DoublyLinkedList [data=" + data + "]";
	}
	public DoublyLinkedList(T data) {
		super();
		this.data = data;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Double.valueOf(Math.random()*1000).intValue();
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoublyLinkedList<T> other = (DoublyLinkedList<T>) obj;
		if (data != other.data)
			return false;
		return true;
	}
	public DoublyLinkedList() {
		super();
	}
	
	
}
