package com.amazon.preparation.round2;

import java.util.ArrayList;
import java.util.List;

public class Example1 {

	public static void main(String[] args) {
		
		Node root=new Node(10);
		root.left =new Node(5);
		root.left.left =new Node(3);
		root.left.right =new Node(8);
		root.left.right.left=new Node(7);
		root.right=new Node(20);
		int sum=21;
		
		List<Node> list=new ArrayList<Node>();
		getList(root,list);
		System.out.println(list);
		boolean exists=false;
		int i=0, j=list.size()-1;
		while(i<j)
		{
			if(list.get(i).data+list.get(j).data<sum)
				i++;
			else if(list.get(i).data+list.get(j).data>sum)
				j--;
			else
			{
				exists=true;
				break;
			}
		}
		System.out.println(exists);
	}

	private static void getList(Node root, List<Node> list) 
	{
		if(root==null)
		{
			return;
		}
		
		getList(root.left,list);
		list.add(root);
		getList(root.right,list);
		
		
	}
	
	
}




