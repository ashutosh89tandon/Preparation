package mustdolist.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.prep.ds.BinaryTree;

public class SummedArray {
	public static void main(String[] args) {
		BinaryTree<Integer> root=new BinaryTree<>(10);
		root.setLeft(new BinaryTree<>(6));
		root.setRight(new BinaryTree<>(9));
		root.getLeft().setLeft(new BinaryTree<>(4));
		root.getLeft().setRight(new BinaryTree<>(5));
		root.getRight().setLeft(new BinaryTree<>(7));
		root.getRight().setRight(new BinaryTree<>(1));
		getSummedTree(root);
		print(root);
	}

	private static void getSummedTree(BinaryTree<Integer> root) {
		if(root==null)
			return;
		
		int oldSum=sumUpNode(root);
		getSummedTree(root.getLeft());
		getSummedTree(root.getRight());
		if(root.getLeft()==null && root.getRight()==null)
			root.setData(0);
		else
		{
			int newSum=sumUpNode(root);
			root.setData(newSum+oldSum);
		}
	}
	
	private static int sumUpNode(BinaryTree<Integer> root) {
		int sum=0;
		if(root.getLeft()!=null)
			sum+=root.getLeft().getData();
		if(root.getRight()!=null)
			sum+=root.getRight().getData();
		return sum;
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
