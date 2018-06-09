package com.amazon.preparation.round2;

import java.util.LinkedList;
import java.util.Queue;

public class BFS 
{
	public static void main(String[] args) {
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		
		System.out.println("BFS traversal");
		bfsTraversal(root);
	}
	
	public static void bfsTraversal(Node root)
	{
		
		Queue< Node> queue=new LinkedList<Node>();
		queue.offer(root);
		while(!queue.isEmpty())
		{
			Node node=queue.poll();
			System.out.print(node.data+"->");
			
			if(node.left!=null)
				queue.offer(node.left);
			
			if(node.right!=null)
				queue.offer(node.right);
		}
		
	}
}
