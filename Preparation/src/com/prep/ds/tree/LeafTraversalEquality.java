package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class LeafTraversalEquality 
{
	public static void main(String[] args) {
		
		BinaryTree<Integer> root1=getFirstTree();
		BinaryTree<Integer> root2=getSecondTree();
		boolean isSame=isSame(root1,root2);
		System.out.println("Is same : "+isSame);
	}

	private static BinaryTree<Integer> getFirstTree() {
		BinaryTree<Integer> root=new BinaryTree<Integer>(1, 0);
		root.setLeft(new BinaryTree<Integer>(2, 1));
		root.setRight(new BinaryTree<Integer>(3,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(4, 2));
		root.getRight().setRight(new BinaryTree<Integer>(7,2));
		root.getRight().setLeft(new BinaryTree<Integer>(6, 2));
		/*BinaryTree<Integer> root=new BinaryTree<Integer>(0, 0);
		root.setLeft(new BinaryTree<Integer>(1, 1));
		root.setRight(new BinaryTree<Integer>(2,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(8, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(2,2));*/
		return root;
	}
	private static BinaryTree<Integer> getSecondTree() {
		BinaryTree<Integer> root=new BinaryTree<Integer>(0, 0);
		root.setLeft(new BinaryTree<Integer>(5, 1));
		root.setRight(new BinaryTree<Integer>(8,1));
		root.getLeft().setRight(new BinaryTree<Integer>(4,2));
		root.getRight().setLeft(new BinaryTree<Integer>(6, 2));
		root.getRight().setRight(new BinaryTree<Integer>(7, 2));
		/*BinaryTree<Integer> root=new BinaryTree<Integer>(1, 0);
		root.setLeft(new BinaryTree<Integer>(4, 1));
		root.setRight(new BinaryTree<Integer>(3,1));
		root.getLeft().setRight(new BinaryTree<Integer>(8,2));
		root.getRight().setLeft(new BinaryTree<Integer>(9, 2));
		root.getRight().setRight(new BinaryTree<Integer>(2, 2));*/
		return root;
	}

	private static boolean isSame(BinaryTree<Integer> root1, BinaryTree<Integer> root2) {
		if(root1==null && root2==null)
			return true;
		StringBuffer str1=new StringBuffer();
		StringBuffer str2=new StringBuffer();
		populateStringForTraversal(str1,root1);
		populateStringForTraversal(str2,root2);
		
		if(str1.toString().equals(str2.toString()))
			return true;
		
		return false;
		
	}

	private static void populateStringForTraversal(StringBuffer str, BinaryTree<Integer> root) {
		if(root==null)
			return;
		populateStringForTraversal(str, root.getLeft());
		populateStringForTraversal(str, root.getRight());
		if(root.getLeft()==null && root.getRight()==null)
			str.append(root.getData()+"->");
		
	}
}
