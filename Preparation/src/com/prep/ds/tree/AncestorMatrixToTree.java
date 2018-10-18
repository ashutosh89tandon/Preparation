package com.prep.ds.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.prep.ds.BinaryTree;

public class AncestorMatrixToTree 
{
	static Map<Integer,BinaryTree<Integer>> nodeMap=new HashMap<Integer, BinaryTree<Integer>>();
	static BinaryTree<Integer> root=null;
	public static void main(String[] args) 
	{
		int[][] mat= {{ 0, 0, 0, 0, 0, 0 }, 
		        { 1, 0, 0, 0, 1, 0 }, 
		        { 0, 0, 0, 1, 0, 0 }, 
		        { 0, 0, 0, 0, 0, 0 }, 
		        { 0, 0, 0, 0, 0, 0 }, 
		        { 1, 1, 1, 1, 1, 0 } 
		    }; 
		  
		   	findRoot(mat);
		   	constructRoot(mat); 
		    print();
		    System.out.println();
		    int[][] matRev = TreeToAncestorMatrix.constructMatrix(root);
		    for(int i=0;i<matRev.length;i++)
		    {
		    	for(int j=0;j<matRev[i].length;j++)
		    		System.out.print(matRev[i][j]+" ");
		    	System.out.println();
		    }
	}
	private static void constructRoot(int[][] mat)
	{
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[i].length;j++)
			{
				if(nodeMap.get(i)!=root)
				{
					if(mat[i][j]==1)
					{
						BinaryTree<Integer> left=nodeMap.get(i).getLeft();
						if(left==null)
							nodeMap.get(i).setLeft(nodeMap.get(j));
						else
							nodeMap.get(i).setRight(nodeMap.get(j));
						nodeMap.get(j).setParent(nodeMap.get(i));
					}
				}
			}
		}
		
		nodeMap.values().stream().filter(n->n.getParent()==null && n!=root).forEach(n->{
			BinaryTree<Integer> left = root.getLeft();
			if(left==null)
				root.setLeft(n);
			else
				root.setRight(n);
			n.setParent(root);
		});
		
	}
	private static void findRoot(int[][] mat) {
		for(int i=0;i<mat.length;i++)
		{
			int count=0;
			BinaryTree<Integer> node=new BinaryTree<Integer>(i);
			nodeMap.put(i, node);
			if(root==null)
			{
				for(int j=0;j<mat[i].length;j++)
					if(mat[i][j]==1)
						count++;
			}
			
			if(count==mat.length-1)
				root=node;
		}
	}
	
	private static void print() 
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
