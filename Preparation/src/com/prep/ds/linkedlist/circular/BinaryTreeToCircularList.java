package com.prep.ds.linkedlist.circular;

import com.prep.ds.BinaryTree;
import com.prep.ds.DoublyLinkedList;

public class BinaryTreeToCircularList 
{
	private static DoublyLinkedList node=null;
	public static void main(String[] args) {
		
		BinaryTree<Integer> root=new BinaryTree<Integer>(10);
		root.setLeft(new BinaryTree<Integer>(12));
		root.setRight(new BinaryTree<Integer>(15));
		root.getLeft().setLeft(new BinaryTree<Integer>(25));
		root.getLeft().setRight(new BinaryTree<Integer>(30));
		root.getRight().setLeft(new BinaryTree<Integer>(36));
		getDLLFromBT(root);
		UtilMethods.printDoublyListFromEnd(node);
		
		
	}

	private static void getDLLFromBT(BinaryTree<Integer> root) {
		
		if(root==null)
			return;
		getDLLFromBT(root.getLeft());
		if(node==null)
		{
			node=new DoublyLinkedList(root.getData());
		}
		else
		{
			DoublyLinkedList currNode=new DoublyLinkedList(root.getData());
			node.setNext(currNode);
			currNode.setPrev(node);
			node=currNode;
		}
		getDLLFromBT(root.getRight());
	}
}
