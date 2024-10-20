	/**
	 * Assignment 9
	 * Name: Niraj Sangroula
	 * Course: COSC 2007T
	 * Student No: 219886770
	 * email: nsangroula@algomau.ca
	 */
package Lab9;

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
