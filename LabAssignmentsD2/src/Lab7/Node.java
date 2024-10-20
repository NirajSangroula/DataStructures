	/**
	 * Assignment 7
	 * Name: Niraj Sangroula
	 * Course: COSC 2007T
	 * Student No: 219886770
	 * email: nsangroula@algomau.ca
	 */
package Lab7;

public class Node {
	Node next;
	Edge edge;
	public Node() {
		next = null;
		edge = null;
	}
	public Node(Edge edge) {
		this.edge = edge;
	}
}
