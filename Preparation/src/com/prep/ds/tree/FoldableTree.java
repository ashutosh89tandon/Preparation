package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class FoldableTree 
{
	public static void main(String[] args) {
	
		BinaryTree<Integer> root=new BinaryTree<Integer>(10, 0);
		root.setLeft(new BinaryTree<Integer>(7, 1));
		root.setRight(new BinaryTree<Integer>(15,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(9,2));
		root.getRight().setLeft(new BinaryTree<Integer>(11, 2));
		System.out.println("Is foldable : "+isFoldable(root));
	}

	public static boolean isFoldable(BinaryTree<Integer> node)
	{
		if(node==null)
			return true;
		boolean isSame=isSame(node.getLeft(),node.getRight());
		return isSame;
	}

	private static boolean isSame(BinaryTree<Integer> left, BinaryTree<Integer> right) {
		
		if(left==null && right==null)
			return true;
		
		else if(left!=null && right!=null && isSame(left.getLeft(),right.getRight()) &&
				isSame(left.getRight(), right.getLeft()))	
			return true;
		return false;
	}
}
