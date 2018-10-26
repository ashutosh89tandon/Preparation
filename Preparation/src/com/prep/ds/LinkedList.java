package com.prep.ds;

public class LinkedList
{
	private int data;
	private LinkedList next;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkedList getNext() {
		return next;
	}
	public void setNext(LinkedList next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "LinkedList [data=" + data + "]";
	}
	public LinkedList(int data) {
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
		LinkedList other = (LinkedList) obj;
		if (data != other.data)
			return false;
		return true;
	}
	
	
}
