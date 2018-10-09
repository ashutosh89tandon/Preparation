package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class PostOrderFromPreInOrder 
{
	private static int preOrderIndex=0;
	public static void main(String[] args) {
		int in[] = {4, 2, 5, 1, 3, 6};
		int pre[] = {1, 2, 4, 5, 3, 6};
		printPostOrder(in,pre);
	}

	private static void printPostOrder(int[] in, int[] pre) 
	{
		BinaryTree<Integer> root=populateTree(in,pre,0, pre.length-1);
		printPostOrder(root);
	}

	private static void printPostOrder(BinaryTree<Integer> node) {
		if(node==null)
			return;
		
		printPostOrder(node.getLeft());
		printPostOrder(node.getRight());
		System.out.print(node.getData()+"->");
	}

	private static int findInOrderIndex(int[] in, int value,int start,int end) {
		for(int i=start;i<=end;i++)
			if(value==in[i])
				return i;
		return -1;
	}

	private static BinaryTree<Integer> populateTree(int[] in, int[] pre,int start, int end) 
	{
		if(start>end)
			return null;
		int index=findInOrderIndex(in, pre[preOrderIndex++], start, end);
		BinaryTree<Integer> node=new BinaryTree<Integer>(in[index]);
		
		BinaryTree<Integer> left=populateTree(in,pre,start,index-1);
		if(left!=null)
			node.setLeft(left);
		
		BinaryTree<Integer> right=populateTree(in,pre,index+1,end);
		if(right!=null)
			node.setRight(right);
		
		return node;
	}
}
