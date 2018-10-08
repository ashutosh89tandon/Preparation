package com.prep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.prep.ds.BinaryTree;

public class AVLTree {

	
	public static void main(String[] args) 
	{ 

		/* Constructing tree given in the above figure */
		BinaryTree<Integer> root = insert(null, 9);  
		print(root);
		root = insert(root, 5); 
		print(root);
		root = insert(root, 10);  
		print(root);
		root = insert(root, 0);  
		print(root);
		root = insert(root, 6);  
		print(root);
		root = insert(root, 11);  
		print(root);
		root = insert(root, -1);  
		print(root);
		root = insert(root, 1); 
		print(root);
		root = insert(root, 2);  
		print(root);
		
		root=deleteNode(root,5);
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
		
		System.out.println();
	}
	
	public static  int getHeight(BinaryTree<Integer> node)
	{
		if(node==null)
			return 0;
		else
			return Math.max(getHeight(node.getLeft()),getHeight(node.getRight()))+1;
	}
	
	public static int getBalance(BinaryTree<Integer> node)
	{
		if(node==null)
			return 0;

		return getHeight(node.getLeft())-getHeight(node.getRight());
	}
	
	public static BinaryTree<Integer> leftRotate(BinaryTree<Integer> node)
	{
		BinaryTree<Integer> right=node.getRight();
		node.setRight(right.getLeft());
		right.setLeft(node);
		return right;
	}
	
	public static BinaryTree<Integer> rightRotate(BinaryTree<Integer> node)
	{
		BinaryTree<Integer> left=node.getLeft();
		node.setLeft(left.getRight());
		left.setRight(node);
		return left;
	}
	
	public static BinaryTree<Integer> insert(BinaryTree<Integer> node,int key)
	{
		if(node==null)
			return new BinaryTree<Integer>(key);
		
		if(node.getData()>key)
			node.setLeft(insert(node.getLeft(), key));
		else if(node.getData()<key)
			node.setRight(insert(node.getRight(), key));
		else
			return node;
		
		int balance=getBalance(node);
		
		if(balance<-1 && key>node.getRight().getData())
			node=leftRotate(node);
		else if(balance>1 && key<node.getLeft().getData())
			node=rightRotate(node);
		else if(balance<-1 && key<node.getRight().getData())
		{
			node.setRight(rightRotate(node.getRight()));
			node=leftRotate(node);
		}
		else if(balance>1 && key>node.getLeft().getData())
		{
			node.setLeft(leftRotate(node.getLeft()));
			node=rightRotate(node);
		}
		return node;
	}
	
	
	public static  BinaryTree<Integer> deleteNode( BinaryTree<Integer> node, int key)
	{
		if(node == null)
			return null;
		
		if(key<node.getData())
			node.setLeft(deleteNode(node.getLeft(), key));
		else if(key>node.getData())
			node.setRight(deleteNode(node.getRight(), key));
		else
		{
			if(node.getLeft()==null || node.getRight()==null)
			{
				BinaryTree<Integer> temp=null;
				if(temp==node.getLeft())
					temp=node.getRight();
				else
					temp=node.getLeft();
				node=temp;
			}
			else
			{
				BinaryTree<Integer> temp=minNode(node.getRight());
				node.setData(temp.getData());
				node.setRight(deleteNode(node.getRight(), temp.getData()));
			}
		}
		
		int balance=getBalance(node);
		
		if(balance<-1 && getBalance(node.getRight())<0)
		{
			node=leftRotate(node);
		}
		else if(balance>1 && getBalance(node.getLeft())>=0)
		{
			node=rightRotate(node);
		}
		else if(balance<-1 && getBalance(node.getRight())>=0)
		{
			node.setRight(rightRotate(node.getRight()));
			node=leftRotate(node);
		}
		else if(balance>1 && getBalance(node.getLeft())<0)
		{
			node.setLeft(leftRotate(node.getLeft()));
			node=rightRotate(node);
		}
		return node;
	}
	
	public static BinaryTree<Integer> minNode(BinaryTree<Integer> node)
	{
		if(node ==null)
			return null;
		
		if(node.getLeft()==null)
			return node;
		else 
			return minNode(node.getLeft());
	}
	
}
