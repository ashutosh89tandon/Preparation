package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class ContinuousTree 
{
	public static void main(String[] args) {
		
		BinaryTree<Integer> root=new BinaryTree<Integer>(3, 0);
		root.setLeft(new BinaryTree<Integer>(2, 1));
		root.setRight(new BinaryTree<Integer>(4,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(1, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(3,2));
		root.getRight().setLeft(new BinaryTree<Integer>(5, 2));
		System.out.println("Is continuous tree : "+isContinuousTree(root));
		
		root=new BinaryTree<Integer>(7, 0);
		root.setLeft(new BinaryTree<Integer>(5, 1));
		root.setRight(new BinaryTree<Integer>(8,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(6, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(4,2));
		root.getRight().setLeft(new BinaryTree<Integer>(10, 2));
		System.out.println("Is continuous tree : "+isContinuousTree(root));
	}

	private static boolean isContinuousTree(BinaryTree<Integer> root) 
	{	
		if(root==null)
			return true;
		BinaryTree<Integer>  left=root.getLeft();
		BinaryTree<Integer>  right=root.getRight();
		boolean leftContinuous=true;
		boolean rightContinuous=true;
		if(left!=null)
		{
			if(Math.abs(left.getData()-root.getData())==1)
				leftContinuous=isContinuousTree(left);
			else
				leftContinuous=false;
		}
		
		if(right!=null)
		{
			if(Math.abs(right.getData()-root.getData())==1)
				rightContinuous=isContinuousTree(right);
			else
				rightContinuous=false;
		}
		
		return rightContinuous && leftContinuous;
	}
}
