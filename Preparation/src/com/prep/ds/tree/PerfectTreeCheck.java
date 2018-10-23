package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class PerfectTreeCheck {
	
	public static void main(String[] args) {
		BinaryTree<Integer> root=new BinaryTree<Integer>(3, 0);
		root.setLeft(new BinaryTree<Integer>(2, 1));
		root.setRight(new BinaryTree<Integer>(4,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(1, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(3,2));
		root.getRight().setLeft(new BinaryTree<Integer>(5, 2));
		System.out.println("Is tree perfect : "+isTreePerfect(root));
	}

	private static boolean isTreePerfect(BinaryTree<Integer> root) {
		
		if(root==null)
			return true;
		
		if(!isTreePerfect(root.getLeft()))
			return false;
		if(!isTreePerfect(root.getRight()))
			return false;
		BinaryTree<Integer> left=root.getLeft();
		BinaryTree<Integer> right=root.getRight();
		
		if((right!=null && left!=null) || (right==null && left==null))
			return true;
		
		return false;
	}
}
