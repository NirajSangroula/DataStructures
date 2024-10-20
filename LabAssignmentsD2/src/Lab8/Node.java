	/**
	 * Assignment 8
	 * Name: Niraj Sangroula
	 * Course: COSC 2007T
	 * Student No: 219886770
	 * email: nsangroula@algomau.ca
	 */
package Lab8;

public class Node<T> {
	T data;
	Node next;

	public Node(T data) {
		this.data = data;
	}
	
	public Node(T data, Node next) {
		this(data);
		this.next = next;
	}
}
