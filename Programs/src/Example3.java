
public class Example3 
{
	public static void main(String ar[])
	{
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		Node node5=new Node(5);
		
		node1.setNext(node2);
		node1.setArbitrary(node3);
		
		node2.setArbitrary(node1);
		node2.next=node3;
		
		node3.arbitrary=node5;
		node3.next=node4;
		
		node4.arbitrary=node3;
		node4.next=node5;
		
		node5.arbitrary=node2;
		node5.next=null;
		
		traverseNext(node1);
		System.out.println();
		Node node=copyList(node1);
		traverseNext(node);
	}
	
	private static Node copyList(Node node1) 
	{
		Node tempNode=node1;
		while(tempNode!=null)
		{
			Node node=new Node(tempNode.data);
			node.next=tempNode.next;
			tempNode.next=node;
			
			tempNode=tempNode.next.next;
		}
		
		tempNode=node1;
		while(tempNode!=null)
		{
			tempNode.next.arbitrary=tempNode.arbitrary.next;
			tempNode=tempNode.next.next;
		}
		
		Node copy=node1.next;
		Node returnNode=node1.next;
		while(copy!=null)
		{
			node1.next=node1.next.next;
			if(copy.next!=null)
				copy.next=copy.next.next;
			else
				copy.next=null;
			
			node1=node1.next;
			copy=copy.next;
		}
		
		return returnNode;
		
	}

	public static void traverseNext(Node n)
	{
		Node node=n;
		while(node !=null)
		{
			System.out.print(" Node : "+node.data+" Arbitrary: "+node.arbitrary.data);
			node=node.next;
		}
	}
	
}

class Node
{
	public int data;
	public Node next;
	public Node arbitrary;
	
	
	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	public Node getNext() {
		return next;
	}


	public void setNext(Node next) {
		this.next = next;
	}


	public Node getArbitrary() {
		return arbitrary;
	}


	public void setArbitrary(Node arbitrary) {
		this.arbitrary = arbitrary;
	}

	
	
	public Node(int data) {
		super();
		this.data = data;
	}


	@Override
	public String toString()
	{
		return "Node : "+data;
	}
	
}