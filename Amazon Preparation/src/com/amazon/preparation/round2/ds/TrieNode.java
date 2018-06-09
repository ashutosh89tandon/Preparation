package com.amazon.preparation.round2.ds;

import java.util.HashMap;
import java.util.Map;

public class TrieNode 
{
	Character pointer;
	boolean isEnd;
	Map<Character,TrieNode> childNodes=new HashMap<Character,TrieNode>();
	public Character getPointer() {
		return pointer;
	}
	public void setPointer(Character pointer) {
		this.pointer = pointer;
	}
	public boolean isEnd() {
		return isEnd;
	}
	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}
	public Map<Character,TrieNode> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(Map<Character,TrieNode> childNodes) {
		this.childNodes = childNodes;
	}
	public TrieNode(Character pointer, boolean isEnd) {
		super();
		this.pointer = pointer;
		this.isEnd = isEnd;
	}
	public TrieNode() {
		super();
	}
	@Override
	public String toString() {
		return "TrieNode [pointer=" + pointer + ", isEnd=" + isEnd + ", childNodes=" + childNodes + "]";
	}
	
	
}
