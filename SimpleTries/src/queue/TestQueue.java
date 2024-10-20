package queue;

public class TestQueue {

	public static void main(String[] args) {
		ArrayQueue q = new ArrayQueue(5);
		q.enqueue("Niraj");
		q.display();
		System.out.println();
		q.enqueue("Nitesh");
		q.enqueue("Other");
		q.display();
		System.out.println();
		q.enqueue("Nitesh");
		q.enqueue("Other");
		q.display();
		System.out.println();
		System.out.println();

		q.dequeue();
		q.display();
		System.out.println();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.display();
		System.out.println();
		

		q.enqueue(".k");
		q.enqueue(".n");
		q.display();
		System.out.println();
		
		q.dequeue();
		q.display();
		System.out.println();
		q.dequeue();
		q.display();
		System.out.println();
		q.dequeue();
		q.display();
		System.out.println();
		q.dequeue();

	}

}
