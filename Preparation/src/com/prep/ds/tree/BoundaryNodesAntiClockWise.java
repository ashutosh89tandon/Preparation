package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class BoundaryNodesAntiClockWise {

	public static void main(String[] args) {
		BinaryTree<Integer> root=new BinaryTree<Integer>(18, 0);
		root.setLeft(new BinaryTree<Integer>(20, 1));
		root.setRight(new BinaryTree<Integer>(22,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(14, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(12,2));
		root.getRight().setLeft(new BinaryTree<Integer>(25, 2));
		root.getRight().setRight(new BinaryTree<Integer>(21,2));
		root.getLeft().getLeft().setLeft(new BinaryTree<Integer>(16, 3));
		root.getLeft().getLeft().setRight(new BinaryTree<Integer>(19,3));
		root.getLeft().getRight().setRight(new BinaryTree<Integer>(27, 3));
		root.getLeft().getRight().getRight().setRight(new BinaryTree<Integer>(26, 3));
		print(root,0);	
	}

	private static void print(BinaryTree<Integer> root,int pos) {
		if(root==null)
			return;
		printLeftMost(root);
		printLeaf(root);
		printRightMost(root.getRight());
		
		
	}

	private static void printLeaf(BinaryTree<Integer> root) {
		if(root==null)
			return;
		
		printLeaf(root.getLeft());
		printLeaf(root.getRight());
		if(root.getLeft()==null && root.getRight()==null)
			System.out.print(root.getData()+"->");
		
		
	}

	private static void printRightMost(BinaryTree<Integer> right) {
		if(right.getRight()==null)
			return;
		System.out.print(right.getData()+"->");
		printLeftMost(right.getRight());
		
	}

	private static void printLeftMost(BinaryTree<Integer> root) {
		if(root.getLeft()==null)
			return;
		System.out.print(root.getData()+"->");
		printLeftMost(root.getLeft());
		
	}
}
