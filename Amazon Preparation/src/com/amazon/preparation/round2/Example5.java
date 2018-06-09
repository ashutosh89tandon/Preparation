package com.amazon.preparation.round2;

public class Example5 
{
	public static void main(String[] args) {
		Node root=new Node(10);
		root.left =new Node(5);
		root.left.left =new Node(3);
		root.left.right =new Node(8);
		root.left.right.left=new Node(7);
		root.right=new Node(20);
		
		createSummedTree(root);
		
		System.out.println(root);
		System.out.println(root.left);
		System.out.println(root.left.left);
		System.out.println(root.left.right);
		System.out.println(root.left.right.left);
		System.out.println(root.right);
	}
	
	public static void createSummedTree(Node root)
	{
		if(root==null)
			return;
		
		createSummedTree(root.left);
		createSummedTree(root.right);
		
		int dataR=0;
		if(root.right!=null)
			dataR=root.right.data;
		
		int dataL=0;
		if(root.left!=null)
			dataL=root.left.data;
		
		root.data=root.data+dataR+dataL;	
	}
}
