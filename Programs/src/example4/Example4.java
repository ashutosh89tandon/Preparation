package example4;

import java.util.ArrayList;
import java.util.Arrays;

public class Example4 

{
	public static void main(String args[])
	{
		Node root=new Node(10);
		root.left =new Node(5);
		root.left.left =new Node(3);
		root.left.right =new Node(8);
		root.left.right.left=new Node(7);
		root.right=new Node(20);
		
		StringBuilder str=serializeData(root, new StringBuilder(""));
		System.out.println(str);
		
		Node node=deSerializeData(str.toString());
		
		System.out.println(node);
		System.out.println(node.left );
		System.out.println(node.right);
		System.out.println(node.left.left );
		System.out.println(node.left.right.left);
		System.out.println(node.left.right);
		
		
		System.out.println(serializeData(node, new StringBuilder("")));
	}
	
	public static StringBuilder serializeData(Node n, StringBuilder str)
	{	
		System.out.println("Input "+str);
		
		if(n==null)
		{
			str.append(",null");
		}
		
		else
		{
			if(str.toString().equals(""))
			{
				str.append(""+n.data);
			}
			else
			{
				str.append(","+n.data);
			}
			
			serializeData(n.left, str);
			serializeData(n.right, str);
		}
		
		return str;
	}
	
	public static Node deSerializeData(String str)
	{
		Node node=null;
		
		node = createNode(new ArrayList<String>(Arrays.asList(str.split(","))));
		
		return node;
	}

	private static Node createNode(ArrayList<String> data) {
		
		if(data.get(0).equals("null")) 
		{	
			data.remove(0);
			return null;
		}
		Node node=new Node(Integer.valueOf(data.get(0)));
		data.remove(0);
		
		node.left=createNode(data);
		node.right=createNode(data);
		
		return node;
	}
	
	
}

class Node
{
	public int data;
	public Node left=null;
	public Node right=null;
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
