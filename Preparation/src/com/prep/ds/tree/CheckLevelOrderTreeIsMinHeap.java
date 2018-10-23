package com.prep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.prep.ds.BinaryTree;

public class CheckLevelOrderTreeIsMinHeap 
{
	static int levelOrderIndex=0;
	public static void main(String[] args) {
		int[] level = {10, 15, 14, 25, 30};
		int[] level1 = {30, 56, 22, 49, 30, 51, 2, 67};
		System.out.println("IsMinHeap : "+isMeanHeap(level));
		System.out.println("IsMinHeap : "+isMeanHeap(level1));
	}

	private static boolean isMeanHeap(int[] level) 
	{
		BinaryTree<Integer> root=constructTree(level);
		return isMinHeapFromRoot(root);
	}

	private static boolean isMinHeapFromRoot(BinaryTree<Integer> root) {
		
		if(root==null)
			return true;
		if(!isMinHeapFromRoot(root.getLeft()))
			return false;
		if(!isMinHeapFromRoot(root.getRight()))
			return false;
		
		BinaryTree<Integer> left=root.getLeft();
		BinaryTree<Integer> right=root.getRight();
		if(left!=null && left.getData()<root.getData())
			return false;
		if(right!=null && right.getData()<root.getData())
			return false;
		
		return true;
	}

	private static BinaryTree<Integer> constructTree(int[] level) {
		BinaryTree<Integer> root=new BinaryTree<Integer>(level[levelOrderIndex++]);
		Queue< BinaryTree<Integer>> queue=new LinkedList<>();
		queue.offer(root);
		
		while(levelOrderIndex<level.length)
		{
			BinaryTree<Integer> node=queue.poll();
			if(levelOrderIndex<=level.length-1)
			{
				node.setLeft(new BinaryTree<Integer>(level[levelOrderIndex++]));
				queue.offer(node.getLeft());
			}
			if(levelOrderIndex<=level.length-1)
			{
				node.setRight(new BinaryTree<Integer>(level[levelOrderIndex++]));
				queue.offer(node.getRight());
			}
				
		}
		return root;
	}
}
