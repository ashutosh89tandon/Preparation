package com.amazon.preparation;


public class Example8
{
	public static void main(String args[])
	{
		Node node=new Node(50);
		node.left=new Node(7);
		node.right=new Node(2);
		node.left.left=new Node(3);
		node.left.right=new Node(5);
		node.right.left=new Node(1);
		node.right.right=new Node(30);
		
		createBalancedTree(node);
		
		System.out.println(node);
		System.out.println(node.left);
		System.out.println(node.right);
		System.out.println(node.left.left);
		System.out.println(node.left.right);
		System.out.println(node.right.left);
		System.out.println(node.right.right);
		
	}
	
	public static void createBalancedTree(Node node)
	{
		if(node==null || node.right==null || node.left==null)
			return;
		
		
		createBalancedTree(node.left);
		createBalancedTree(node.right);
		
		if(node.data>node.right.data+node.left.data)
		{
			node.left.data+=(node.data-node.right.data-node.left.data);
			createBalancedTree(node.left);
		}
		if(node.data<node.right.data+node.left.data)
		{
			node.data+=node.right.data+node.left.data-node.data;
		}
		
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