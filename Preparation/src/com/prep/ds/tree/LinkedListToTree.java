package com.prep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.prep.ds.BinaryTree;
import com.prep.ds.DoublyLinkedList;

public class LinkedListToTree 
{
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dl=new DoublyLinkedList<>(10);
		dl.setNext(new DoublyLinkedList<>(12));
		dl.getNext().setNext(new DoublyLinkedList<>(15));
		dl.getNext().getNext().setNext(new DoublyLinkedList<>(25));
		dl.getNext().getNext().getNext().setNext(new DoublyLinkedList<>(30));
		dl.getNext().getNext().getNext().getNext().setNext(new DoublyLinkedList<>(36));
		BinaryTree<Integer> root=createTree(dl);
		print(root);
	}

	private static BinaryTree<Integer> createTree(DoublyLinkedList<Integer> dl) 
	{
		DoublyLinkedList<Integer> temp=dl;
		Queue<BinaryTree<Integer>> queue=new LinkedList<>();
		BinaryTree<Integer> root=new BinaryTree<Integer>(temp.getData());
		temp=temp.getNext();
		queue.offer(root);
		
		while(temp!=null)
		{
			BinaryTree<Integer> node=queue.poll();
			node.setLeft(new BinaryTree<Integer>(temp.getData()));
			queue.offer(node.getLeft());
			if(temp.getNext()==null)
			{
				break;
			}
			temp=temp.getNext();
			node.setRight(new BinaryTree<Integer>(temp.getData()));
			queue.offer(node.getRight());
			temp=temp.getNext();
		}
		return root;
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
