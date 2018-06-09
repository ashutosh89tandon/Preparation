package com.amazon.preparation.round2.ds;

public class Trie 
{
	static TrieNode root=new TrieNode();
	public static void main(String[] args) 
	{
		root.setEnd(false);
		root.setPointer(null);	
		System.out.println("Insertion : "+insert("Hello"));
		System.out.println("Insertion : "+insert("Hell"));
		System.out.println("Insertion : "+insert("Sister"));
		System.out.println("Insertion : "+insert("Sis"));
		
		System.out.println("Search :"+search("Sist"));
		System.out.println("Search :"+search("Sis"));
		System.out.println("Search :"+search("Hell"));
		System.out.println("Search :"+search("Hello"));
	}
	
	public static boolean search(String word)
	{
		boolean result=true;
		TrieNode node=root;
		for(int i=0;i<word.length();i++)
		{
			Character character=word.charAt(i);
			boolean isEnd=i==(word.length()-1);
			if(node.getChildNodes().get(character)==null)
			{
				result=false;
				break;
			}
			
			if(isEnd)
			{
				if(!node.getChildNodes().get(character).isEnd)
				{
					result=false;
				}
			}	
			node=node.getChildNodes().get(character);
		}
		
		return result;
	}
	
	public static boolean insert(String word)
	{
		boolean inserted=true;
		TrieNode node=root;
		for(int i=0;i<word.length();i++)
		{
			Character character=word.charAt(i);
			boolean isEnd=i==(word.length()-1);
			if(node.getChildNodes().get(character)==null)
			{
				node.getChildNodes().put(character, new TrieNode(character,isEnd));
				inserted=true;
			}
			else
			{
				inserted=false;
			}
			
			if(isEnd)
			{
				node.getChildNodes().get(character).setEnd(isEnd);
			}
			node=node.getChildNodes().get(character);
		}
		
		return inserted;
	}
}
