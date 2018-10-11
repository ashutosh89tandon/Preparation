package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class PopulateInOrderNext 
{	
	static BinaryTree<Integer> next=null;
	public static void main(String[] args) {
		
		BinaryTree<Integer> root=new BinaryTree<Integer>(3, 0);
		root.setLeft(new BinaryTree<Integer>(2, 1));
		root.setRight(new BinaryTree<Integer>(4,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(1, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(3,2));
		root.getRight().setLeft(new BinaryTree<Integer>(5, 2));
		populateInOrderNext(root);
		
	}

	private static void populateInOrderNext(BinaryTree<Integer> node)
	{
		if(node==null)
			return;
		populateInOrderNext(node.getRight());
		node.setNext(next);
		next=node;
		populateInOrderNext(node.getLeft());
	}
}
