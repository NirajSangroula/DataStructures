package Lab1;

public class QueueNode<T> {
	T data;
	QueueNode next;

	public QueueNode(T data) {
		this.data = data;
	}
	
	public QueueNode(T data, QueueNode next) {
		this(data);
		this.next = next;
	}
}
