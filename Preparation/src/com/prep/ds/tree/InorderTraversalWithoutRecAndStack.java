package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class InorderTraversalWithoutRecAndStack 
{
	public static void main(String[] args) 
	{
		BinaryTree<Integer> root=new BinaryTree<Integer>(1, 0);
		root.setLeft(new BinaryTree<Integer>(2, 1));
		root.setRight(new BinaryTree<Integer>(3,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(4, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(5,2));
		printWithoutRecursion(root);
	}

	private static void printWithoutRecursion(BinaryTree<Integer> root) 
	{
		BinaryTree<Integer> current=root;
		while(current.getLeft()!=null)
		{
			BinaryTree<Integer> left=current.getLeft();
			left.setParent(current);
			current=left;
		}
		while(current!=null)
		{
			System.out.print(current.getData()+"->");
			if(current.getRight()!=null)
				printWithoutRecursion(current.getRight());
			current=current.getParent();
		}
	}
}
