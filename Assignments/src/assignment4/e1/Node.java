package assignment4.e1;

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
