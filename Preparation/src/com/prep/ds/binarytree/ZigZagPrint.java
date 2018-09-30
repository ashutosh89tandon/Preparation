package com.prep.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.prep.ds.BinaryTree;

public class ZigZagPrint {

	private static Queue<BinaryTree<Integer>> queue=new LinkedList<BinaryTree<Integer>>();
	public static void main(String args[])
	{
		BinaryTree<Integer> root=new BinaryTree<Integer>(18, 0);
		root.setLeft(new BinaryTree<Integer>(20, 1));
		root.setRight(new BinaryTree<Integer>(22,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(14, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(12,2));
		root.getRight().setLeft(new BinaryTree<Integer>(25, 2));
		root.getRight().setRight(new BinaryTree<Integer>(21,2));
		root.getLeft().getRight().setLeft(new BinaryTree<Integer>(16, 3));
		root.getLeft().getRight().setRight(new BinaryTree<Integer>(19,3));
		queue.offer(root);
		printZigZag();
	}
	
	private static void printZigZag() 
	{
		Stack<BinaryTree<Integer>> stack=new Stack<BinaryTree<Integer>>();
		
		while(!queue.isEmpty())
		{
			BinaryTree<Integer> node=queue.poll();
			System.out.print(node.getData()+"->");
			BinaryTree<Integer> left=node.getLeft();
			BinaryTree<Integer> right=node.getRight();
			
			if(left!=null && left.getLevel()%2==1)
			{
				queue.offer(left);
			}
			if(right!=null && right.getLevel()%2==1)
			{
				queue.offer(right);
			}
			
			if(left!=null && left.getLevel()%2==0)
			{
				stack.push(left);
			}
			if(right!=null && right.getLevel()%2==0)
			{
				stack.push(right);
			}
			
			if(queue.isEmpty() && !stack.isEmpty())
			{
				while(!stack.isEmpty())
					queue.offer(stack.pop());
			}
		}
	}
}
