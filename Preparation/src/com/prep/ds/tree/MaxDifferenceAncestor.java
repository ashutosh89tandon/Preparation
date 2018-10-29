package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class MaxDifferenceAncestor
{
	static int maxDiff=-9999;
	public static void main(String[] args) 
	{
		BinaryTree<Integer> root= new BinaryTree<Integer>(8);
		root.setLeft(new BinaryTree<Integer>(3));
		root.setRight(new BinaryTree<Integer>(10));
		root.getLeft().setLeft(new BinaryTree<Integer>(1));
		root.getLeft().setRight(new BinaryTree<Integer>(6));
		root.getLeft().getRight().setLeft(new BinaryTree<Integer>(4));
		root.getLeft().getRight().setRight(new BinaryTree<Integer>(7));
		root.getRight().setRight(new BinaryTree<Integer>(14));
		root.getRight().getRight().setLeft(new BinaryTree<Integer>(13));
		findMaxDifference(root);
		System.out.println("Diff : "+maxDiff);
	}
	
	private static BinaryTree<Integer> findMaxDifference(BinaryTree<Integer> node) 
	{
		if(node==null)
			return null;
		
		BinaryTree<Integer> leftMin=findMaxDifference(node.getLeft());
		BinaryTree<Integer> rightMin=findMaxDifference(node.getRight());
		
		if(leftMin!=null && rightMin!=null)
		{
			BinaryTree<Integer> minNode= findMinNode(rightMin, leftMin);
			calculateMaxDiff(node,minNode);
			return findMinNode(node, minNode);
		}
		else if(leftMin!=null)
		{
			calculateMaxDiff(node,leftMin);
			return findMinNode(node, leftMin);
		}
		else if(rightMin!=null)
		{
			calculateMaxDiff(node, rightMin);
			return findMinNode(node, rightMin);
		}
		return node;
			
	}
	
	private static void calculateMaxDiff(BinaryTree<Integer> node, BinaryTree<Integer> minNode) 
	{
		if(maxDiff<(node.getData()-minNode.getData()))
			maxDiff=node.getData()-minNode.getData();
	}

	static BinaryTree<Integer> findMinNode(BinaryTree<Integer> node1, BinaryTree<Integer> node2)
	{
		if(node1.getData()>node2.getData())
			return node2;
		else 
			return node1;
	}
}
