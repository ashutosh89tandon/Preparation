package mustdolist.binarytree;

import java.util.Map.Entry;
import java.util.TreeMap;

import com.prep.ds.BinaryTree;

public class BottomView 
{
	static TreeMap<Integer,BinaryTree<Integer>> map=new TreeMap<>();
	public static void main(String[] args) {
		
		BinaryTree<Integer> root=new BinaryTree<Integer>(20);
		root.setLeft(new BinaryTree<Integer>(8));
		root.setRight(new BinaryTree<Integer>(22));
		root.getLeft().setLeft(new BinaryTree<Integer>(5));
		root.getLeft().setRight(new BinaryTree<Integer>(3));
		root.getLeft().getRight().setLeft(new BinaryTree<Integer>(10));
		root.getLeft().getRight().setRight(new BinaryTree<Integer>(14));
		root.getRight().setRight(new BinaryTree<Integer>(25));
		findBottomView(root,0,0);
		
		for(Entry<Integer,BinaryTree<Integer>> entry: map.entrySet())
			System.out.print(entry.getValue().getData()+ " ");
		
	}
	private static void findBottomView(BinaryTree<Integer> root, int level, int index) {
		if(root==null)
			return;
		
		root.setLevel(level);
		if(map.get(index)==null)
		{
			map.put(index, root);
		}
		else
		{
			if(root.getLevel()>map.get(index).getLevel())
				map.put(index, root);
		}
		findBottomView(root.getLeft(), level+1, index-1);
		findBottomView(root.getRight(), level+1, index+1);
	}
}
