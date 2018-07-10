package com.prep.ds;

public class CharLinkedList 
{
	private char data;
	private CharLinkedList next;
	public int getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
	public CharLinkedList getNext() {
		return next;
	}
	public void setNext(CharLinkedList next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "LinkedList [data=" + data + "]";
	}
	public CharLinkedList(char data) {
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
		CharLinkedList other = (CharLinkedList) obj;
		if (data != other.data)
			return false;
		return true;
	}
	
	
}
