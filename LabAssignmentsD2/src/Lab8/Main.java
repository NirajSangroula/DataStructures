	/**
	 * Assignment 8
	 * Name: Niraj Sangroula
	 * Course: COSC 2007T
	 * Student No: 219886770
	 * email: nsangroula@algomau.ca
	 */
package Lab8;

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
		
		try {
			System.out.println("Original graph\nusing DFS: ");
			g.useDFS(0);
			g.display();
			

			System.out.println("using BFS: ");
			g.useBFS(0);
			g.display();
			Graph spanningGraph = new Graph(9);
			spanningGraph.adjList.addAll(g.bfsSpanningEdge);
			for(EdgeNode e : g.bfsSpanningEdge) {
				spanningGraph.addEdge(e.edge.u, e.edge.v, e.edge.getWeight());
			}
			System.out.println();
			System.out.println("Spanning graph\nusing BFS: ");
			spanningGraph.useBFS(0);
			spanningGraph.display();
			System.out.println("using DFS");
			spanningGraph.useDFS(0);
			spanningGraph.display();
			
		} catch (QueueException e) {
			System.out.println(e);
		}
		
		
		
	}

}
