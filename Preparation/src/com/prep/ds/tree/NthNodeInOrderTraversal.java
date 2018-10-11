package com.prep.ds.tree;

import java.util.concurrent.atomic.AtomicInteger;

import com.prep.ds.BinaryTree;

public class NthNodeInOrderTraversal {

	public static void main(String[] args) {
		BinaryTree<Integer> root=new BinaryTree<Integer>(3, 0);
		root.setLeft(new BinaryTree<Integer>(2, 1));
		root.setRight(new BinaryTree<Integer>(4,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(1, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(3,2));
		root.getRight().setLeft(new BinaryTree<Integer>(5, 2));
		AtomicInteger n=new AtomicInteger(5);
		System.out.println(findNthNode(root,n).getData());
	}

	private static BinaryTree<Integer> findNthNode(BinaryTree<Integer> node, AtomicInteger n) 
	{
		if(n.get()==0)
			return node;
		if(node==null)
			return null;
		BinaryTree<Integer> left =findNthNode(node.getLeft(), n);
		if(left!=null)
			return left;
		n.set(n.get()-1);
		if(n.get()==0)
			return node;
		BinaryTree<Integer> right =findNthNode(node.getRight(), n);
		if(right!=null)
			return right;
		
		return null;
	}
}
