package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class CheckLeavesAtSameLevel {
	
	public static void main(String[] args) {
		
		BinaryTree<Integer> root=new BinaryTree<Integer>(12);
		root.setLeft(new BinaryTree<Integer>(5));
		root.getLeft().setLeft(new BinaryTree<Integer>(3));
		root.getLeft().setRight(new BinaryTree<Integer>(9));
		root.getLeft().getLeft().setLeft(new BinaryTree<Integer>(1));
		root.getLeft().getRight().setLeft(new BinaryTree<Integer>(2));
		
		boolean isSameLevel=checkIfAtSameLevel(root);
		System.out.println("Is same level : "+isSameLevel);
	}

	private static boolean checkIfAtSameLevel(BinaryTree<Integer> root) {
		if(root==null)
			return true;
		
		checkIfAtSameLevel(root.getLeft());
		checkIfAtSameLevel(root.getRight());
		int leftHeight=getHeight(root.getLeft());
		int rightHeight=getHeight(root.getRight());
		if((leftHeight==0 && rightHeight>0) || (leftHeight>0 && rightHeight==0) ||
				leftHeight==rightHeight || (leftHeight==0 && rightHeight==0))
		{
			return true;
		}
		return false;
	}

	private static int getHeight(BinaryTree<Integer> node) 
	{
		if(node==null)
			return 0;
		return 1+Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
	}
}
