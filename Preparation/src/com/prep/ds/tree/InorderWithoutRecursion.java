package com.prep.ds.tree;

import java.util.Stack;

import com.prep.ds.BinaryTree;

public class InorderWithoutRecursion 
{
	public static void main(String[] args) 
	{
		BinaryTree<Integer> root=new BinaryTree<Integer>(1, 0);
		root.setLeft(new BinaryTree<Integer>(2, 1));
		root.setRight(new BinaryTree<Integer>(3,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(4, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(5,2));
		printWithoutRecursion(root);
	}
	
	public static void printWithoutRecursion(BinaryTree<Integer> node)
	{
		Stack<BinaryTree<Integer>> stack=new Stack<>();
		BinaryTree<Integer> tNode=node;
		stack.push(node);
		while(tNode.getLeft()!=null)
		{
			tNode=tNode.getLeft();
			stack.push(tNode);
		}
		
		while(!stack.isEmpty())
		{
			BinaryTree<Integer> tempNode=stack.pop();
			System.out.print(tempNode.getData()+"->");
			if(tempNode.getRight()!=null)
				printWithoutRecursion(tempNode.getRight());
		}
	}
}
