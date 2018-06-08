package com.prep;

import java.util.Stack;

public class FindMatchingParanthesis 
{
	public static void main(String[] args) {
		String str="{hello{Raj}}";
		System.out.println(isParanthesisComplete(str));
	}
	
	private static boolean isParanthesisComplete(String str)
	{
		Stack<Character> stack=new Stack<Character>();
		
		for(char c: str.toCharArray())
		{
			if(c=='{')
				stack.push(c);
			
			if(c=='}')
			{
				if(stack.isEmpty())
					return false;
				stack.pop();
			}
		}
		
		if(stack.isEmpty())
			return true;
		
		return false;
	}
}
