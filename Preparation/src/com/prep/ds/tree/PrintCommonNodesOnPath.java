package com.prep.ds.tree;

import java.util.Arrays;

import com.prep.ds.BinaryTree;

public class PrintCommonNodesOnPath 
{
	public static void main(String[] args) {
		BinaryTree<Integer> root= new BinaryTree<Integer>(1);
		root.setLeft(new BinaryTree<Integer>(2));
		root.setRight(new BinaryTree<Integer>(3));
		root.getLeft().setLeft(new BinaryTree<Integer>(4));
		root.getLeft().setRight(new BinaryTree<Integer>(5));
		root.getRight().setLeft(new BinaryTree<Integer>(6));
		root.getRight().setRight(new BinaryTree<Integer>(7));
		root.getLeft().getLeft().setLeft(new BinaryTree<Integer>(8));
		root.getRight().getLeft().setLeft(new BinaryTree<Integer>(9));
		root.getRight().getLeft().setRight(new BinaryTree<Integer>(10));
		
		BinaryTree<Integer> node1=root.getRight().getLeft().getLeft();
		BinaryTree<Integer> node2=root.getRight().getRight();
		printCommonNodesOnPath(root, node1, node2);
	}

	private static void printCommonNodesOnPath(BinaryTree<Integer> root, BinaryTree<Integer> node1,
			BinaryTree<Integer> node2) 
	{
		BinaryTree<Integer> node=LeastCommonAncestor.getLeastCommonAncestor(root, Arrays.asList(node1,node2));
		
		System.out.println(getNodePath(root,node,""));
	}

	private static String getNodePath(BinaryTree<Integer> root, BinaryTree<Integer> node, String path) {
		if(root==null)
			return "";
		String newPath=null;
		if(path.equals(""))
			newPath=""+root.getData();
		else
			newPath=path+"->"+root.getData();
		
		if(root.getData()==node.getData())
		{
			return newPath;
		}
		String lPath=getNodePath(root.getLeft(), node, newPath);
		String rPath=getNodePath(root.getRight(), node, newPath);
		if(!lPath.equals(""))
			return lPath;
		else if(!rPath.equals(""))
			return rPath;
		
		return "";
	}
}
