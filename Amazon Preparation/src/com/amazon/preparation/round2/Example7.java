package com.amazon.preparation.round2;

import java.util.ArrayList;
import java.util.List;

public class Example7 
{
	static List<Integer> list=new ArrayList<Integer>();
	public static void main(String[] args) 
	{
		Node root=new Node(20);
		root.left =new Node(8);
		root.right=new Node(22);
		root.left.left =new Node(4);
		root.left.right =new Node(12);
		root.left.right.left =new Node(10);
		root.left.right.right =new Node(14);
		root.right.right=new Node(25);
		
		System.out.println(root);
		printBoundaryNodes(root, 0);
	}
	
	public static void printBoundaryNodes(Node node,int index)
	{
		if(node==null)
			return;
		printBoundaryNodes(node.left, index-1);
		printBoundaryNodes(node.right, index+1);
		
		if(index!=0 && !list.contains(index))
		{
			System.out.println(node);
		}
		else if(index!=0 && list.contains(index) && node.left==null && node.right==null)
		{
			System.out.println(node);
		}
	}
}
