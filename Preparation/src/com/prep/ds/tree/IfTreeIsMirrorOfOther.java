package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class IfTreeIsMirrorOfOther 
{
	public static void main(String[] args) {
		BinaryTree<Integer> root1=getFirstTree();
		BinaryTree<Integer> root2=getSecondTree();
		System.out.println("Is Mirror : "+isMirror(root1,root2));
	}
	
	private static boolean isMirror(BinaryTree<Integer> root1, BinaryTree<Integer> root2) {
		if(root1== null && root2==null)
			return true;
		
		if(root1!=null && root2!=null && root1.getData()==root2.getData() && 
				isMirror(root1.getLeft(), root2.getRight()) && isMirror(root1.getRight(), root2.getLeft()))
			return true;
		
		return false;
	}

	private static BinaryTree<Integer> getFirstTree() {
		BinaryTree<Integer> root=new BinaryTree<Integer>(1, 0);
		root.setLeft(new BinaryTree<Integer>(3, 0));
		root.setRight(new BinaryTree<Integer>(2, 0));
		root.getRight().setLeft(new BinaryTree<Integer>(5, 0));
		root.getRight().setRight(new BinaryTree<Integer>(4, 0));
		
		return root;
	}
	private static BinaryTree<Integer> getSecondTree() {
		BinaryTree<Integer> root=new BinaryTree<Integer>(1, 0);
		root.setLeft(new BinaryTree<Integer>(2, 0));
		root.setRight(new BinaryTree<Integer>(3, 0));
		root.getLeft().setLeft(new BinaryTree<Integer>(4, 0));
		root.getLeft().setRight(new BinaryTree<Integer>(5, 0));
		
		return root;
	}
}
