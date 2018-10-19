package com.prep.ds.tree;

import java.util.HashMap;
import java.util.Map;

import com.prep.ds.BinaryTree;

public class TreeFromParentArray 
{
	static BinaryTree<Integer> root=null;
	static Map<Integer,BinaryTree<Integer>> nodeMap=new HashMap<>();
	public static void main(String[] args)
	{
		int parent[] = {1, 5, 5, 2, 2, -1, 3};
		populateMap(parent);
		constructTree(parent);
		System.out.println(root);
	}
	
	private static void constructTree(int[] parent)
	{
		for(int i=0;i<parent.length;i++)
		{
			if(nodeMap.get(i)==root)
				continue;
			else
			{
				BinaryTree<Integer> left=nodeMap.get(parent[i]).getLeft();
				if(left==null)
					nodeMap.get(parent[i]).setLeft(nodeMap.get(i));
				else
					nodeMap.get(parent[i]).setRight(nodeMap.get(i));
			}
		}
	}

	private static void populateMap(int[] parent) {
		for(int i=0;i<parent.length;i++)
		{
			BinaryTree<Integer> node=new BinaryTree<Integer>(i);
			nodeMap.put(i, node);
			if(parent[i]==-1)
				root=node;
		}
	}
}
