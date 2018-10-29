package com.prep.ds.tree;

import java.util.Arrays;

import com.prep.ds.BinaryTree;

public class DistanceBetweenTwoNodes {
	
	/**
	 *  Distance : path(root,n1) +path(root,n2) -2*path(root,lca)
	 */
	public static void main(String[] args) 
	{
		BinaryTree<Integer> root= new BinaryTree<Integer>(1);
		root.setLeft(new BinaryTree<Integer>(2));
		root.setRight(new BinaryTree<Integer>(3));
		root.getLeft().setLeft(new BinaryTree<Integer>(4));
		root.getLeft().setRight(new BinaryTree<Integer>(5));
		root.getRight().setLeft(new BinaryTree<Integer>(6));
		root.getRight().setRight(new BinaryTree<Integer>(7));
		root.getRight().getLeft().setRight(new BinaryTree<Integer>(8));
		BinaryTree<Integer> node1=root.getLeft().getLeft();
		BinaryTree<Integer> node2=root.getRight();
		int distance=findDistance(root, node1, node2);
		System.out.println("Distance : "+distance);
		
	}

	private static int findDistance(BinaryTree<Integer> root, BinaryTree<Integer> node1, BinaryTree<Integer> node2) 
	{
		BinaryTree<Integer> node=LeastCommonAncestor.getLeastCommonAncestor(root, Arrays.asList(node1,node2));
		int d1=findLength(root,node1,0);
		int d2=findLength(root,node2,0);
		int d3=findLength(root,node,0);
		return (d1+d2-(2*d3));
	}

	private static int findLength(BinaryTree<Integer> root, BinaryTree<Integer> node,int length) {
		if(root==null)
			return 0;
		if(root==node)
			return length;
		int rDistance=findLength(root.getRight(), node, length+1);
		int lDistance=findLength(root.getLeft(), node, length+1);
		
		if(rDistance>0)
			return rDistance;
		else if(lDistance>0)
			return lDistance;
		return 0;
	}
}
