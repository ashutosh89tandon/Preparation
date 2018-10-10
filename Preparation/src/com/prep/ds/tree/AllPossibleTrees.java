package com.prep.ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.prep.ds.BinaryTree;

public class AllPossibleTrees {

	private static Set<String> set=new HashSet<>();
	public static void main(String[] args) {
		List<Integer> arrlist=Arrays.asList(4,5,7);
		for(int i=0;i<arrlist.size();i++)
		{
			
			List<Integer> list=new ArrayList<>(arrlist);
			list.remove(i);
			BinaryTree<Integer> root=new BinaryTree<>(arrlist.get(i));
			findTrees(root,list);
			System.out.println(root);
		}
		System.out.println("Number of trees : "+set.size());
	}
	
	@SuppressWarnings("unchecked")
	private static void findTrees(BinaryTree<Integer> root, List<Integer> list)
	{
		if(list.isEmpty())
		{
			String result=getPreOrder(root);
			System.out.println(result);
			set.add(result);
			return;
		}
		
		for(int i=0;i<list.size();i++)
		{
			BinaryTree<Integer> tempRoot=(BinaryTree<Integer>) root.clone();
			insert(tempRoot,list.get(i));
			List<Integer> tempList=new ArrayList<Integer>(list);
			tempList.remove(i);
			findTrees(tempRoot,tempList);
		}
		
	}

	private static BinaryTree<Integer> insert(BinaryTree<Integer> node, Integer key) {
		if(node==null)
			return new BinaryTree<Integer>(key);
		if(node.getData()<key)
			node.setRight(insert(node.getRight(),key));
		else if(node.getData()>key)
			node.setLeft(insert(node.getLeft(),key));
		
		return node;
		
	}

	private static String getPreOrder(BinaryTree<Integer> root) {
		if(root==null)
			return "";
		return root.getData()+"->"+getPreOrder(root.getLeft())+getPreOrder(root.getRight());
	}
}
