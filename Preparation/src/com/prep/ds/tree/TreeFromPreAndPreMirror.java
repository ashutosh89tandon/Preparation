package com.prep.ds.tree;

import com.prep.ds.BinaryTree;

public class TreeFromPreAndPreMirror {
	private static int preIndex=0;

	public static void main(String[] args) {
		int pre[] = {1,2,4,5,3,6,7};
		int preM[] = {1,3,7,6,2,5,4};
		BinaryTree<Integer> root=new BinaryTree<Integer>(pre[preIndex++]);
		constructTree(pre,preM,root,1,preM.length-1);
		System.out.println(root);
	}

	private static void constructTree(int[] pre, int[] preM, BinaryTree<Integer> root,int start, int end) 
	{
		if(start>end)
			return;
		int currentIndex=findPreMirrorIndex(preM, pre[preIndex++], start, end);
		root.setLeft(new BinaryTree<Integer>(preM[currentIndex]));
		constructTree(pre, preM, root.getLeft(), currentIndex+1, end);
		root.setRight(new BinaryTree<Integer>(preM[start]));
		preIndex++;
		constructTree(pre, preM, root.getRight(), start+1, currentIndex-1);
		
	}
	
	private static int findPreMirrorIndex(int[] preM, int value,int start,int end) {
		for(int i=start;i<=end;i++)
			if(value==preM[i])
				return i;
		return -1;
	}
}
