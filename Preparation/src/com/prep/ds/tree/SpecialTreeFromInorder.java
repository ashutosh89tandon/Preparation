package com.prep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.prep.ds.BinaryTree;

public class SpecialTreeFromInorder 
{
	public static void main(String[] args) {
		int in[] = {1, 5, 10, 40, 30,15, 28, 20};
		int max=findMaxNode(in,0,in.length-1);
		BinaryTree<Integer> root=new BinaryTree<Integer>(max);
		constructTree(in,root,0,in.length-1);
		print(root);
	}

	private static void constructTree(int[] in, BinaryTree<Integer> node, int start, int end) {
		if(start>end)
			return;
		int current=findinOrderIndex(in, node.getData(), start, end);
		int maxLeft=findMaxNode(in,start,current-1);
		if(maxLeft!=-1){
		node.setLeft(new BinaryTree<Integer>(maxLeft));
		constructTree(in, node.getLeft(), start,current-1);
		}
		
		int maxRight=findMaxNode(in,current+1,end);
		if(maxRight!=-1){
		node.setRight(new BinaryTree<Integer>(maxRight));
		constructTree(in, node.getRight(), current+1,end);}
	}

	private static int findMaxNode(int[] in,int start,int end) {
		if(start>end)
			return -1;
		int max=in[start];
		for(int i=start;i<=end;i++)
			if(max<in[i])
				max=in[i];
		
		return max;
	}
	
	private static int findinOrderIndex(int[] in, int value,int start,int end) {
		for(int i=start;i<=end;i++)
			if(value==in[i])
				return i;
		return -1;
	}
	
	private static void print(BinaryTree<Integer> root) 
	{
		Queue<BinaryTree<Integer>> queue=new LinkedList<BinaryTree<Integer>>();
		queue.offer(root);
		while(!queue.isEmpty())
		{
			BinaryTree<Integer> tempNode=queue.poll();
			System.out.print(tempNode.getData()+"->");
			BinaryTree<Integer> left=tempNode.getLeft();
			BinaryTree<Integer> right=tempNode.getRight();
			
			if(left!=null)
				queue.offer(left);
			if(right!=null)
				queue.offer(right);
		}
	}
}	
