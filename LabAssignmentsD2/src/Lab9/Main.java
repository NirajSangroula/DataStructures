	/**
	 * Assignment 9
	 * Name: Niraj Sangroula
	 * Course: COSC 2007T
	 * Student No: 219886770
	 * email: nsangroula@algomau.ca
	 */
package Lab9;

import java.util.ArrayList;



public class Main {

	public static void main(String[] args) {
			Graph g = new Graph(9);
			g.addEdge(0, 8, 2);
			g.addEdge(0, 1, 6);
			g.addEdge(0, 5, 4);
			g.addEdge(1, 4, 9);
			g.addEdge(1, 2, 7);
			g.addEdge(2, 3, 4);
			g.addEdge(3, 7, 1);
			g.addEdge(3, 6, 5);
			g.addEdge(5, 6, 2);
			g.addEdge(4, 2, 3);
			g.addEdge(4, 6, 8);
			

			g.addEdge(8, 0, 2);
			g.addEdge(1, 0, 6);
			g.addEdge(5, 0, 4);
			g.addEdge(4, 1, 9);
			g.addEdge(2, 1, 7);
			g.addEdge(3, 2, 4);
			g.addEdge(7, 3, 1);
			g.addEdge(6, 3, 5);
			g.addEdge(6, 5, 2);
			g.addEdge(2, 4, 3);
			g.addEdge(6, 4, 8);
				
				g.useDFS(0);
				g.display();
				
				Graph sp = primsAlgorithm(0, g);
				
				System.out.println("Applying prim's algorithm, spanning graph: ");
				sp.useDFS(0);
				sp.display();
	}
	
	public static boolean hasUnvisitedVertices(ArrayList<String> visited, Graph graph) {
		return(visited.size() != graph.getNoOfVertices());
	}
	
	public static Graph primsAlgorithm(int vertex, Graph g) {

		ArrayList<String> visited = new ArrayList<>();
		ArrayList<Node> spanningEdge = new ArrayList<>();
		visited.add(String.valueOf(vertex));
		while(hasUnvisitedVertices(visited, g)) {
			int minW = 9999999;
			Node edge = null;
			for(String i : visited) {
				for(Node n = g.adjList.get(Integer.valueOf(i)); n != null && n.edge != null; n = n.next) {
					if(!visited.contains(String.valueOf(n.edge.v)))
						if(n.edge.weight < minW) {
							edge = n;
							minW = n.edge.weight;
						}
				}
			}
			
			//We have minimum spanning path u to v
			spanningEdge.add(edge);
			
			visited.add(String.valueOf(edge.edge.getV())); // Add v, which is next vertex to visited
			
		}
		Graph spanningGraph = new Graph(g.getNoOfVertices());
		//spanningGraph.adjList.addAll(spanningEdge);
		for(Node e : spanningEdge) {
			spanningGraph.addEdge(e.edge.u, e.edge.v, e.edge.getWeight());
		}
		return spanningGraph;
		
	}

}
