package com.prep.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Graph 
{
	LinkedList<Integer>[] adjacencyGraph=null;
	boolean vertex[]=null;
	
	@SuppressWarnings("unchecked")
	public Graph(int capacity) {
		super();
		adjacencyGraph=new LinkedList[capacity];
		vertex=new boolean[capacity];
		for(int i=0;i<capacity;i++)
			vertex[i]=false;
	}

	public static void main(String args[]) 
	{ 
		// Create a graph given in the above diagram 
		Graph g1 = new Graph(5); 
		g1.addEdge(1, 0); 
		g1.addEdge(0, 2); 
		g1.addEdge(0, 3); 
		g1.addEdge(3, 4); 
		if (g1.isTree(1)) 
			System.out.println("Graph is Tree"); 
		else
			System.out.println("Graph is not Tree"); 

		Graph g2 = new Graph(5); 
		g2.addEdge(1, 0); 
		g2.addEdge(0, 2); 
		g2.addEdge(2, 1); 
		g2.addEdge(0, 3); 
		g2.addEdge(3, 4); 

		if (g2.isTree(1)) 
			System.out.println("Graph is Tree"); 
		else
			System.out.println("Graph is not Tree"); 

	}

	private boolean isTree(int start) 
	{
		if(adjacencyGraph==null || adjacencyGraph.length==1 || adjacencyGraph.length==0 )
			return true;
		Queue<Integer> queue=new LinkedList<>();
		queue.offer(start);
		while(!queue.isEmpty())
		{
			int i=queue.poll();
			if(vertex[i])
				return false;
			vertex[i]=true;
			if(adjacencyGraph[i]!=null)
				while(!adjacencyGraph[i].isEmpty())
					queue.offer(adjacencyGraph[i].poll());
		}
		
		for(int i=0;i<vertex.length;i++)
			if(!vertex[i])
				return false;
		
		return true;
		
	}

	private void addEdge(int i, int j) 
	{
		if(adjacencyGraph[i]==null)
			adjacencyGraph[i]=new LinkedList<>();
		adjacencyGraph[i].offer(j);
	} 

}
