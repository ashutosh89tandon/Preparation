package com.prep.ds.tree;

import java.util.ArrayList;
import java.util.List;

import com.prep.ds.BinaryTree;

public class TreeIsSubsetOfOther 
{
	public static void main(String[] args) {
		
		BinaryTree<String> root1=getFirstTree();
		BinaryTree<String> root2=getSecondTree();
		List<BinaryTree<String>> in1=new ArrayList<>();
		List<BinaryTree<String>> in2=new ArrayList<>();
		List<BinaryTree<String>> pre1=new ArrayList<>();
		List<BinaryTree<String>> pre2=new ArrayList<>();
		getInOrder(root1,in1);
		getInOrder(root2,in2);
		getPreOrder(root1,pre1);
		getPreOrder(root2,pre2);
		boolean isSubset = IsInOrderSame(in1, in2) && IsPreOrderSame(pre1, pre2);
		
		System.out.println("Is Subset : "+isSubset);
		
	}

	private static boolean IsInOrderSame(List<BinaryTree<String>> in1, List<BinaryTree<String>> in2) {
		boolean isSubset=true;
		int j=0;
		int i=0;
		for(i=0;i<in2.size();i++)
		{
			if(!in2.get(i).getData().equals(in1.get(j).getData()))
			{
				continue;
			}
			break;
		}
		
		while(j<in1.size() && i<in2.size())
		{
			if(!in2.get(i).getData().equals(in1.get(j).getData()))
			{
				isSubset=false;
				break;
			}
			i++;j++;
		}
		return isSubset;
	}
	
	private static boolean IsPreOrderSame(List<BinaryTree<String>> pre1, List<BinaryTree<String>> pre2) {
		boolean isSubset=true;
		int j=0;
		int i=0;
		for(i=0;i<pre2.size();i++)
		{
			if(!pre2.get(i).getData().equals(pre1.get(j).getData()))
			{
				continue;
			}
			break;
		}
		
		while(j<pre1.size() && i<pre2.size())
		{
			if(!pre2.get(i).getData().equals(pre1.get(j).getData()))
			{
				isSubset=false;
				break;
			}
			i++;j++;
		}
		return isSubset;
	}
	
	private static void getPreOrder(BinaryTree<String> root, List<BinaryTree<String>> pre) {
		
		if(root==null)
			return;
		pre.add(root);
		getPreOrder(root.getLeft(), pre);
		getPreOrder(root.getRight(), pre);
	}

	private static void getInOrder(BinaryTree<String> root, List<BinaryTree<String>> in) 
	{
		if(root==null)
			return;
		getInOrder(root.getLeft(), in);
		in.add(root);
		getInOrder(root.getRight(), in);
	}

	private static BinaryTree<String> getFirstTree() {
		BinaryTree<String> root=new BinaryTree<String>("x", 0);
		root.setLeft(new BinaryTree<String>("a", 1));
		root.setRight(new BinaryTree<String>("b",1));
		root.getLeft().setRight(new BinaryTree<String>("c", 2));
		return root;
	}
	private static BinaryTree<String> getSecondTree() {
		BinaryTree<String> root=new BinaryTree<String>("z", 0);
		root.setLeft(new BinaryTree<String>("x", 1));
		root.setRight(new BinaryTree<String>("e",1));
		root.getLeft().setLeft(new BinaryTree<String>("a", 1));
		root.getLeft().setRight(new BinaryTree<String>("b",1));
		root.getLeft().getLeft().setRight(new BinaryTree<String>("c", 2));
		root.getRight().setRight(new BinaryTree<String>("k",1));
		
		return root;
	}
}
