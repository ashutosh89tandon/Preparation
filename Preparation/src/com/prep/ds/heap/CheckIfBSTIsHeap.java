package com.prep.ds.heap;

import java.util.LinkedList;
import java.util.Queue;

import com.prep.ds.BinaryTree;

public class CheckIfBSTIsHeap 
{	
	public static void main(String[] args) {
		BinaryTree<Integer> root=new BinaryTree<Integer>(97, 0);
		root.setLeft(new BinaryTree<Integer>(46, 1));
		root.setRight(new BinaryTree<Integer>(37,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(12, 1));
		root.getLeft().setRight(new BinaryTree<Integer>(3,1));
		root.getRight().setLeft(new BinaryTree<Integer>(7, 1));
		root.getRight().setRight(new BinaryTree<Integer>(31,1));
		root.getLeft().getLeft().setLeft(new BinaryTree<Integer>(6, 1));
		root.getLeft().getLeft().setRight(new BinaryTree<Integer>(9,1));
		
		System.out.println("Is Heap : "+isHeap(root));
		
		root=new BinaryTree<Integer>(97, 0);
		root.setLeft(new BinaryTree<Integer>(46, 1));
		root.setRight(new BinaryTree<Integer>(37,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(12, 1));
		root.getLeft().setRight(new BinaryTree<Integer>(3,1));
		root.getRight().setLeft(new BinaryTree<Integer>(7, 1));
		root.getRight().setRight(new BinaryTree<Integer>(31,1));
		root.getLeft().getRight().setLeft(new BinaryTree<Integer>(1, 1));
		root.getLeft().getRight().setRight(new BinaryTree<Integer>(2,1));
		
		
		
		System.out.println("Is Heap : "+isHeap(root));
	}

	private static boolean isHeap(BinaryTree<Integer> node) 
	{
		if(node==null)
			return true;
		
		if(!isHeap(node.getLeft()))
			return false;
		if(!isHeap(node.getRight()))
			return false;
		int leftSize=getSize(node.getLeft());
		int rightSize=getSize(node.getRight());
		BinaryTree<Integer> left=node.getLeft();
		BinaryTree<Integer> right=node.getRight();
		
		if(left!=null && left.getData()>node.getData())
			return false;
		if(right!=null && right.getData()>node.getData())
			return false;
		if(leftSize<rightSize)
			return false;
		
		return true;
		
	}
	
	private static int getSize(BinaryTree<Integer> root)
	{
		if(root==null)
			return 0;
		
		Queue<BinaryTree<Integer>> queue=new LinkedList<>();
		queue.offer(root);
		int size=0;
		while(!queue.isEmpty())
		{
			BinaryTree<Integer> node=queue.poll();
			if(node.getLeft()!=null)
				queue.offer(node.getLeft());
			if(node.getRight()!=null)
				queue.offer(node.getRight());
			size++;
		}
		return size;
	}
}
