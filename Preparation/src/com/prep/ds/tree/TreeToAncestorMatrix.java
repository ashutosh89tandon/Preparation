package com.prep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.prep.ds.BinaryTree;

public class TreeToAncestorMatrix 
{
	public static int[][] constructMatrix(BinaryTree<Integer> root)
	{
		int mat[][]=createInitialMatrix(root);
		populateMatrix(mat,root);
		return mat;
	}

	private static void populateMatrix(int[][] mat, BinaryTree<Integer> root) {
		if(root==null)
			return;
		if(root.getLeft()!=null)
		{
			mat[root.getData()][root.getLeft().getData()]=1;
			populateMatrix(mat, root.getLeft());
		}
		if(root.getRight()!=null)
		{
			mat[root.getData()][root.getRight().getData()]=1;
			populateMatrix(mat, root.getRight());
		}
	}

	private static int[][] createInitialMatrix(BinaryTree<Integer> root) {
		int size=findMaxNode(root)+1;
		int[][] mat=new int[size][size];
		for(int i=0;i<mat.length;i++)
			for(int j=0;j<mat[i].length;j++)
			{
				mat[i][j]=0;
				if(i==root.getData() && j!=i)
				{
					mat[i][j]=1;
				}
			}
		
		return mat;
	}
	
	private static int findMaxNode(BinaryTree<Integer> root) 
	{
		Queue<BinaryTree<Integer>> queue=new LinkedList<BinaryTree<Integer>>();
		queue.offer(root);
		int max=root.getData();
		while(!queue.isEmpty())
		{
			BinaryTree<Integer> tempNode=queue.poll();
			if(max<tempNode.getData())
				max=tempNode.getData();
			BinaryTree<Integer> left=tempNode.getLeft();
			BinaryTree<Integer> right=tempNode.getRight();
			
			if(left!=null)
				queue.offer(left);
			if(right!=null)
				queue.offer(right);
		}
		
		return max;
	}
}
