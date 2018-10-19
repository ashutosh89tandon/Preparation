package com.prep.ds.tree;

import com.prep.ds.DoublyLinkedList;
import com.prep.ds.TernaryTree;
public class DLLFromTernaryTree 
{
	static DoublyLinkedList<TernaryTree<Integer>> DLL=null;
	public static void main(String[] args) {
		TernaryTree<Integer> root=new TernaryTree<Integer>(30);
		root.setLeft(new TernaryTree<Integer>(5));
		root.setMiddle(new TernaryTree<Integer>(11));
		root.setRight(new TernaryTree<Integer>(63));
		root.getLeft().setLeft(new TernaryTree<Integer>(1));
		root.getLeft().setMiddle(new TernaryTree<Integer>(4));
		root.getLeft().setRight(new TernaryTree<Integer>(8));
		root.getMiddle().setLeft(new TernaryTree<Integer>(6));
		root.getMiddle().setMiddle(new TernaryTree<Integer>(7));
		root.getMiddle().setRight(new TernaryTree<Integer>(15));
		root.getRight().setLeft(new TernaryTree<Integer>(31));
		root.getRight().setMiddle(new TernaryTree<Integer>(55));
		root.getRight().setRight(new TernaryTree<Integer>(65));
		
		constructDLL(root);
		DoublyLinkedList<TernaryTree<Integer>> node=DLL;
		while(node!=null)
		{
			System.out.print(node.getData());
			node=node.getPrev();
		}
	}
	private static void constructDLL(TernaryTree<Integer> root) {
		
		if(root==null)
			return;
		if(DLL==null)
		{
			DLL=new DoublyLinkedList<TernaryTree<Integer>>(root);
		}
		else
		{
			DoublyLinkedList<TernaryTree<Integer>> node=new DoublyLinkedList<TernaryTree<Integer>>(root);
			DLL.setNext(node);
			node.setPrev(DLL);
			DLL=node;
		}
		constructDLL(root.getLeft());
		constructDLL(root.getMiddle());
		constructDLL(root.getRight());
	}
	
}
