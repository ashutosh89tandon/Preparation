package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class ReverseOrderPrinting 
{
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
		printReverseOrder(root);
		System.out.println(root.getData());
	}

	private static void printReverseOrder(BinaryTree<Integer> root) 
	{
		if(root==null)
			return;
		printReverseOrder(root.getLeft());
		printReverseOrder(root.getRight());
		if(root.getLeft()!=null)
			System.out.print(root.getLeft().getData()+"->");
		if(root.getRight()!=null)
			System.out.print(root.getRight().getData()+"->");
		
	}
}
