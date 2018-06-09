package com.amazon.preparation.round2;

import java.util.LinkedList;
import java.util.ListIterator;

public class DFSExample 
{
	public static void main(String[] args) {
		Graph g=new Graph(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.DFS(2);
	}
}

class Graph
{
	int vertices;
	LinkedList<Integer> adj[]=null;
	
	public Graph(int v)
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
	
	public void DFS(int vertex)
	{
		boolean[] visited=new boolean[vertices];
		DFSUtil(vertex,visited);
	}

	private void DFSUtil(int vertex, boolean[] visited) 
	{
		visited[vertex]=true;
		System.out.print(vertex+"->");
		ListIterator<Integer> iter=adj[vertex].listIterator();
		
		while(iter.hasNext())
		{
			int n=iter.next();
			if(!visited[n])
				DFSUtil(n,visited);
		}
		
		
	}
	
}
