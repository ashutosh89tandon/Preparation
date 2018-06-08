package com.prep;

import java.util.Arrays;
import java.util.List;

import com.prep.ds.Node;

public class LeastCommonAncestor
{
	public static void main(String[] args) {
		
		Node node=new Node(10);
		node.setLeft(new Node(5));
		node.setRight(new Node(15));
		node.getLeft().setLeft(new Node(3));
		node.getLeft().setRight(new Node(7));
		node.getRight().setLeft(new Node(13));
		node.getRight().setRight(new Node(17));
		
		Node result=LCA(node, Arrays.asList(node.getLeft().getRight(),node.getLeft().getLeft()));
		System.out.println(result);
	}
	
	private static Node LCA(Node node, List<Node> nodes)
	{
		if(node ==null)
			return null;
		
		if(nodes.contains(node))
			return node;
		
		Node left=LCA(node.getLeft(),nodes);
		Node right = LCA(node.getRight(),nodes);
		
		if(left!=null && right!=null)
			return node;
		
		return left==null?right:left;
	}
}
