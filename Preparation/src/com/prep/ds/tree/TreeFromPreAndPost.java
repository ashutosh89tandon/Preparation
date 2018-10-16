package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class TreeFromPreAndPost {
	static int preIndex=0;
	public static void main(String[] args) 
	{
		int pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
		int post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
		BinaryTree<Integer> root=new BinaryTree<Integer>(pre[preIndex++]);
		contructTree(pre,post,0,post.length-2,root);
		System.out.println(root);
	}

	private static void contructTree(int[] pre, int[] post, int postStart, int postEnd, BinaryTree<Integer> node) 
	{
		if(postStart>postEnd)
			return;
		
		int current=findPostOrderIndex(post, pre[preIndex++], postStart, postEnd);
		node.setLeft(new BinaryTree<Integer>(post[current]));
		node.setRight(new BinaryTree<Integer>(post[postEnd]));
		contructTree(pre, post, postStart, current-1, node.getLeft());
		preIndex++;
		contructTree(pre, post, current+1, postEnd-1, node.getRight());
	}
	
	private static int findPostOrderIndex(int[] post, int value,int start,int end) {
		for(int i=start;i<=end;i++)
			if(value==post[i])
				return i;
		return -1;
	}
}
