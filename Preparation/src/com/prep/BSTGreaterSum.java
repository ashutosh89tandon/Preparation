package com.prep;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.prep.ds.Node;

public class BSTGreaterSum 
{
	public static void main(String[] args) 
	{
		Node node=new Node(11);
		node.left=new Node(2);
		node.left.left=new Node(1);
		node.left.right=new Node(7);
		node.right=new Node(29);
		node.right.left=new Node(15);
		node.right.right=new Node(40);
		node.right.right.left=new Node(35);
		
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("sum", 0);
		findSummedTree(node,map);
		traverseDFS(node);
	}

	private static void traverseDFS(Node node) {
		
		Queue<Node> queue=new LinkedList<Node>();
		queue.offer(node);
		
		while(!queue.isEmpty())
		{
			System.out.print(queue.peek().data+"->");
			Node node1=queue.poll();
			
			if(node1.left!=null)
				queue.offer(node1.left);
			if(node1.right!=null)
				queue.offer(node1.right);
		}
		
	}

	private static void findSummedTree(Node node,Map<String,Integer> map) 
	{
		if(node==null)
			return;
		
		findSummedTree(node.right, map);
		map.put("sum", map.get("sum")+node.data);
		node.data=map.get("sum")-node.data;
		findSummedTree(node.left, map);	}
}
