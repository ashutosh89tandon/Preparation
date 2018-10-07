package com.prep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.prep.ds.BinaryTree;

public class BinaryTreeToArray 
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		BinaryTree<Integer> root=new BinaryTree<Integer>(18, 0);
		root.setLeft(new BinaryTree<Integer>(20, 1));
		root.setRight(new BinaryTree<Integer>(22,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(14, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(12,2));
		root.getRight().setLeft(new BinaryTree<Integer>(25, 2));
		root.getRight().setRight(new BinaryTree<Integer>(21,2));
		root.getLeft().getLeft().setLeft(new BinaryTree<Integer>(16, 3));
		root.getLeft().getLeft().setRight(new BinaryTree<Integer>(19,3));
		
		BinaryTree[] array=new BinaryTree[9];
		populateArray(root,array);
		printArray(array);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void printArray(BinaryTree[] array) {
		for(int i=0;i<array.length;i++)
			System.out.println("i ="+i+" Data : "+((BinaryTree<Integer>)array[i]).getData());
		
	}

	@SuppressWarnings("rawtypes")
	private static void populateArray(BinaryTree<Integer> root, BinaryTree[] array) 
	{

		Queue<BinaryTree<Integer>> queue=new LinkedList<BinaryTree<Integer>>();
		queue.offer(root);
		array[0]=root;
		root.setArrayIndex(0);
		while(!queue.isEmpty())
		{
			BinaryTree<Integer> tempNode=queue.poll();
			BinaryTree<Integer> left=tempNode.getLeft();
			BinaryTree<Integer> right=tempNode.getRight();
			boolean rightFilled=false;
			
			if(left!=null)
			{
				array[2*tempNode.getArrayIndex()+1]=left;
				left.setArrayIndex(2*tempNode.getArrayIndex()+1);
				queue.offer(left);
			}
			else if(right!=null)
			{
				array[2*tempNode.getArrayIndex()+1]=right;
				right.setArrayIndex(2*tempNode.getArrayIndex()+1);
				queue.offer(right);
				rightFilled=true;
			}
			
			if(right!=null && !rightFilled)
			{
				array[2*tempNode.getArrayIndex()+2]=right;
				right.setArrayIndex(2*tempNode.getArrayIndex()+2);
				queue.offer(right);
			}
		}
	
	}
	
}
