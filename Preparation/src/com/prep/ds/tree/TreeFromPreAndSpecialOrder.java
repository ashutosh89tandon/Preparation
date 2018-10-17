package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class TreeFromPreAndSpecialOrder 
{
	private static int preIndex=0;

	public static void main(String[] args) {
		int pre[] = {10, 30, 20, 5, 15};
		char preLN[] = {'N', 'N', 'L', 'L', 'L'};
		BinaryTree<Integer> root=new BinaryTree<Integer>(pre[preIndex++]);
		constructTree(pre,preLN,root);
		System.out.println(root);
	}

	private static BinaryTree<Integer> constructTree(int[] pre, char[] preLN, BinaryTree<Integer> root) 
	{
		if(preIndex>=pre.length)
			return null;
		if(preLN[preIndex-1]=='L')
			return root;
		root.setLeft(new BinaryTree<Integer>(pre[preIndex++]));
		constructTree(pre,preLN,root.getLeft());
		root.setRight(new BinaryTree<Integer>(pre[preIndex++]));
		constructTree(pre,preLN,root.getRight());
		return root;
	}
}
