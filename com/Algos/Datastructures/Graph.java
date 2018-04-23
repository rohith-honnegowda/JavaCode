package com.Algos.Datastructures;

import java.util.LinkedList;

public class Graph {

	int V;
	LinkedList<Integer>[] adjList;
	
	public Graph(int V) {
		this.V = V;
		adjList = new LinkedList[V];
		
		for(int i = 0; i < V; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int src, int dest) {
		this.adjList[src].addFirst(dest);
		this.adjList[dest].addFirst(src);
	}
	
	public void displayGraph(Graph graph) {
		System.out.println();
		for(int i = 0; i < graph.V; i++) {
	        //System.out.println("Adjacency list of vertex "+ i);
	        System.out.print("head");
			for(Integer v: adjList[i]){
				System.out.print(" -> "+v);
			}
			System.out.println();
		}
	}
	
	public void BFS(int s) {
		boolean[] visited = new boolean[this.V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		queue.add(s);
		visited[s] = true;
		
		while(!queue.isEmpty()) {
			s = queue.poll();
			System.out.print(s + " ");
			LinkedList<Integer> nodes = this.adjList[s];
			for(Integer i: nodes) {
				if(!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
	

	public void DFSUtil(boolean[] visited, int s) {
		visited[s] = true;
		System.out.print(s + " -> ");
		LinkedList<Integer> nodes = this.adjList[s];
		for(Integer i: nodes) {
			if(!visited[i]) {
				DFSUtil(visited, i);
			}
		}
	}
	
	public void DFS(int s) {
		boolean[] visited = new boolean[this.V];
		visited[s] = true;
		DFSUtil(visited, s);
			
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int V = 4;
        Graph graph = new Graph(V);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        //graph.addEdge(3, 3);
        //graph.addEdge(3, 3);
        //graph.addEdge(3, 4);
      //graph.BFS(2);
        // print the adjacency list representation of 
        // the above graph
        //graph.displayGraph(graph);
        graph.DFS(2);
        //graph.addEdge(3, 4);
      graph.BFS(2);
        // print the adjacency list representation of 
        // the above graph
        graph.displayGraph(graph);

	}

}
