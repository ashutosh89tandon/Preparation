package com.amazon.preparation.ds;

import java.util.Stack;

public class ReverseStack 
{
	
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		reverse(stack);
		System.out.println(stack);
		
	}

	private static void reverse(Stack<Integer> stack) 
	{
		if(!stack.isEmpty())
		{
			int value=stack.peek();
			stack.pop();
			reverse(stack);
			insert_at_bottom(value,stack);
		}
	}
	
	static void insert_at_bottom(int x,Stack<Integer> st)
    {
 
        if(st.isEmpty())
            st.push(x);
 
        else
        {
             
            // All items are held in Function
            // Call Stack until we reach end
            // of the stack. When the stack becomes
            // empty, the st.size() becomes 0, the
            // above if part is executed and 
            // the item is inserted at the bottom
            int a = st.peek();
            st.pop();
            insert_at_bottom(x,st);
 
            // push allthe items held 
            // in Function Call Stack
            // once the item is inserted 
            // at the bottom
            st.push(a);
        }
    }
}
