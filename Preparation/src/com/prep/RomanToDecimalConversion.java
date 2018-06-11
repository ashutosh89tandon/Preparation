package com.prep;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RomanToDecimalConversion 
{
	private static Map<String,Integer> rules=new HashMap<String, Integer>();
	
	public static void populateRules(){
		rules.put("I",             1);
		rules.put("IV",            4);
		rules.put("V"   ,          5);
		rules.put("IX"   ,         9);
		rules.put("X",             10);
		rules.put("XL",            40);
		rules.put("L",             50);
		rules.put("XC",            90);
		rules.put("C"     ,        100);
		rules.put("CD"     ,       400);
		rules.put("D"       ,      500);
		rules.put("CM",            900 );
		rules.put("M"           ,1000);     
	}
	
	public static void main(String[] args) 
	{
		String number="MCMIV";
		populateRules();
		int convertedDecimal=getDecimalFromRoman(number);
		System.out.println("Decimal : "+convertedDecimal);
	}

	private static int getDecimalFromRoman(String number)
	{
		int decimal=0;
		
		for(int i=number.length()-1;i>=0;)
		{
			Stack<String> stack=new Stack<String>();
			stack.push(number.charAt(i)+"");
			String copy=null;
			while(rules.containsKey(stack.peek()) && i>=0)
			{
				copy=stack.pop();
				i=i-1;
				if(i<0)
					break;
				String str=number.charAt(i)+copy;
				stack.push(str);
			}
			
			decimal+=rules.get(copy);
			
		}
		
		return decimal;
	}
	
	
}
