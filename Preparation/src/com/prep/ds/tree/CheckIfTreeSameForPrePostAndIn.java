package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class CheckIfTreeSameForPrePostAndIn {
	
	static int preOrderIndex=0;
	static int postOrderIndex=0;
	public static void main(String[] args) {
		int inOrder[] = {4, 2, 5, 1, 3}; 
	    int preOrder[] = {1, 2, 4, 5, 3}; 
	    int postOrder[] = {4, 5, 2, 3, 1}; 
	    System.out.println("Is same "+checkIfTreeIsSame(inOrder,preOrder,postOrder));
	  
    	int inOrder1[] = {4, 2, 5, 1, 3}; 
	    int preOrder1[] = {1, 5, 4, 2, 3}; 
	    int postOrder1[] = {4, 1, 2, 3, 5}; 
	    System.out.println("Is same "+checkIfTreeIsSame(inOrder1,preOrder1,postOrder1));
	}
	
	private static boolean checkIfTreeIsSame(int[] inOrder, int[] preOrder, int[] postOrder) 
	{
		boolean isSame=false;
		try
		{
			BinaryTree<Integer> root=constructTree(inOrder,preOrder,0,inOrder.length-1);
			isSame=isSame(postOrder,root);
		}
		catch(Exception e)
		{
			
		}
		return isSame;
	}
	
	private static boolean isSame(int[] postOrder, BinaryTree<Integer> root) {
		int[] newPost=new int[postOrder.length];
		populatePostOrder(root,newPost);
		
		for(int i=0;i<postOrder.length;i++)
		{
			if(postOrder[i]!=newPost[i])
				return false;
		}
		return true;
	}

	private static void populatePostOrder(BinaryTree<Integer> root, int[] newPost) {
		
		if(root==null)
			return;
		populatePostOrder(root.getLeft(), newPost);
		populatePostOrder(root.getRight(), newPost);
		newPost[postOrderIndex++]=root.getData();
	}

	private static BinaryTree<Integer> constructTree(int[] inOrder, int[] preOrder, int start,int end) {
		
		if(start>end)
			return null;
		BinaryTree<Integer> node=new BinaryTree<Integer>(preOrder[preOrderIndex++]);
		int curr=findInOrderIndex(inOrder, node.getData(), start, end);
		node.setLeft(constructTree(inOrder, preOrder, start, curr-1));
		node.setRight(constructTree(inOrder, preOrder, curr+1, end));
		return node;
	}

	private static int findInOrderIndex(int[] inOrder, int value,int start,int end) {
		for(int i=start;i<=end;i++)
			if(value==inOrder[i])
				return i;
		return -1;
	}
}
