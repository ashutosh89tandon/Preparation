package mustdolist.binarytree;

import com.prep.ds.BinaryTree;

public class LongestConsecutiveSequenceInBinaryTree {
	private static int maxLength=1;
	public static void main(String[] args) {
		BinaryTree<Integer> root=new BinaryTree<Integer>(6);
		root.setRight(new BinaryTree<Integer>(9));
		root.getRight().setLeft(new BinaryTree<Integer>(7));
		root.getRight().setRight(new BinaryTree<Integer>(10));
		root.getRight().getRight().setRight(new BinaryTree<Integer>(11));
		findMaxLength(root,1,root.getData());
		System.out.println(maxLength);
		
		maxLength=1;
		BinaryTree<Integer> root1=new BinaryTree<Integer>(1);
		root1.setLeft(new BinaryTree<Integer>(2));
		root1.setRight(new BinaryTree<Integer>(4));
		root1.getLeft().setLeft(new BinaryTree<Integer>(3));
		root1.getRight().setLeft(new BinaryTree<Integer>(5));
		root1.getRight().setRight(new BinaryTree<Integer>(6));
		root1.getRight().getRight().setLeft(new BinaryTree<Integer>(7));
		findMaxLength(root1,1,root1.getData());
		System.out.println(maxLength);
	}
	
	private static void findMaxLength(BinaryTree<Integer> root, int length, Integer prevValue) 
	{
		if(root== null)
		{
			if(length>maxLength)
				maxLength=length;
			return;
		}
		BinaryTree<Integer> left=root.getLeft();
		BinaryTree<Integer> right=root.getRight();
		if(left!=null)
		{
			if(prevValue+1== left.getData())
				findMaxLength(left, length+1, left.getData());
			else
			{
				if(length>maxLength)
					maxLength=length;
				findMaxLength(left, 1, left.getData());
			}
		}
		if(right!=null)
		{
			if(prevValue+1== right.getData())
				findMaxLength(right, length+1, right.getData());
			else
			{
				if(length>maxLength)
					maxLength=length;
				findMaxLength(right, 1, right.getData());
			}
		}
		
		if(length>maxLength)
			maxLength=length;
	}
}
