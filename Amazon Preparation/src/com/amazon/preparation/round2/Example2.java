package com.amazon.preparation.round2;

import java.util.ArrayList;
import java.util.List;

public class Example2 
{
	public static List<Integer> list=new ArrayList<Integer>();
	public static void main(String[] args) {
	
		/*Node root=new Node(10);
		root.left =new Node(5);
		root.left.left =new Node(3);
		root.left.right =new Node(8);
		root.left.right.left=new Node(7);
		root.right=new Node(20);*/
		
		Node root=new Node(1);
		root.left =new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		
		System.out.println(root.data);
		getTopView(root,0);
	}

	private static void getTopView(Node root, int i) 
	{
		if(root==null)
			return;
		if(i!=0 && !list.contains(i))
		{
			System.out.println(root.data);
			list.add(i);
		}
		
		getTopView(root.left,i-1);
		getTopView(root.right,i+1);
		
	}
}
