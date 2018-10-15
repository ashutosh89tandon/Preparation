package com.prep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.prep.ds.BinaryTree;

public class TreeFromLevelAndInOrder 
{
	public static void main(String[] args) {
		int in[]    = {4, 8, 10, 12, 14, 20, 22};
		int level[] = {20, 8, 22, 4, 12, 10, 14};
		BinaryTree<Integer> root=constructTree(null,level,in,0,level.length-1);
		print(root);
	}
	
	public static BinaryTree<Integer> constructTree(BinaryTree<Integer> startNode, int[] levelOrder, int[] inOrder, 
            int inStart, int inEnd)  
    { 
   
        // if start index is more than end index 
        if (inStart > inEnd) 
            return null; 
   
        if (inStart == inEnd) 
            return new BinaryTree<Integer>(inOrder[inStart]); 
              
        boolean found = false; 
        int index = 0; 
   
        // it represents the index in inOrder array of element that 
        // appear first in levelOrder array. 
        for (int i = 0; i < levelOrder.length - 1; i++)  
        { 
            int data = levelOrder[i]; 
            for (int j = inStart; j < inEnd; j++)  
            { 
                if (data == inOrder[j])  
                { 
                    startNode = new BinaryTree<Integer>(data); 
                    index = j; 
                    found = true; 
                    break; 
                } 
            } 
            if (found == true) 
                break; 
        } 
   
        //elements present before index are part of left child of startNode. 
        //elements present after index are part of right child of startNode. 
        startNode.setLeft(constructTree(startNode, levelOrder, inOrder,  
                                                    inStart, index - 1)); 
        startNode.setRight(constructTree(startNode, levelOrder, inOrder,  
                                                     index + 1, inEnd)); 
   
        return startNode; 
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
