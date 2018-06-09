package prep.round2;

public class DoublyLinkedList 
{
	DoublyLinkedList next;
	DoublyLinkedList prev;
	long data;
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
	public long getData() {
		return data;
	}
	public void setData(long data) {
		this.data = data;
	}
	public DoublyLinkedList(int data) {
		super();
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "DoublyLinkedList [data=" + data + "]";
	}
	
	
	
}
