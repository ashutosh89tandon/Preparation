package example2;
import java.util.ArrayList;
import java.util.List;

public class Example2 
{
	public static void main(String args[])
	{
		List<Node> nodes=new ArrayList<Node>();

		Node root=new Node(8);
		root.left =new Node(7);
		root.left.left =new Node(3);
		root.left.left.right =new Node(4);
		root.left.left.left=new Node(2);
		root.left.left.left.left=new Node(1);
		root.left.left.left.left.left=new Node(0);
		root.right=new Node(10);
		root.right.right=new Node(11);
		root.right.right.right=new Node(12);
		root.right.right.right.right=new Node(13);
		root.right.right.right.right.right=new Node(14);
		
		getNodesAtDistance(5, root, nodes);
		System.out.println(nodes);
		
	}
	
	public static void getNodesAtDistance(int k, Node node, List<Node> nodes)
	{
		if(node==null)
			return;
		if(k==0)
		{
			nodes.add(node);
			return;
		}
		
		getNodesAtDistance(k-1, node.getRight(), nodes);
		getNodesAtDistance(k-1, node.getLeft(), nodes);
		
		return;
	}
	
	
}


class Node
{
	public int data;
	public Node left;
	public Node right;
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


