	/**
	 * Assignment 8
	 * Name: Niraj Sangroula
	 * Course: COSC 2007T
	 * Student No: 219886770
	 * email: nsangroula@algomau.ca
	 */
package Lab8;

import java.util.ArrayList;
import java.util.Stack;

public class Graph {
	static final String INFINITY = "INFINITY";
	int noOfVertices;
	int noOfEdges;
	String[][] adjMatrix;
	ArrayList<EdgeNode> adjList= new ArrayList<EdgeNode>();
	ArrayList<Integer> items = new ArrayList<Integer>();
	Stack<Integer> currentServing = new Stack<>();
	Queue<Integer> currentQueue = new Queue<>();
	ArrayList<Integer> visited = new ArrayList<>();
	ArrayList<EdgeNode> bfsSpanningEdge= new ArrayList<EdgeNode>();
	
	public Graph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		noOfEdges = 0;
		adjMatrix = new String[noOfVertices][noOfVertices];
		//Create adjMatrix and adjLists
		for(int i = 0; i < noOfVertices; i++) {
			for(int j = 0; j < noOfVertices; j++) {
				adjMatrix[i][j] = INFINITY;
			}
		}
		
		for(int i = 0; i < noOfVertices; i++) {
			EdgeNode n = new EdgeNode();
			adjList.add(n);
		}
	}

	public int getNoOfVertices() {
		return noOfVertices;
	}

	public int getNoOfEdges() {
		return noOfEdges;
	}
	
	public void addEdge(int u, int v, int weight) {
		if(u < noOfVertices && v < noOfVertices) {
			//For adjMatrix method
			adjMatrix[u][v] = String.valueOf(weight); 
			
			//For adjList,
			Edge edge = new Edge(u, v, weight);
			//For first edge
			EdgeNode firstEdgeNode = adjList.get(u);
			if(firstEdgeNode.edge == null)
				firstEdgeNode.edge = edge;
			else {
				for(EdgeNode cur = firstEdgeNode; cur != null; cur = cur.next) {
					if(cur.next == null) {
						cur.next = new EdgeNode(new Edge(u, v, weight));
						break;
					}
				}
			}
			noOfEdges++;
		}
		else
			throw new RuntimeException("Wrong vertex number");
	}
	
	public void removeEdge(int u, int v) {
		//Using adjacent matrix
		if(adjMatrix[u][v] != Graph.INFINITY) {
			adjMatrix[u][v] = Graph.INFINITY;
		}
		else
			throw new RuntimeException("Edge doesn't exist");
		
		//Using adjacent list
		//For only element matching
		if(adjList.get(u).next == null && (adjList.get(u).edge.u == u && adjList.get(u).edge.v == v))
			adjList.get(u).edge = null;
		else if((adjList.get(u).edge.u == u && adjList.get(u).edge.v == v)) {
			//For first element,
			adjList.set(u, adjList.get(u).next);
		}
		else
			for(EdgeNode n = adjList.get(u); n != null; n = n.next) {
				if(n.next.edge.u == u && n.next.edge.v == v) {
					n.next = n.next.next;
				}
			}
	}
	
	public void useDFS(int u) {
		this.items.clear();
		dfs(u);
		this.currentServing.clear();
		this.visited.clear();
	}
	
	private void dfs(int u) {
		items.add(u); //Visit item first
		visited.add(u); //Mark item
		currentServing.push(u);
		while(!currentServing.isEmpty()){
			String next = nextUnvisitedNode(currentServing.peek());
			if(next != INFINITY) {
				dfs(Integer.parseInt(next));
			}
			else
				currentServing.pop();
		}
		
	}

	
	public void useBFS(int u) throws QueueException {
		this.items.clear();
		this.bfsSpanningEdge.clear();
		bfs(u);
		this.currentServing.clear();
		this.visited.clear();
	}
	private void bfs(int u) throws QueueException {
		items.add(u);
		visited.add(u);
		currentQueue.enqueue(u);
		while(!currentQueue.isEmpty()) {
			int w = currentQueue.dequeue();	
			for(EdgeNode cur = adjList.get(w); cur != null && cur.edge != null; cur = cur.next) {
				if(!visited.contains(cur.edge.v)) {
					this.bfsSpanningEdge.add(cur);
					items.add(cur.edge.v);
					visited.add(cur.edge.v);
					currentQueue.enqueue(cur.edge.v);
				}
			}
		}
	}

	private String nextUnvisitedNode(Integer u) {
		for(EdgeNode cur = adjList.get(u); cur != null && cur.edge != null; cur = cur.next) {
			if(!visited.contains(cur.edge.v))
				return String.valueOf(cur.edge.v);
		}
		return INFINITY;
	}
	
	public void display() {
		for(int p : items) {
			System.out.print((char)(('A' + p)) + "\t");
		}
		System.out.println();
	}
	
	
	
	
}
