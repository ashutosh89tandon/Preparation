package com.prep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.prep.ds.BinaryTree;

public class SumCoveredAndUncoveredNodes 
{
	public static void main(String[] args) {
		BinaryTree<Integer> root=new BinaryTree<Integer>(9, 0);
		root.setLeft(new BinaryTree<Integer>(4, 1));
		root.setRight(new BinaryTree<Integer>(17,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(3, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(55,2));
		root.getRight().setRight(new BinaryTree<Integer>(22,2));
		int leftSum=0;
		int rightSum=0;
		if(root.getLeft()!=null)
			 leftSum=findSumLeftTree(root);
		if(root.getRight()!=null)
			 rightSum=findSumRightTree(root.getRight());
		
		int totalSum=findTotalSum(root);
		
		if(totalSum-(leftSum+rightSum)==leftSum+rightSum)
			System.out.println("Sum equal");
		else
			System.out.println("Sum not equal");
		
	}

	private static int findTotalSum(BinaryTree<Integer> root) {
		Queue<BinaryTree<Integer>> queue=new LinkedList<>();
		queue.offer(root);
		int sum=0;
		while(!queue.isEmpty())
		{
			BinaryTree<Integer> node=queue.poll();
			if(node.getLeft()!=null)
				queue.offer(node.getLeft());
			if(node.getRight()!=null)
				queue.offer(node.getRight());
			sum+=node.getData();
		}
		return sum;
	}

	private static int findSumRightTree(BinaryTree<Integer> root) {
		if(root==null)
			return 0;
		
		return root.getData()+(root.getRight()==null?findSumRightTree(root.getLeft()):
			findSumRightTree(root.getRight()));
	}

	private static int findSumLeftTree(BinaryTree<Integer> root) 
	{
		if(root==null)
			return 0;
		
		return root.getData()+(root.getLeft()==null?findSumLeftTree(root.getRight()):
			findSumLeftTree(root.getLeft()));
	}
}
