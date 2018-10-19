package com.prep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.prep.ds.BinaryTree;

public class TreeFromInAndPost
{
	static int in[]   = {4, 8, 2, 5, 1, 6, 3, 7};
	static int post[] = {8, 4, 5, 2, 6, 7, 3, 1} ;
	static int postIndex=post.length-1;
	public static void main(String[] args) {
		BinaryTree<Integer> root = constructTree(0,in.length-1);
		print(root);
	}
	
	private static BinaryTree<Integer> constructTree(int start, int end)
	{
		if(start>end)
			return null;

		BinaryTree<Integer> node=new BinaryTree<Integer>(post[postIndex--]);
		int current=findInOrderIndex(node.getData(), start, end);
		node.setRight(constructTree(current+1, end));
		node.setLeft(constructTree(start, current-1));
		return node;
		
	}

	private static int findInOrderIndex(int value,int start,int end) {
		for(int i=start;i<=end;i++)
			if(value==in[i])
				return i;
		return -1;
	}
	
	private static void print(BinaryTree<Integer> root) 
	{
		Queue<BinaryTree<Integer>> queue=new LinkedList<BinaryTree<Integer>>();
		queue.offer(root);
		while(!queue.isEmpty())
		{
			BinaryTree<Integer> tempNode=queue.poll();
			System.out.print(tempNode.getData()+"->");
			BinaryTree<Integer> left=tempNode.getLeft();
			BinaryTree<Integer> right=tempNode.getRight();
			
			if(left!=null)
				queue.offer(left);
			if(right!=null)
				queue.offer(right);
		}
	}
}
