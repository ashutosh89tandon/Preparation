package example7;

import java.util.HashMap;
import java.util.Map;

public class Example7 
{
	public static void main(String[] args)
	{
		Map<Integer,Node> linkedMap=new HashMap<Integer,Node>();
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.right=new Node(7);
		populateLinkedMap(root,linkedMap,0);
		
		for(int i=0;i<linkedMap.keySet().size();i++)
		{
			System.out.println("Level : "+i);
			Node node=linkedMap.get(i);
			
			while(node!=null)
			{
				System.out.print(node.data+"->");
				node=node.next;
			}
			System.out.print("NULL");
			System.out.println();
		}
	}

	private static void populateLinkedMap(Node node,Map<Integer, Node> linkedMap, int i) 
	{
		
		if(node==null)
			return;
		populateLinkedMap(node.left,linkedMap, i+1);
		populateLinkedMap(node.right, linkedMap, i+1);
		
		if(linkedMap.get(i)==null)
			linkedMap.put(i, node);
		else
		{
			Node oldNode=linkedMap.get(i);
			Node tempNode=oldNode;
			while(tempNode!=null)
			{
				if(tempNode.next==null)
				{
					tempNode.next=node;
					break;
				}
				tempNode=tempNode.next;
			}
			
			linkedMap.put(i, oldNode);
		}
	}
	
	
}

class Node
{
	public int data;
	public Node left;
	public Node right;
	public Node next;
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	public Node(int data) {
		super();
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	@Override
	public String toString()
	{
		return "Node : "+data;
	}
	
}


