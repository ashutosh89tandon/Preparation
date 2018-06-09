package com.amazon.preparation.round2;

public class DFS {

	public static void main(String[] args) 
	{
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		
		System.out.println("Preorder : ");
		preOrder(root);
		System.out.println();
		System.out.println("Inorder : ");
		inOrder(root);
		System.out.println();
		System.out.println("Postorder : ");
		postOrder(root);
	}
	
	public static void preOrder(Node root)
	{
		if(root==null)
			return;
		
		System.out.print(root.data+"->");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void inOrder(Node root)
	{
		if(root==null)
			return;
		
		
		inOrder(root.left);
		System.out.print(root.data+"->");
		inOrder(root.right);
	}
	
	public static void postOrder(Node root)
	{
		if(root==null)
			return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+"->");
	}
}
