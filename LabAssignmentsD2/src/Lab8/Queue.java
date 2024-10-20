
	/**
	 * Assignment 8
	 * Name: Niraj Sangroula
	 * Course: COSC 2007T
	 * Student No: 219886770
	 * email: nsangroula@algomau.ca
	 */
package Lab8;


public class Queue<T> {
	Node<T> front;
	Node<T> back;
	public Queue(){
		
	}
	public boolean isEmpty() {
		return (front == null);
	}
	// Determines whether a queue is empty.
	public void enqueue(T item) throws QueueException{
		if(isEmpty()) {
			front = back = new Node<T>(item);
		}
		else {
			back.next = new Node<T>(item);
			back = back.next;
		}
	}

	// Retrieves and removes the front of a queue—the
	// item that was added earliest. Throws QueueException
	// if the operation is not successful.
	public T dequeue() throws QueueException{
		T ret = peek();
		if(isEmpty()) {
			throw new QueueException("Queue is empty. Cannot Dequeue");
		}
		else {
			front = front.next;
			//If front became null, empty the back too
			if(isEmpty()) {
				back = null;
			}
		}
		return ret;
	}
	public void dequeueAll() {
		front = back = null;
	}
	

	public T peek() throws QueueException{
		if(isEmpty())
			throw new QueueException("Queue is empty. Cannot peek");		
		return front.data;
	}
}
