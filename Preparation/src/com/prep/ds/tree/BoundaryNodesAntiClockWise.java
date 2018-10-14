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
		System.out.print(root.getData()+"->");
		print(root,0);	
	}

	private static void print(BinaryTree<Integer> root,int pos) {
		if(root==null)
			return;
		if(pos<0 || (root.getLeft()==null && root.getRight()==null))
			System.out.print(root.getData()+"->");
		print(root.getLeft(),pos-1);
		print(root.getRight(),pos+1);
		if(pos>0 && (root.getLeft()!=null || root.getRight()!=null))
		{
			System.out.print(root.getData()+"->");
		}
	}
}
