package com.prep.ds.tree;

import java.util.ArrayList;
import java.util.List;

import com.prep.ds.BinaryTree;

public class LeastCommonAncestor {
	public static void main(String[] args) {
		
		BinaryTree<Integer> root=new BinaryTree<Integer>(1, 0);
		root.setLeft(new BinaryTree<Integer>(3, 0));
		root.setRight(new BinaryTree<Integer>(2, 0));
		root.getRight().setLeft(new BinaryTree<Integer>(5, 0));
		root.getRight().setRight(new BinaryTree<Integer>(4, 0));
		List<BinaryTree<Integer>> nodes=new ArrayList<>();
		nodes.add(root);
		nodes.add(root.getRight().getRight());
		System.out.println("Least common Ancestor is :"+getLeastCommonAncestor(root, nodes));
	}

	private static BinaryTree<Integer> getLeastCommonAncestor(BinaryTree<Integer> root, List<BinaryTree<Integer>> nodes) {
		if(root==null)
			return null;
		
		if(nodes.contains(root))
			return root;
		
		BinaryTree<Integer> left=getLeastCommonAncestor(root.getLeft(), nodes);
		BinaryTree<Integer> right=getLeastCommonAncestor(root.getRight(), nodes);
		
		if(left!=null && right!=null)
			return root;
		
		if(left!=null)
			return left;
		else if(right!=null)
			return right;
		
		return null;
	}
	
}
