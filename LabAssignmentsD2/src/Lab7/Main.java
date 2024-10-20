	/**
	 * Assignment 7
	 * Name: Niraj Sangroula
	 * Course: COSC 2007T
	 * Student No: 219886770
	 * email: nsangroula@algomau.ca
	 */
package Lab7;

public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 3, 1);
		graph.addEdge(1, 2, 1);
		graph.addEdge(2, 4, 1);
		graph.addEdge(3, 2, 1);
		graph.addEdge(4, 3, 1);
		graph.addEdge(4, 5, 1);
		graph.addEdge(5, 2, 1);
		System.out.println("Edges Adjacent Matrix");
		
		for(int i = 0; i < graph.getNoOfVertices(); i++) {
			System.out.print(convertNumToAlphabet(i) + ":\t");
			for(int j = 0; j < graph.getNoOfVertices(); j++) {
				System.out.print(graph.adjMatrix[i][j] + "\t\t");
			}
			System.out.println("\n\n");
		}

		System.out.println("Edges Adjacent List");
		for(int i = 0; i < graph.getNoOfVertices(); i++) {
			for(Node j = graph.adjList.get(i); j != null; j = j.next) {
				if(j.edge != null)
					System.out.print(convertNumToAlphabet(j.edge.getU()) + "<--(" + j.edge.getWeight() + ")-->"+ convertNumToAlphabet(j.edge.getV()) + "\t\t");
			}
			System.out.println("\n\n");
		}
		
		graph.useDFS(3);
		graph.display();

	}

	private static char convertNumToAlphabet(int j) {
		return (char)(('A' + j));
	}

}
	

