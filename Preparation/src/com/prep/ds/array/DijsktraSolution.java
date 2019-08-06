package com.prep.ds.array;

public class DijsktraSolution {

	public static void main(String[] args)
	{
		 int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
                 {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                 {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                 {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                 {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                 {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                 {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                 {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                 {0, 0, 2, 0, 0, 0, 6, 7, 0} 
                }; 

		 dijkstra(graph, 0); 
	}

	private static void dijkstra(int[][] graph, int source) {
		
		boolean[][] visitMatrix=new boolean[graph.length][graph.length];
		int distance[]=new int[graph.length];
		distance[source]=0;
		visitMatrix[source][source]=true;
		int v=graph.length;
		for(int i=0;i<v;i++)
		{
			if(source==i)
				continue;
			distance[i]=graph[source][i]==0?Integer.MAX_VALUE:graph[source][i];
		}
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				if(graph[i][j]==0)
					continue;
				int oldDistance=distance[j];
				int newDistance=distance[i]+graph[i][j];
				if(!visitMatrix[i][j])
				{
					visitMatrix[i][j]=true;
					if(newDistance<oldDistance)
					{
						distance[j]=newDistance;
						backBridge(j,graph,distance);
					}
				}
			}
		}
		
		printSolution(distance,source);
		
	}

	private static void backBridge(int currentIndex, int[][] graph, int[] distance) 
	{
		for(int i=currentIndex-1;i>=0;i--)
		{
			if(graph[currentIndex][i]!=0 && distance[i]>distance[currentIndex]+graph[currentIndex][i])
			{
					distance[i]=distance[currentIndex]+graph[currentIndex][i];
					backBridge(i, graph, distance);
			}
					
				
		}
	}

	private static void printSolution(int[] distance,int source) {
		for(int i=0;i<distance.length;i++)
		{
			System.out.println(source+"->"+i+" = "+distance[i]);
		}
		
	}
}	
