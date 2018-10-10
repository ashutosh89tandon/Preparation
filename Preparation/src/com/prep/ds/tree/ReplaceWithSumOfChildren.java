package com.prep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.prep.ds.BinaryTree;
import com.prep.ds.DoublyLinkedList;

public class ReplaceWithSumOfChildren 
{
	private static DoublyLinkedList<BinaryTree<Integer>> node=null;
	private static DoublyLinkedList<BinaryTree<Integer>> head=null;
	public static void main(String[] args) {
		BinaryTree<Integer> root=new BinaryTree<Integer>(1, 0);
		root.setLeft(new BinaryTree<Integer>(2, 1));
		root.setRight(new BinaryTree<Integer>(3,1));
		root.getLeft().setLeft(new BinaryTree<Integer>(4, 2));
		root.getLeft().setRight(new BinaryTree<Integer>(5,2));
		root.getRight().setLeft(new BinaryTree<Integer>(6, 2));
		root.getRight().setRight(new BinaryTree<Integer>(7,2));
		update(root);
		print(root);
	
	}
	
	private static void print(BinaryTree<Integer> root) 
	{
		Queue<BinaryTree<Integer>> queue=new LinkedList<BinaryTree<Integer>>();
		queue.offer(root);
		while(!queue.isEmpty())
		{
			BinaryTree<Integer> tempNode=queue.poll();
			System.out.print(tempNode.getSummedValue()+"->");
			BinaryTree<Integer> left=tempNode.getLeft();
			BinaryTree<Integer> right=tempNode.getRight();
			
			if(left!=null)
				queue.offer(left);
			if(right!=null)
				queue.offer(right);
		}
	}

	private static void update(BinaryTree<Integer> root) 
	{
		populateInorder(root);
		updateValue(root);
	}

	private static void updateValue(BinaryTree<Integer> node) 
	{
		if(node==null)
			return;
		node.setSummedValue(setDataValue(node));
		updateValue(node.getLeft());
		updateValue(node.getRight());
	}

	private static Integer setDataValue(BinaryTree<Integer> node) 
	{
		DoublyLinkedList<BinaryTree<Integer>> temp=head;
		while(temp!=null)
		{
			if(node==temp.getData())
				break;
			temp=temp.getNext();
		}
		
		if(node!=null)
		{
			return (temp.getPrev()==null?0:temp.getPrev().getData().getData())+
					(temp.getNext()==null?0:temp.getNext().getData().getData());
		}
		return null;
	}

	private static void populateInorder(BinaryTree<Integer> root) 
	{
		if(root==null)
			return;
		
		populateInorder(root.getLeft());
		DoublyLinkedList<BinaryTree<Integer>> tempNode=new DoublyLinkedList<>(root);
		if(node==null)
		{
			node=tempNode;
			head=node;
		}
		else
		{
			tempNode.setPrev(node);
			node.setNext(tempNode);
			node=tempNode;
		}
		populateInorder(root.getRight());
	}
}
