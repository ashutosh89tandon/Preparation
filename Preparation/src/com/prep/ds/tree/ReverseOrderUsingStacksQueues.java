package com.prep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.prep.ds.BinaryTree;

public class ReverseOrderUsingStacksQueues 
{
	public static void main(String[] args) {
		BinaryTree<Integer> root=new BinaryTree<Integer>(18, 0);
		root.setLeft(new BinaryTree<Integer>(20, 1));
		root.setRight(new BinaryTree<Integer>(22,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(14, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(12,2));
		root.getRight().setLeft(new BinaryTree<Integer>(25, 2));
		root.getRight().setRight(new BinaryTree<Integer>(21,2));
		root.getLeft().getLeft().setLeft(new BinaryTree<Integer>(16, 3));
		root.getLeft().getLeft().setRight(new BinaryTree<Integer>(19,3));
		printReverseOrder(root);
	}

	private static void printReverseOrder(BinaryTree<Integer> root) 
	{
		int previousLevel=0;
		Stack<Queue<BinaryTree<Integer>>> stack=new Stack<>();
		Queue<BinaryTree<Integer>> mainQueue=new LinkedList<>();
		Queue<BinaryTree<Integer>> levelQueue=new LinkedList<>();
		mainQueue.offer(root);
		while(!mainQueue.isEmpty())
		{
			BinaryTree<Integer> node=mainQueue.poll();
			BinaryTree<Integer> left=node.getLeft();
			BinaryTree<Integer> right=node.getRight();
			if(left!=null)
				mainQueue.offer(left);
			if(right!=null)
				mainQueue.offer(right);
			
			if(node.getLevel()>previousLevel)
			{
				previousLevel++;
				stack.push(levelQueue);
				levelQueue=new LinkedList<>();
				levelQueue.offer(node);
			}
			else
			{
				levelQueue.offer(node);
			}
		}
		
		if(!levelQueue.isEmpty())
			stack.push(levelQueue);

		while(!stack.isEmpty())
		{
			Queue<BinaryTree<Integer>> queue=stack.pop();
			while(!queue.isEmpty())
			{
				System.out.print(queue.poll().getData()+"->");
			}
		}
	}
}
