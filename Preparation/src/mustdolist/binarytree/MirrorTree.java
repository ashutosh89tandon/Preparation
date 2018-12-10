package mustdolist.binarytree;

import com.prep.ds.BinaryTree;

public class MirrorTree 
{
	public static void main(String[] args) {
		BinaryTree<Integer> root=new BinaryTree<Integer>(20);
		root.setLeft(new BinaryTree<Integer>(8));
		root.setRight(new BinaryTree<Integer>(22));
		root.getLeft().setLeft(new BinaryTree<Integer>(5));
		root.getLeft().setRight(new BinaryTree<Integer>(3));
		root.getLeft().getRight().setLeft(new BinaryTree<Integer>(10));
		root.getLeft().getRight().setRight(new BinaryTree<Integer>(14));
		root.getRight().setRight(new BinaryTree<Integer>(25));
		BinaryTree<Integer> newRoot=new BinaryTree<Integer>(20);
		findMirrorTree(root,newRoot);
		System.out.println(newRoot);
	}

	private static void findMirrorTree(BinaryTree<Integer> root, BinaryTree<Integer> newRoot) {
		if(root==null)
			return;
		
		if(root.getRight()!=null)
			newRoot.setLeft(new BinaryTree<Integer>(root.getRight().getData()));
		if(root.getLeft()!=null)
			newRoot.setRight(new BinaryTree<Integer>(root.getLeft().getData()));
		
		findMirrorTree(root.getLeft(), newRoot.getRight());
		findMirrorTree(root.getRight(), newRoot.getLeft());
		
	}
}
