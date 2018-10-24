package com.prep.ds.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.prep.ds.BinaryTree;

public class IfTreeContainsDuplicateSubset 
{
	static Map<String,Integer> map=new HashMap<>();
	public static void main(String[] args) {
		
		BinaryTree<String> root=new BinaryTree<String>("A");
		root.setLeft(new BinaryTree<String>("B"));
		root.setRight(new BinaryTree<String>("C"));
		root.getLeft().setLeft(new BinaryTree<String>("D"));
		root.getLeft().setRight(new BinaryTree<String>("E"));
		root.getRight().setRight(new BinaryTree<String>("B"));
		root.getRight().getRight().setLeft(new BinaryTree<String>("D"));
		root.getRight().getRight().setRight(new BinaryTree<String>("E"));
		checkContainingDuplicate(root);
		for(Entry<String,Integer> entry: map.entrySet())
			if(entry.getKey().length()>3 && entry.getValue()>1)
			{
				System.out.println("Yes Duplicate");
				break;
			}
	}

	private static void checkContainingDuplicate(BinaryTree<String> root) 
	{
		if(root==null)
			return;
		String str=getInOrder(root)+"$"+getPreOrder(root);
		if(map.containsKey(str))
			map.put(str,map.get(str)+1);
		else
			map.put(str,1);
		checkContainingDuplicate(root.getLeft());
		checkContainingDuplicate(root.getRight());
		
	}
	
	private static String getPreOrder(BinaryTree<String> root) {
		
		if(root==null)
			return "";
		
		return root.getData()+getPreOrder(root.getLeft())+getPreOrder(root.getRight());
	}

	private static String  getInOrder(BinaryTree<String> root) 
	{
		if(root==null)
			return "";
		return getInOrder(root.getLeft())+root.getData()+getInOrder(root.getRight());
	}
}
