package com.prep.ds.tree;

import java.util.Arrays;
import java.util.List;

import com.prep.ds.BinaryTree;

public class ExpressionTree
{
	private static List<String> operators=Arrays.asList("+","-","*","/","^");
	public static void main(String[] args) {
		
		BinaryTree<String> root=new BinaryTree<String>("+", 0);
		root.setLeft(new BinaryTree<String>("3", 1));
		root.setRight(new BinaryTree<String>("*",1));
		root.getRight().setLeft(new BinaryTree<String>("+", 2));
		root.getRight().setRight(new BinaryTree<String>("2", 2));
		root.getRight().getLeft().setLeft(new BinaryTree<String>("5", 2));
		root.getRight().getLeft().setRight(new BinaryTree<String>("9", 2));
		System.out.println("Value : "+getExpressionValue(root));
	}

	private static String getExpressionValue(BinaryTree<String> node)
	{
		if(node==null)
		{
			return null;
		}
		
		BinaryTree<String> left=node.getLeft();
		BinaryTree<String> right=node.getRight();
		if(operators.contains(node.getData()))
		{
			node.setData(performOperation(getExpressionValue(left),getExpressionValue(right),node.getData()));
		}
		return node.getData();
	}

	private static String performOperation(String left, String right, String operator) 
	{
		if(left==null || right==null)
			return null;
		int leftValue=Integer.parseInt(left);
		int rightValue=Integer.parseInt(right);
		switch(operator)
		{
			case "+": 
				return (leftValue+rightValue)+"";
			case "-": 
				return (leftValue-rightValue)+"";
			case "*": 
				return (leftValue*rightValue)+"";
			case "/": 
				return (leftValue/rightValue)+"";
			case "^": 
				return (leftValue^rightValue)+"";
		}
		return null;
	}
}
