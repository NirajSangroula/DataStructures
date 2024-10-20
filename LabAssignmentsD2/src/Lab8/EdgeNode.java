	/**
	 * Assignment 8
	 * Name: Niraj Sangroula
	 * Course: COSC 2007T
	 * Student No: 219886770
	 * email: nsangroula@algomau.ca
	 */
package Lab8;

public class EdgeNode {
	EdgeNode next;
	Edge edge;
	public EdgeNode() {
		next = null;
		edge = null;
	}
	public EdgeNode(Edge edge) {
		this.edge = edge;
	}
}
