package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class SumTree 
{
	public static void main(String[] args) {
		
		BinaryTree<Integer> root=new BinaryTree<Integer>(10, 0);
		root.setLeft(new BinaryTree<Integer>(8, 1));
		root.setRight(new BinaryTree<Integer>(2,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(3, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(5,2));
		root.getRight().setLeft(new BinaryTree<Integer>(2, 2));
		System.out.println("Is summed tree : "+isSummedTree(root));
	}

	private static boolean isSummedTree(BinaryTree<Integer> root) {
		if(root ==null)
			return true;
		if(!isSummedTree(root.getLeft())) return false;
		if(!isSummedTree(root.getRight())) return false;
		int  leftSum=root.getLeft()==null?0:root.getLeft().getData();
		int  rightSum=root.getRight()==null?0:root.getRight().getData();
		
		BinaryTree<Integer> left=root.getLeft();
		BinaryTree<Integer> right=root.getRight();
		
		if(right==null && left==null)
			return true;
		if(root.getData()==leftSum+rightSum)
			return true;
		return false;
	}
}
