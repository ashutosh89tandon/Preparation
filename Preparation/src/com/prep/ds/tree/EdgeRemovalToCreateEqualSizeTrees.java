package com.prep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.prep.ds.BinaryTree;

public class EdgeRemovalToCreateEqualSizeTrees 
{
	public static void main(String[] args) {
		BinaryTree<Integer> root=new BinaryTree<Integer>(5);
		root.setLeft(new BinaryTree<Integer>(1));
		root.setRight(new BinaryTree<Integer>(6));
		root.getRight().setLeft(new BinaryTree<Integer>(7));
		root.getRight().setRight(new BinaryTree<Integer>(4));
		root.getRight().getLeft().setLeft(new BinaryTree<Integer>(3));
		root.getRight().getLeft().setRight(new BinaryTree<Integer>(2));
		root.getRight().getRight().setRight(new BinaryTree<Integer>(8));
		
		BinaryTree<Integer> root1=new BinaryTree<Integer>(5);
		root1.setLeft(new BinaryTree<Integer>(1));
		root1.setRight(new BinaryTree<Integer>(6));
		root1.getLeft().setLeft(new BinaryTree<Integer>(3));
		root1.getRight().setLeft(new BinaryTree<Integer>(7));
		root1.getRight().setRight(new BinaryTree<Integer>(4));
		
		int size=getSize(root);
		boolean isPossible=checkIfTreeCanBeDivided(root,size);
		System.out.println("Is possible : "+isPossible);
		
		size=getSize(root1);
		isPossible=checkIfTreeCanBeDivided(root1,size);
		System.out.println("Is possible : "+isPossible);
	}

	private static boolean checkIfTreeCanBeDivided(BinaryTree<Integer> root, int size)
	{
		if(root==null)
			return false;
		if(checkIfTreeCanBeDivided(root.getLeft(), size)) return true;
		if(checkIfTreeCanBeDivided(root.getRight(), size)) return true;
		int leftSize=getSize(root.getLeft());
		int rightSize=getSize(root.getRight());
		
		if((leftSize==size-leftSize) || (rightSize==size-rightSize))
			return true;
	
		return false;
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
