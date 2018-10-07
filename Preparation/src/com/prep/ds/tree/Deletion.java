package com.prep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.prep.ds.BinaryTree;

public class Deletion 
{
	public static void main(String[] args) {
		
		BinaryTree<Integer> root=new BinaryTree<Integer>(18, 0);
		root.setLeft(new BinaryTree<Integer>(20, 1));
		root.setRight(new BinaryTree<Integer>(22,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(14, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(12,2));
		print(root);
		System.out.println();
		deleteNode(root, 22);
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
	
	public static void deleteNode(BinaryTree<Integer> root , int key)
	{
		BinaryTree<Integer> node=findNode(root,key);
		if(node==null)
		{
			System.out.println("node not found.");
		}
		replaceWithRightMost(null,root,node);
		
	}

	private static  BinaryTree<Integer> replaceWithRightMost( BinaryTree<Integer> parentNode, BinaryTree<Integer> node, BinaryTree<Integer> deletedNode) 
	{
		if(node==null)
			return null;
		
		 BinaryTree<Integer> rightNode=replaceWithRightMost(node, node.getRight(), deletedNode);
		 if(rightNode==null)
		 {
			 deletedNode.setData(node.getData());
			 parentNode.setRight(null);
		 }
		 
		 return deletedNode;
	}

	private static BinaryTree<Integer> findNode(BinaryTree<Integer> root, int key) 
	{
		Queue<BinaryTree<Integer>> queue=new LinkedList<BinaryTree<Integer>>();
		queue.offer(root);
		BinaryTree<Integer> node=null;
		while(!queue.isEmpty())
		{
			BinaryTree<Integer> tempNode=queue.poll();
			if(tempNode.getData()==key)
			{
				node=tempNode;
				break;
			}
			BinaryTree<Integer> left=tempNode.getLeft();
			BinaryTree<Integer> right=tempNode.getRight();
			
			if(left!=null)
				queue.offer(left);
			if(right!=null)
				queue.offer(right);
		}
		return node;
	}
}
