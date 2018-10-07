package com.prep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.prep.ds.BinaryTree;

public class Insertion 
{
	public static void main(String args[])
	{
		BinaryTree<Integer> root=new BinaryTree<Integer>(18, 0);
		root.setLeft(new BinaryTree<Integer>(20, 1));
		root.setRight(new BinaryTree<Integer>(22,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(14, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(12,2));
		print(root);
		System.out.println();
		insert(root,16);
		print(root);
		
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

	public static void insert(BinaryTree<Integer> node,int key)
	{
		Queue<BinaryTree<Integer>> queue=new LinkedList<BinaryTree<Integer>>();
		queue.offer(node);
		while(!queue.isEmpty())
		{
			BinaryTree<Integer> tempNode=queue.poll();
			BinaryTree<Integer> left=tempNode.getLeft();
			BinaryTree<Integer> right=tempNode.getRight();
			
			if(left!=null)
				queue.offer(left);
			else
			{
				tempNode.setLeft(new BinaryTree<Integer>(key));
				break;
			}
			if(right!=null)
				queue.offer(right);
			else 
			{
				tempNode.setRight(new BinaryTree<Integer>(key));
				break;
			}
		}
	}
}
