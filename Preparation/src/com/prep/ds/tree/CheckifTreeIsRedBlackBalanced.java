package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class CheckifTreeIsRedBlackBalanced 
{
	public static void main(String[] args)
	{
		BinaryTree<Integer> root=new BinaryTree<Integer>(5);
		root.setRight(new BinaryTree<Integer>(6));
		root.setLeft(new BinaryTree<Integer>(4));
		root.getRight().setRight(new BinaryTree<Integer>(9));
		root.getRight().setLeft(new BinaryTree<Integer>(8));
		root.getRight().getLeft().setLeft(new BinaryTree<Integer>(11));
		System.out.println("Is red back balanced : "+isRedBlackBalanced(root));
		
	}

	private static boolean isRedBlackBalanced(BinaryTree<Integer> root) 
	{
		if(root == null)
			return true;
		
		isRedBlackBalanced(root.getLeft());
		isRedBlackBalanced(root.getRight());
		
		int leftHeight=getHeight(root.getLeft());
		int rightHeight=getHeight(root.getRight());
		if((leftHeight>2*rightHeight) || (2*leftHeight<rightHeight))
			return false;
		
		return true;
	}

	private static int getHeight(BinaryTree<Integer> node) {
		if(node==null)
			return 0;
		return 1+Math.min(getHeight(node.getLeft()),getHeight(node.getRight()));
	}
}
