package com.amazon.preparation.round2;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class TopologicalSort {
	public static void main(String[] args) {
		 Topology g = new Topology(6);
	        g.addEdge(5, 2);
	        g.addEdge(5, 0);
	        g.addEdge(4, 0);
	        g.addEdge(4, 1);
	        g.addEdge(2, 3);
	        g.addEdge(3, 1);
	        g.DFS();
	}
}

class Topology
{
	int vertices;
	LinkedList<Integer> adj[]=null;
	
	public Topology(int v)
	{
		vertices=v;
		adj =new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i]=new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int vertex, int edge)
	{
		adj[vertex].add(edge);
	}
	
	public void DFS()
	{
		Stack<Integer> stack=new Stack<Integer>();
		boolean[] visited=new boolean[vertices];
		for(int i=0;i<vertices;i++)
		{
			if(!visited[i])
			DFSUtil(i,visited,stack);
		}
		
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop()+"->");
		}
	}

	private void DFSUtil(int vertex, boolean[] visited,Stack<Integer> stack) 
	{
		visited[vertex]=true;
		ListIterator<Integer> iter=adj[vertex].listIterator();
		
		while(iter.hasNext())
		{
			int n=iter.next();
			if(!visited[n])
				DFSUtil(n,visited,stack);
		}
		
		stack.push(vertex);
		
		
	}
	
}
